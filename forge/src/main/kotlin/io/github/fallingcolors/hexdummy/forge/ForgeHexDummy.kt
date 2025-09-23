package io.github.fallingcolors.hexdummy.forge

import dev.architectury.platform.forge.EventBuses
import io.github.fallingcolors.hexdummy.HexDummy
import io.github.fallingcolors.hexdummy.forge.datagen.ForgeHexDummyDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(HexDummy.MODID)
class ForgeHexDummy {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HexDummy.MODID, this)
            addListener(ForgeHexDummyClient::init)
            addListener(ForgeHexDummyDatagen::init)
        }
        HexDummy.init()
    }
}
