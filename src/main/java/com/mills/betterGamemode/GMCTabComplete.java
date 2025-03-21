package com.mills.betterGamemode;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GamemodeTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        List<String> gamemodes = Arrays.asList("creative", "survival", "adventure", "spectator");

        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], gamemodes, new ArrayList<>());
        }

        if (args.length == 2 && gamemodes.contains(args[0].toLowerCase())) {
            List<String> playerNames = Bukkit.getOnlinePlayers().stream()
                    .map(Player::getName)
                    .collect(Collectors.toList());
            return StringUtil.copyPartialMatches(args[1], playerNames, new ArrayList<>());
        }

        return new ArrayList<>();
    }
}
