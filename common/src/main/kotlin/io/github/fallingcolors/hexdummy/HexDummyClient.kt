package io.github.fallingcolors.hexdummy

import io.github.fallingcolors.hexdummy.config.HexDummyClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexDummyClient {
    fun init() {
        HexDummyClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HexDummyClientConfig.GlobalConfig::class.java, parent).get()
    }
}
