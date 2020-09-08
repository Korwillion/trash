package ru.korwillion.commands;

import ru.korwillion.utils.TeleportUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomTPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){

                Location randomLocation = TeleportUtils.findSafeLocation(player);

                player.teleport(randomLocation);
                player.sendTitle("§aТелепорт", "§7Вы телепортированы на рандомное место", 8, 15, 8);
                player.sendMessage(ChatColor.RED + "Рандомная телепортация");
                player.sendMessage(ChatColor.AQUA + "Твои новые координаты: " + ChatColor.LIGHT_PURPLE + randomLocation.getX() + " " + randomLocation.getY() + " " + randomLocation.getZ());

            }else if(args.length == 1){ //Specify a player to teleport
                if (player.hasPermission("rtp.others")){
                    Player target = Bukkit.getPlayer(args[0]);

                    Location randomLocation = TeleportUtils.findSafeLocation(target);

                    target.teleport(randomLocation);
                    target.sendMessage(ChatColor.GREEN + player.getDisplayName() + ChatColor.GOLD + " телепортировал тебя в рандомное место!");
                    target.sendMessage(ChatColor.AQUA + "Твои новые координаты: " + ChatColor.LIGHT_PURPLE + randomLocation.getX() + " " + randomLocation.getY() + " " + randomLocation.getZ());
                    target.sendTitle("§aТелепорт", "§7Игрок " + ChatColor.GREEN + player.getDisplayName() + " §7телепортировал вас на рандомное место", 8, 15, 8);

                    player.sendMessage(ChatColor.RED + "Игрок телепортирован на координаты: " + ChatColor.LIGHT_PURPLE + randomLocation.getX() + " " + randomLocation.getY() + " " + randomLocation.getZ());
                }
            }
        }else {
            System.out.println("Только игрок может выполнить эту команду.");
        }

        return true;
    }
}