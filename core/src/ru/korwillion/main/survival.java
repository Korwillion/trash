package ru.korwillion.main;


import ru.korwillion.GUIMenu.GUI;
import ru.korwillion.GUIMenu.GUIListener;
import ru.korwillion.commands.*;
import ru.korwillion.configs.Configs;
import ru.korwillion.events.*;
import ru.korwillion.holograms.HologramCommand;
import ru.korwillion.utils.TeleportUtils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class survival extends JavaPlugin {

    public static Plugin main;
    public warpManager wM;
    public messageManager mM;
    private static survival instance;
    private static Configs config;

    public static survival plugin() {
        return instance;
    }
    public static Configs config() {
        return config;
    }



    @Override
    public void onEnable() {

        Bukkit.getServer().getPluginManager().registerEvents(new GUIListener(), this);

        getCommand("gui").setExecutor(new GUI());

        main = this;
        instance = this;
        config = new Configs();
        wM = new warpManager(this);
        mM = new messageManager(this);
        //utils
        TeleportUtils yeet = new TeleportUtils(this);
        new animate(this);
        //commands
        getCommand("warps").setExecutor(new warpCommand(this));
        getCommand("tell").setExecutor(new messageCommand(this));
        getCommand("r").setExecutor(new replyCommand(this));
        getCommand("rtp").setExecutor(new RandomTPCommand());
        getCommand("hologram").setExecutor(new HologramCommand());
        getCommand("menu").setExecutor(new menu());
        getCommand("spawn").setExecutor(new spawn(this));
        getCommand("setspawn").setExecutor(new setspawn(this));
        getCommand("sethome").setExecutor(new sethome());
        getCommand("home").setExecutor(new home());
        //events
        Bukkit.getPluginManager().registerEvents(new DoubleJump(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new ClickEvent(this), this);
        Bukkit.getPluginManager().registerEvents(new automessage(), this);
        //configs
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //nothing
        getLogger().info("сурвач активен");
    }

    @Override
    public void onDisable() {
        //сохраняем и кастомный тоже
        config.saveAll();
        //nothing
        getLogger().info("сурвач не активен");
    }

}
