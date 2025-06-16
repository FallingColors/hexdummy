package io.github.fallingcolors.hexdummy.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import io.github.fallingcolors.hexdummy.networking.msg.*

fun HexDummyMessageC2S.applyOnServer(ctx: PacketContext) = ctx.queue {
    when (this) {
        // add server-side message handlers here
    }
}
