/**package ru.korwillion.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import ru.korwillion.main.survival;

public class Anim implements Runnable {


    private static final String[] name = new String[] {
            "§6Game§fCloud",
            "§6G§3ame§fCloud",
            "§6Ga§3me§fCloud",
            "§6Gam§3e§fCloud",
            "§6Game§fCloud",
            "§6Game§3C&floud",
            "§6Game§fC§3l&foud",
            "§6Game§fCl§3o&fud",
            "§6Game§fClo§3u&fd",
            "§6Game§fClo§3u§3d",
    };

    private int id;
    private Player p;
    private Objective o;
    private int i;



    public Anim(Player p, Objective o) {
        this.p = p;
        this.o = o;
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(survival.main, this, 20, 2);


    }

    @Override
    public void run() {
        if(!p.isOnline()) {
            cancel();
            return;
        }

        if(o == null) {
            cancel();
            return;
        }

        o.setDisplayName(name[i]);
        i++;
        if(i >- name.length) i = 0;

    }

    private void cancel() {
        Bukkit.getScheduler().cancelTask(id);
        id = 0;
    }
}
**/