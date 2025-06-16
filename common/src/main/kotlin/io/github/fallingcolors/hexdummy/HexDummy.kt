package io.github.fallingcolors.hexdummy

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import io.github.fallingcolors.hexdummy.config.HexDummyConfig
import io.github.fallingcolors.hexdummy.networking.HexDummyNetworking
import io.github.fallingcolors.hexdummy.registry.HexDummyActions

object HexDummy {
    const val MODID = "hexdummy"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexDummyConfig.init()
        initRegistries(
            HexDummyActions,
        )
        HexDummyNetworking.init()
    }
}
