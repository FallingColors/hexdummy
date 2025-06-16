@file:JvmName("HexDummyAbstractions")

package io.github.fallingcolors.hexdummy

import dev.architectury.injectables.annotations.ExpectPlatform
import io.github.fallingcolors.hexdummy.registry.HexDummyRegistrar

fun initRegistries(vararg registries: HexDummyRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexDummyRegistrar<T>) {
    throw AssertionError()
}
