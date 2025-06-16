@file:JvmName("HexDummyAbstractionsImpl")

package io.github.fallingcolors.hexdummy.fabric

import io.github.fallingcolors.hexdummy.registry.HexDummyRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexDummyRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
