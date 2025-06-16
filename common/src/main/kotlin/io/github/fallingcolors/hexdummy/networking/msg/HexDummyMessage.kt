package io.github.fallingcolors.hexdummy.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import io.github.fallingcolors.hexdummy.HexDummy
import io.github.fallingcolors.hexdummy.networking.HexDummyNetworking
import io.github.fallingcolors.hexdummy.networking.handler.applyOnClient
import io.github.fallingcolors.hexdummy.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexDummyMessage

sealed interface HexDummyMessageC2S : HexDummyMessage {
    fun sendToServer() {
        HexDummyNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexDummyMessageS2C : HexDummyMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexDummyNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexDummyNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexDummyMessageCompanion<T : HexDummyMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                HexDummy.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexDummyMessageC2S -> msg.applyOnServer(ctx)
                    else -> HexDummy.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                HexDummy.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexDummyMessageS2C -> msg.applyOnClient(ctx)
                    else -> HexDummy.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
