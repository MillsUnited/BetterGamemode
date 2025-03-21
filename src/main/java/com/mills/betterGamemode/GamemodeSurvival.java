package com.mills.betterGamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeSurvival implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playerName = player.getName();

            if (player.hasPermission("gamemode.survival")) {

                if (args.length == 0) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7set your gamemode to survival!"));
                    return true;
                }

                String targetName = args[0];
                Player target = Bukkit.getPlayer(targetName);

                if (playerName.equals(targetName)) {
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7set your gamemode to survival!"));
                    return true;
                }

                target.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7set " + targetName + "'s gamemode to survival!"));
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7" + playerName + " set your gamemode to survival!"));

            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7You dont have permission to do this!"));
            }
        }

        return false;
    }
}
