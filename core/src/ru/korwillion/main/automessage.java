package ru.korwillion.main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.List;

public class automessage implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
    List<String> list = survival.main.getConfig().getStringList("animated-scoreboard");
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        Objective obj = board.registerNewObjective("dummy", "scoreboard");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName("Скорборд");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(survival.main, new Runnable(){
            int i;

            @Override
            public void run() {
                if (i >= list.size()) {
                    i = 0;
                }
                if (i < list.size()) {
                    Score animatedline = obj.getScore(list.get(i));
                    animatedline.setScore(20);
                }
                i ++;
            }
        }, 0,  20);

        p.setScoreboard(board);
        }
}
