# Changelog

## `2.0.0` - 2025-06-16

### Additions

- Added support for Kotlin (and rewrote everything in Kotlin).
- Added GitHub Actions workflows for building and testing the mod on every push and pull request, deploying the hexdoc book, and releasing new versions of the mod to CurseForge and Modrinth using the GitHub UI.
- Added an option to include the Minecraft version in the mod version (eg. `v1.0.0+1.20.1`).
- Integrated hexdoc directly into the template, instead of requiring users to set up `hexdoc-hexcasting-template` separately.

### Changes

- Updated to Hex Casting 0.11.2.
- Completely rewrote the entire template from the ground up.
- Converted all Gradle build scripts and most of the code to Kotlin.
- Moved common Gradle configs from `allprojects`/`subprojects` to convention plugins in `buildSrc`.
- Moved dependency versions from `gradle.properties` to `gradle/libs.versions.toml`.

### Notes

- Most of the non-Gradle files do not yet have Yarn support. As such, **Mojmap is highly recommended** for the time being, unless you know what you're doing and are fine with manually converting the code to Yarn.

## `0.0.2` - 2023-08-26

### Changes

- API tokens for modrinth and curseforge are now expected to be in user-specific gradle.properties.

### Fixes

- Docgen being broken.

## `0.0.1` - 2023-08-26

### Additions

- The entire project!