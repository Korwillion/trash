package ru.korwillion.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import ru.korwillion.main.survival;

public class RespawnEvent implements Listener {

    private static survival plugin;

    public RespawnEvent(survival plugin){
        RespawnEvent.plugin = plugin;
    }


    @EventHandler
    public void onRespawn(PlayerRespawnEvent event){
        double x = plugin.getConfig().getDouble("spawn.x");
        double y = plugin.getConfig().getDouble("spawn.y");
        double z = plugin.getConfig().getDouble("spawn.z");
        float yaw = (float) plugin.getConfig().getDouble("spawn.yaw");
        float pitch = (float) plugin.getConfig().getDouble("spawn.pitch");
        Location location = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);
        event.setRespawnLocation(location);
    }
}
