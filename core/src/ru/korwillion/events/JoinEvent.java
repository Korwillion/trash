package ru.korwillion.events;

import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import ru.korwillion.main.survival;

import java.util.Random;


public class JoinEvent implements Listener {
    private static survival plugin;
    public static Inventory inv;



    public JoinEvent(survival plugin){
        JoinEvent.plugin = plugin;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        event.setJoinMessage("§6Game§fCloud §7С возвращением на выживание, §c"+ player.getName()+"§7!");
        ItemStack item = new ItemStack(Material.BOOK);
        player.getInventory().addItem(item);
        double x = plugin.getConfig().getDouble("spawn.x");
        double y = plugin.getConfig().getDouble("spawn.y");
        double z = plugin.getConfig().getDouble("spawn.z");
        float yaw = (float) plugin.getConfig().getDouble("spawn.yaw");
        float pitch = (float) plugin.getConfig().getDouble("spawn.pitch");
        Location location = new Location(Bukkit.getWorld("world"), x, y, z, yaw, pitch);
        player.teleport(location);



        player.sendTitle("§6§lGame§f§lCloud", "§7§lВы зашли на выживание", 8, 40, 8);
    }
}
