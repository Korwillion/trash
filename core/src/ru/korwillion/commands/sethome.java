package ru.korwillion.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.configs.CustomConfig;
import ru.korwillion.main.survival;

public class sethome implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("sethome")) return true;

        if(!(s instanceof Player)){
            s.sendMessage("§cТолько для игроков!");
            return true;
        }

        Player player = (Player)s;

        if(args.length != 0){
            player.sendTitle("§cПредупреждение", "§7Используйте §c/sethome", 8,10, 8);
            return true;
        }

        if(!player.hasPermission("home.admin")){
            player.sendTitle("§cОшибка", "§7Недостаточно прав", 8, 10, 8);
            return true;
        }
            String name = player.getPlayer().getName().toLowerCase();
            CustomConfig cfg =  survival.config().get(name);
            cfg.get().set("home.x", player.getLocation().getX());
            cfg.get().set("home.y", player.getLocation().getY());
            cfg.get().set("home.z", player.getLocation().getZ());
            cfg.get().set("home.yaw", player.getLocation().getYaw());
            cfg.get().set("home.pitch", player.getLocation().getPitch());
            cfg.save();

        player.sendMessage("§7Координаты §eX: §b" + player.getLocation().getX() +
                "§7, §eY: §b" + player.getLocation().getY() +
                "§7, §eZ: §b" + player.getLocation().getZ() +
                "§7, §eYaw: §b" + player.getLocation().getYaw() +
                "§7, §ePitch: §b" + player.getLocation().getPitch());
        player.sendTitle("§aДом", "§7Вы установили дом", 8, 15, 8);
        return true;
    }

}
