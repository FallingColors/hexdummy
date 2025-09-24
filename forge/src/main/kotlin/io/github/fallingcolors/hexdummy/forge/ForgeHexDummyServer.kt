package io.github.fallingcolors.hexdummy.forge

import io.github.fallingcolors.hexdummy.HexDummy
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHexDummyServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        HexDummy.initServer()
    }
}
