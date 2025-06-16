// A convention plugin that should be applied to all Minecraft-related subprojects, including common.

@file:Suppress("UnstableApiUsage")

package hexdummy

import kotlin.io.path.div
import libs

plugins {
    id("hexdummy.java")

    `maven-publish`
    id("dev.architectury.loom")
    id("at.petra-k.pkpcpbp.PKJson5Plugin")
}

val modId: String by project
val platform: String by project

base.archivesName = "${modId}-$platform"

loom {
    silentMojangMappingsLicense()
    accessWidenerPath = project(":common").file("src/main/resources/hexdummy.accesswidener")

    mixin {
        // the default name includes both archivesName and the subproject, resulting in the platform showing up twice
        // default: hexdummy-common-common-refmap.json
        // fixed:   hexdummy-common.refmap.json
        defaultRefmapName = "${base.archivesName.get()}.refmap.json"
    }
}

pkJson5 {
    autoProcessJson5 = true
    autoProcessJson5Flattening = true
}

dependencies {
    minecraft(libs.minecraft)

    mappings(variantOf(libs.yarn) { classifier("v2") })

    annotationProcessor(libs.bundles.asm)
}

sourceSets {
    main {
        kotlin {
            srcDir(file("src/main/java"))
        }
        resources {
            srcDir(file("src/generated/resources"))
        }
    }
}
