plugins {
    id("hexdummy.minecraft")
}

architectury {
    common("fabric", "forge")
}

dependencies {
    implementation(libs.kotlin.stdlib)

    // We depend on fabric loader here to use the fabric @Environment annotations and get the mixin dependencies
    // Do NOT use other classes from fabric loader
    modImplementation(libs.fabric.loader)
    modApi(libs.architectury)

    modApi(libs.hexcasting.fabric)

    modApi(libs.clothConfig.common)

    libs.mixinExtras.common.also {
        implementation(it)
        annotationProcessor(it)
    }
}
