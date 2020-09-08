package ru.korwillion.holograms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class HologramCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;

            ArmorStand hologram = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
            hologram.setVisible(false);
            hologram.setGravity(false);
            hologram.setCustomNameVisible(true);
            hologram.setCustomName("§6Game§fCloud");
            //Second line
            ArmorStand hologram2 = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, -0.5, 0), EntityType.ARMOR_STAND);
            hologram2.setVisible(false);
            hologram2.setGravity(false);
            hologram2.setCustomNameVisible(true);
            hologram2.setCustomName("§fДобро пожаловать!");

        }
        return true;
    }
}