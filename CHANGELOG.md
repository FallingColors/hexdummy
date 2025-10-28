# Changelog

## `2.2.2` - 2025-10-27

### Changes

- Updated the serialization-hooks dependency to use https://maven.hexxy.media instead of a vendored JAR.

## `2.2.1` - 2025-09-30

### Fixes

- Fixed the incorrect URL being used in the examples for `.env`.

## `2.2.0` - 2025-09-23

### Changes

- Split the example mod config into entirely separate classes for client and server configs, to allow using config option types that are only available client-side (eg. keybinds).
- Updated [Mod Publish Plugin](https://modmuss50.github.io/mod-publish-plugin/).
- Removed the workaround for publishing GitHub releases, switching to the new [allowEmptyFiles](https://modmuss50.github.io/mod-publish-plugin/platforms/github/#parent-releases) option instead.

### Fixes

- Added missing localizations for the example mod config.

## `2.1.1` - 2025-09-23

### Fixes

- Fixed an invalid workflow error for the `build.yml` workflow.

## `2.1.0` - 2025-09-23

### Additions

- Added an example of a great spell.
- Added per-platform datagen, to generate tags for the example great spell.
- Added an option to disable generating the MIT license.

### Changes

- Improved the setup documentation.
- Updated the hexdoc instructions, Python dependencies, and GitHub Actions workflows to recommend using [uv](https://docs.astral.sh/uv/).
- Updated the release workflow to skip the runtime tests, since they already run on push and take a while to run.
- Fixed Pyright type checking settings.

### Fixes

- Fixed an error introduced in a recent Copier version where the copy command would fail if the default `java_package` value was invalid.

## `2.0.4` - 2025-06-19

### Changes

- Added a 10-minute timeout to the client and server test jobs, since HeadlessMC seems to just hang sometimes.

## `2.0.3` - 2025-06-19

### Additions

- Added a message to be printed after generating the project with a reminder about the next steps to complete.

## `2.0.2` - 2025-06-16

### Additions

- Added a `kotlin_package` advanced option, to allow escaping Kotlin keywords in otherwise valid Java package names (eg. `gay.object.hexdebug` -> ```gay.`object`.hexdebug```)

### Notes

- When updating to this version, you'll be prompted for the base Java package name again, even with `--skip-answered`, since the underlying option was renamed from `package` to `java_package`. If you don't remember what you answered last time, you can find the old value in `.copier-answers.yml`, eg. `package: foo.bar.baz`.

## `2.0.1` - 2025-06-16

### Fixes

- Fixed an "invalid workflow file" error when trying to run the release workflow.
- Fixed a potential issue where running the release workflow in "dry run" mode would still deploy the hexdoc book to GitHub Pages.
- Fixed a potential issue where the build workflow would never build in release mode.

## `2.0.0` - 2025-06-16

### Additions

- Added support for Kotlin.
- Added GitHub Actions workflows for building and testing the mod on every push and pull request, deploying the hexdoc book, and releasing new versions of the mod to CurseForge and Modrinth using the GitHub UI.
- Added an option to include the Minecraft version in the mod version (eg. `v1.0.0+1.20.1`).
- Integrated hexdoc directly into the template, instead of requiring users to set up `hexdoc-hexcasting-template` separately.
- Added json5 support via [PKPCPBP](<https://github.com/gamma-delta/PKPCPBP/>).

### Changes

- Updated to Hex Casting 0.11.2!
- Completely rewrote the entire template from the ground up.
- Rewrote all Gradle build scripts and most of the mod code in Kotlin.
- Moved common Gradle configs from `allprojects`/`subprojects` to convention plugins in `buildSrc`.
- Moved dependency versions from `gradle.properties` to `gradle/libs.versions.toml`.

### Notes

- Most of the non-Gradle files do not yet have Yarn support. As such, **Mojmap is highly recommended** for the time being, unless you know what you're doing and are fine with manually converting the code to Yarn.
- This version of the template is very new and untested, so please [open an issue](https://github.com/FallingColors/hexdummy/issues) if you find any bugs.

## `0.0.2` - 2023-08-26

### Changes

- API tokens for modrinth and curseforge are now expected to be in user-specific gradle.properties.

### Fixes

- Docgen being broken.

## `0.0.1` - 2023-08-26

### Additions

- The entire project!