// A convention plugin to partially configure the Mod Publish Plugin.

package hexdummy

plugins {
    id("me.modmuss50.mod-publish-plugin")
}

publishMods {
    val isCI = (System.getenv("CI") ?: "").isNotBlank()
    val isDryRun = (System.getenv("DRY_RUN") ?: "").isNotBlank()
    dryRun = !isCI || isDryRun

    type = STABLE
    changelog = provider { getLatestChangelog() }

    github {
        accessToken = System.getenv("GITHUB_TOKEN") ?: ""
    }
}

val versionHeaderPrefix = "## "
val subheaderRegex = "^### ".toRegex()

fun getLatestChangelog() = rootProject.file("CHANGELOG.md").useLines { lines ->
    // skip lines up to and including the first version header
    lines.dropWhile { !it.startsWith(versionHeaderPrefix) }
        .drop(1)
        // keep all lines up to but excluding the next version header
        .takeWhile { !it.startsWith(versionHeaderPrefix) }
        // convert eg. "### Added" to "## Added"
        .map { it.replaceFirst(subheaderRegex, "## ") }
        .joinToString("\n")
        .trim()
}
