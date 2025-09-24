package io.github.fallingcolors.hexdummy.fabric

import io.github.fallingcolors.hexdummy.HexDummy
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHexDummyServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        HexDummy.initServer()
    }
}
