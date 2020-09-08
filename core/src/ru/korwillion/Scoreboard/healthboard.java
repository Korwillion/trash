/**package ru.korwillion.Scoreboard;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class healthboard implements Listener {

    private Scoreboard s;

    public void registerHealthBar() {
        if (this.s.getObjective("health") != null) {
            this.s.getObjective("health").unregister();
        }
        Objective o = this.s.registerNewObjective("health", "health");
        o.setDisplayName(ChatColor.RED + "❤");
        o.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }
}
**/