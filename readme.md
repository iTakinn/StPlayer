# StPlayer

**StPlayer** is a Minecraft Spigot/Paper plugin that executes a command to "stress/crash" a player by sending large data messages.

## Installation

1. Build the project using Maven:

   ```bash
   mvn clean package
   ```
2. Place the generated `stplayer.jar` file in your server's `plugins` folder.
3. Ensure the `plugin.yml` file is included in the JAR.

## Usage

In-game or via console, run:

```
/stplayer <player_name>
```

- The command will attempt to send large messages to the target player.

## Permissions

- `stplayer.use`: Allows usage of the `/stplayer` command.

## Notes

- The plugin may cause lag, disconnect or crash the targeted player.
- Use responsibly.
- **I've no responsibility for your own use.**
- The plugin may use a lot of bandwidth depending on the target connection.
