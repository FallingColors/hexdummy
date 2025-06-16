package io.github.fallingcolors.hexdummy.forge

import dev.architectury.platform.forge.EventBuses
import io.github.fallingcolors.hexdummy.HexDummy
import net.minecraft.data.DataProvider
import net.minecraft.data.DataProvider.Factory
import net.minecraft.data.PackOutput
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(HexDummy.MODID)
class HexDummyForge {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(HexDummy.MODID, this)
            addListener(ForgeHexDummyClient::init)
            addListener(::gatherData)
        }
        HexDummy.init()
    }

    private fun gatherData(event: GatherDataEvent) {
        event.apply {
            // TODO: add datagen providers here
        }
    }
}

fun <T : DataProvider> GatherDataEvent.addProvider(run: Boolean, factory: (PackOutput) -> T) =
    generator.addProvider(run, Factory { factory(it) })
