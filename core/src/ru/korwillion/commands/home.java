package ru.korwillion.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.configs.CustomConfig;
import ru.korwillion.main.survival;

public class home implements CommandExecutor {

            @Override
            public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
                if(!cmd.getName().equalsIgnoreCase("home")) return true;

                if(!(s instanceof Player)){
                    s.sendMessage(ChatColor.RED +"Только для игроков!");
                    return true;
                }

                Player player = (Player)s;

                if(args.length != 0){
                    player.sendTitle("§cПредупреждение", "§7Используйте §c/home", 8,10, 8);
                    return true;
                }
                String name = player.getPlayer().getName().toLowerCase();
                CustomConfig cfg =  survival.config().get(name);
                double x = cfg.get().getDouble("home.x");
                double y = cfg.get().getDouble("home.y");
                double z = cfg.get().getDouble("home.z");
                float yaw = (float) cfg.get().getDouble("home.yaw");
                float pitch = (float) cfg.get().getDouble("home.pitch");


                Location location = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);

                player.teleport(location);
                player.sendTitle("§aТелепорт", "§7Вы телепортированы домой", 8, 15, 8);


                return true;
            }
        }
