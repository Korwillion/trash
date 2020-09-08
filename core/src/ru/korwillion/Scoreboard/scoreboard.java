/**package ru.korwillion.Scoreboard;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class scoreboard implements Listener { }

    public static Plugin main;

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Scoreboard newScoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective o = newScoreboard.registerNewObjective("stats", "dummy");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.getScore("§b");
        o.getScore("§3");
        o.getScore("§4");
        o.getScore("§aУбийства" + getKills(event.getPlayer())).setScore(3);
        o.getScore("§4" + getKills(event.getPlayer())).setScore(2);
        o.getScore("§cСмерти" + getKills(event.getPlayer())).setScore(1);
        event.getPlayer().setScoreboard(newScoreboard);
        new Anim(event.getPlayer(), o);
    }


    @EventHandler
    public void m(EntityDeathEvent e) {
        Player player = e.getEntity().getKiller();
        if(player == null) return;
        updateScoreboard(player);
    }


    private void updateScoreboard(Player player) {
        Scoreboard s = player.getScoreboard();
        for (String e : s.getEntries()) {
            s.resetScores(e);
        }



        Objective o = s.getObjective("stats");
        o.getScore("§b");
        o.getScore("§3");
        o.getScore("§4");
        o.getScore("§aУбийства" + getKills(player)).setScore(3);
        o.getScore("§4" + getKills(player)).setScore(2);
        o.getScore("§cСмерти" + getKills(player)).setScore(1);

    }


    private int getKills(Player player) {
        Scoreboard main = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective obj = main.getObjective("kills");
        if(obj == null) obj = main.registerNewObjective("kills", "totalKillsCount");
        return obj.getScore(player.getName()).getScore();

    }

    private int getDeaths(Player player) {
        Scoreboard main = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective obj = main.getObjective("deaths");
        if(obj == null) obj = main.registerNewObjective("deaths", "deathsCount");
        return obj.getScore(player.getName()).getScore();

    }
}**/