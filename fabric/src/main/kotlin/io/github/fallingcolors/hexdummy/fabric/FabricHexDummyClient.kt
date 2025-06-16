package io.github.fallingcolors.hexdummy.fabric

import io.github.fallingcolors.hexdummy.HexDummyClient
import net.fabricmc.api.ClientModInitializer

object FabricHexDummyClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexDummyClient.init()
    }
}
