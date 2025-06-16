package io.github.fallingcolors.hexdummy.networking

import dev.architectury.networking.NetworkChannel
import io.github.fallingcolors.hexdummy.HexDummy
import io.github.fallingcolors.hexdummy.networking.msg.HexDummyMessageCompanion

object HexDummyNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(HexDummy.id("networking_channel"))

    fun init() {
        for (subclass in HexDummyMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
