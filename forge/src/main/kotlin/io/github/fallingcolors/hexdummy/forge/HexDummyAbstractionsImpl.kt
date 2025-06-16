@file:JvmName("HexDummyAbstractionsImpl")

package io.github.fallingcolors.hexdummy.forge

import io.github.fallingcolors.hexdummy.registry.HexDummyRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexDummyRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
