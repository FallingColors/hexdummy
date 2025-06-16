package io.github.fallingcolors.hexdummy.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import io.github.fallingcolors.hexdummy.HexDummyClient

object FabricHexDummyModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexDummyClient::getConfigScreen)
}
