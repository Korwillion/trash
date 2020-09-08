package ru.korwillion.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.korwillion.main.survival;

public class messageCommand implements CommandExecutor {

    survival plugin;

    public messageCommand(survival textWarp) {
        plugin = textWarp;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player && args.length > 0){
            if(Bukkit.getOfflinePlayer(args[0]).getPlayer() != null){
                Player messager = (Player) sender;
                Player reciever = Bukkit.getOfflinePlayer(args[0]).getPlayer();
                plugin.mM.setReplyTarget(messager, reciever);
                args[0] = "";
                String message = "";
                for(int i = 0; i < args.length; i++){
                    message += " " + args[i];
                }
                messager.sendMessage("§6>>>" + reciever.getName() + ": §f" + message);
                reciever.sendMessage("§6<<<" + messager.getName() + ": §f" + message);
                return true;
            } else {
                sender.sendMessage("оффлайн");
                return true;
            }

        }
        return false;
    }

}