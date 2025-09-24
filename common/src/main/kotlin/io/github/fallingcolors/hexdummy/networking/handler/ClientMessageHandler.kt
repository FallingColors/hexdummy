package io.github.fallingcolors.hexdummy.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.fallingcolors.hexdummy.config.HexDummyServerConfig
import io.github.fallingcolors.hexdummy.networking.msg.*

fun HexDummyMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexDummyServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
