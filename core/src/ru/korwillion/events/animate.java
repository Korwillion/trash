package ru.korwillion.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.korwillion.main.survival;

import java.util.Random;

public class animate implements Listener {
    private final survival plugin;

    public animate(survival plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        new BukkitRunnable() {

            @Override
            public void run() {
                plugin.getServer().broadcastMessage(
                        "выход");
            }

        }.runTaskTimer(this.plugin, 20, 1);
    }

}
