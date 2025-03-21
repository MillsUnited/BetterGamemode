package com.mills.betterGamemode;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gmc").setExecutor(new GamemodeCreative());
        getCommand("gms").setExecutor(new GamemodeSurvival());
        getCommand("gmsp").setExecutor(new GamemodeSpectator());
        getCommand("gma").setExecutor(new GamemodeAdventure());
        getCommand("gmc").setTabCompleter(new GMCTabComplete());
        getCommand("gms").setTabCompleter(new GMSTabComplete());
        getCommand("gma").setTabCompleter(new GMATabComplete());
        getCommand("gmsp").setTabCompleter(new GMSPTabComplete());
    }
}
