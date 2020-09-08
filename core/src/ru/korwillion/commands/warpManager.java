package ru.korwillion.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import ru.korwillion.main.survival;

public class warpManager {

    survival plugin;

    public warpManager(survival main){
        plugin = main;
    }

    @SuppressWarnings("deprecation")
    public void warpPlayer(Player player, String warpName){
        int x = plugin.getConfig().getInt(warpName + ".x");
        int y = plugin.getConfig().getInt(warpName + ".y");
        int z = plugin.getConfig().getInt(warpName + ".z");
        String worldName = plugin.getConfig().getString(warpName + ".world");
        Location warpLoc = new Location(Bukkit.getWorld(worldName),x,y,z,player.getLocation().getPitch(),player.getLocation().getYaw());
        player.teleport(warpLoc);
        player.sendTitle(ChatColor.GOLD + warpName, ChatColor.GREEN + "Хелоу!");
    }

    public void saveWarp(Player player, String warpName){
        Location warpLoc = player.getLocation();
        plugin.getConfig().set(warpName + ".x", warpLoc.getBlockX());
        plugin.getConfig().set(warpName + ".y", warpLoc.getBlockY());
        plugin.getConfig().set(warpName + ".z", warpLoc.getBlockZ());
        plugin.getConfig().set(warpName + ".world", warpLoc.getWorld().getName());
        plugin.saveConfig();
        player.sendMessage(warpName + " создано!");
    }

    public void sendWarpList(Player player){
        player.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "нажми для телепорта");
        for(String warp : plugin.getConfig().getKeys(false)){
            TextComponent formatting = new TextComponent("- ");
            formatting.setColor(ChatColor.DARK_GRAY);
            TextComponent message = new TextComponent(warp);
            message.setColor(ChatColor.GREEN);
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/textwarp " + warp));
            formatting.addExtra(message);
            player.spigot().sendMessage(formatting);
        }
    }
}