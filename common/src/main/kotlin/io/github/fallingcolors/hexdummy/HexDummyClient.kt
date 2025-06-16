package io.github.fallingcolors.hexdummy

import io.github.fallingcolors.hexdummy.config.HexDummyConfig
import io.github.fallingcolors.hexdummy.config.HexDummyConfig.GlobalConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexDummyClient {
    fun init() {
        HexDummyConfig.initClient()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(GlobalConfig::class.java, parent).get()
    }
}
