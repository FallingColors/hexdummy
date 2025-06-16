package io.github.fallingcolors.hexdummy.fabric

import io.github.fallingcolors.hexdummy.HexDummy
import net.fabricmc.api.ModInitializer

object FabricHexDummy : ModInitializer {
    override fun onInitialize() {
        HexDummy.init()
    }
}
