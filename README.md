# HexDummy v2

This branch contains the heavily work-in-progress HexDummy rewrite.

## Usage

1. Install Python 3.11 or 3.12, then follow [these instructions](https://docs.astral.sh/uv/getting-started/installation/) to install uv.
2. Create, clone, and enter a **new, completely empty** GitHub repo (**do not** fork/clone/copy this repo directly).
3. From the repo root, run these commands to copy the template, then follow the prompts to set it up:
   ```sh
   uvx copier copy gh:FallingColors/hexdummy .
   git update-index --chmod=+x gradlew
   ```
4. Follow the [hexdoc setup instructions](https://hexdoc.hexxy.media/docs/guides/deployment/github-pages) for GitHub Pages.

Further instructions TODO - look at [HexDebug](https://github.com/object-Object/HexDebug) or [IoticBlocks](https://github.com/object-Object/IoticBlocks) for examples, since this template is based heavily on those mods.

## TODO

- Finish adding Yarn support.
- See if there's a better way to download dependencies for CI tests than just manually listing Modrinth URLs.
- Improve documentation.
- Investigate https://github.com/headlesshq/mc-server-test more. From the logs, it seems like the Fabric server test might not actually be loading any mods?
