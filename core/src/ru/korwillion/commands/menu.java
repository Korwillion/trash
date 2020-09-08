package ru.korwillion.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.events.JoinEvent;

public class menu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            player.openInventory(JoinEvent.inv);
        }else{
            System.out.println("Открыть инвентарь может только игрок!");
        }
        return true;
    }
}
