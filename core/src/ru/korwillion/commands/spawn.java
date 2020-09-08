package ru.korwillion.commands;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.main.survival;


public class spawn implements CommandExecutor {

    private static survival plugin;

    public spawn(survival plugin){
        spawn.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!cmd.getName().equalsIgnoreCase("spawn")) return true;

        if(!(s instanceof Player)){
            s.sendMessage(ChatColor.RED +"Только для игроков!");
            return true;
        }

        Player player = (Player)s;

        if(args.length != 0){
            player.sendTitle("§cПредупреждение", "§7Используйте §c/spawn", 8,10, 8);
            return true;
        }

        double x = plugin.getConfig().getDouble("spawn.x");
        double y = plugin.getConfig().getDouble("spawn.y");
        double z = plugin.getConfig().getDouble("spawn.z");
        float yaw = (float) plugin.getConfig().getDouble("spawn.yaw");
        float pitch = (float) plugin.getConfig().getDouble("spawn.pitch");


        Location location = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);

        player.teleport(location);
        player.sendTitle("§aТелепорт", "§7Вы телепортированы на спавн", 8, 15, 8);


        return true;
    }
}
