package ru.korwillion.commands;

import org.bukkit.entity.Player;
import ru.korwillion.main.survival;

import java.util.HashMap;

public class messageManager {

    survival plugin;

    HashMap<Player,Player> conversations = new HashMap<Player, Player>();

    public messageManager(survival textWarp) {
        plugin = textWarp;
    }

    public void setReplyTarget(Player messager, Player reciever){
        conversations.put(messager, reciever);
        conversations.put(reciever, messager);
    }

    public Player getReplyTarget(Player messager){
        return conversations.get(messager);
    }
}