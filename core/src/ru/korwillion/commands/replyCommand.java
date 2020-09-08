package ru.korwillion.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.main.survival;

public class replyCommand implements CommandExecutor {

    survival plugin;

    public replyCommand(survival textWarp) {
        plugin = textWarp;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player messager = (Player) sender;
            if(plugin.mM.getReplyTarget(messager) == null){
                messager.sendMessage("No current conversation");
                return true;
            }
            Player reciever = plugin.mM.getReplyTarget(messager);
            String message = "";
            for(int i = 0; i < args.length; i++){
                message += " " + args[i];
            }
            messager.sendMessage("§6>>>" + reciever.getName() + ": §f" + message);
            reciever.sendMessage("§6<<<" + messager.getName() + ": §f" + message);
            return true;
        }
        return false;
    }

}