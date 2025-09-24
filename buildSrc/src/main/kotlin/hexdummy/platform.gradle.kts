// A convention plugin that should be applied to all subprojects corresponding to a specific modloader/platform, such as fabric and forge.

@file:Suppress("UnstableApiUsage")

package hexdummy

import libs
import kotlin.io.path.div

plugins {
    id("hexdummy.minecraft")
    id("hexdummy.mod-publish")
    id("hexdummy.utils.mod-dependencies")

    id("com.github.johnrengelman.shadow")
}

val platform: String by project
val curseforgeId: String by project
val modrinthId: String by project

val minecraftVersion = libs.versions.minecraft.get()

val platformCapitalized = platform.capitalize()

architectury {
    platformSetupLoomIde()
}

configurations {
    register("common")
    register("shadowCommon")
    compileClasspath {
        extendsFrom(get("common"))
    }
    runtimeClasspath {
        extendsFrom(get("common"))
    }
    // this needs to wait until Loom has been configured
    afterEvaluate {
        named("development$platformCapitalized") {
            extendsFrom(get("common"))
        }
    }
}

dependencies {
    "common"(project(":common", "namedElements")) { isTransitive = false }
    "shadowCommon"(project(":common", "transformProduction$platformCapitalized")) { isTransitive = false }
}

sourceSets {
    main {
        resources {
            source(project(":common").sourceSets.main.get().resources)
        }
    }
}

tasks {
    val ciArtifacts = register<Copy>("ciArtifacts") {
        from(remapJar)
        into(rootDir.toPath() / "build" / "ciArtifacts")
    }

    build {
        dependsOn(ciArtifacts)
    }

    shadowJar {
        exclude("architectury.common.json")
        configurations = listOf(project.configurations["shadowCommon"])
        archiveClassifier = "dev-shadow"
    }

    remapJar {
        dependsOn(shadowJar)
        inputFile = shadowJar.get().archiveFile
        archiveClassifier = null
    }

    jar {
        archiveClassifier = "dev"
    }

    kotlinSourcesJar {
        val commonSources = project(":common").tasks.kotlinSourcesJar
        dependsOn(commonSources)
        from(commonSources.flatMap { it.archiveFile }.map(::zipTree))
    }
}

publishMods {
    file = tasks.remapJar.flatMap { it.archiveFile }

    modLoaders.add(platform)

    displayName = modLoaders.map { values ->
        val loaders = values.joinToString(", ") { it.capitalize() }
        // CurseForge/Modrinth version display name (eg. "v0.1.0 [Fabric, Quilt]")
        "v${project.version} [$loaders]"
    }

    curseforge {
        accessToken = System.getenv("CURSEFORGE_TOKEN") ?: ""
        projectId = curseforgeId
        minecraftVersions.add(minecraftVersion)
        // TODO: update if your mod is only client-side or server-side!
        clientRequired = true
        serverRequired = true
    }

    modrinth {
        accessToken = System.getenv("MODRINTH_TOKEN") ?: ""
        projectId = modrinthId
        minecraftVersions.add(minecraftVersion)
    }

    github {
        parent(rootProject.tasks.named("publishGithub"))
    }
}

fun String.capitalize() = replaceFirstChar(Char::uppercase)
