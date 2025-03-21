package com.mills.betterGamemode;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeSpectator implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playerName = player.getName();

            if (args.length == 0) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7set your gamemode to spectator!"));
                return true;
            }

            String targetName = args[0];
            Player target = Bukkit.getPlayer(targetName);
            target.setGameMode(GameMode.SPECTATOR);
            target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7set " + playerName + "'s gamemode to spectator!"));
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lGamemode &8» &7" + player.getName() + "set your gamemode to spectator!"));
        }

        return false;
    }
}
