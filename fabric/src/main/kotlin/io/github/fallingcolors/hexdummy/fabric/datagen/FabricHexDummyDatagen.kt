package io.github.fallingcolors.hexdummy.fabric.datagen

import io.github.fallingcolors.hexdummy.datagen.HexDummyActionTags
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object FabricHexDummyDatagen : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        val pack = gen.createPack()

        pack.addProvider(::HexDummyActionTags)
    }
}
