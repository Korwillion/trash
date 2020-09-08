package ru.korwillion.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.main.survival;

public class warpCommand implements CommandExecutor {

    survival plugin;

    public warpCommand(survival textWarp) {
        plugin = textWarp;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                plugin.wM.sendWarpList(p);
            } else if (args.length == 1){
                plugin.wM.warpPlayer(p, args[0]);
            }
        }
        return false;
    }

}

