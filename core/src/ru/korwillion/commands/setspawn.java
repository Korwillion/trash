package ru.korwillion.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.main.survival;

public class setspawn implements CommandExecutor {

    private static survival plugin;

    public setspawn(survival plugin){

        setspawn.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("setspawn")) return true;

        if(!(s instanceof Player)){
            s.sendMessage("§cТолько для игроков!");
            return true;
        }


        Player player = (Player)s;


        if(!player.hasPermission("spawn.admin")){
            player.sendTitle("§cОшибка", "§7Недостаточно прав", 8, 10, 8);
            return true;
        }

        plugin.getConfig().set("spawn.x", player.getLocation().getX());
        plugin.getConfig().set("spawn.y", player.getLocation().getY());
        plugin.getConfig().set("spawn.z", player.getLocation().getZ());
        plugin.getConfig().set("spawn.yaw", player.getLocation().getYaw());
        plugin.getConfig().set("spawn.pitch", player.getLocation().getPitch());
        plugin.saveConfig();

        player.sendMessage("§7Координаты §eX: §b" + player.getLocation().getX() +
                "§7, §eY: §b" + player.getLocation().getY() +
                "§7, §eZ: §b" + player.getLocation().getZ() +
                "§7, §eYaw: §b" + player.getLocation().getYaw() +
                "§7, §ePitch: §b" + player.getLocation().getPitch());
        player.sendTitle("§aСпавн", "§7Вы установили спавн", 8, 15, 8);
        return true;
    }
}
