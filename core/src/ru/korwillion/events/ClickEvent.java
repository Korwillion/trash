package ru.korwillion.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.korwillion.commands.menu;
import ru.korwillion.main.survival;

import java.util.ArrayList;
import java.util.Arrays;


public class ClickEvent implements Listener {
    private static survival plugin;

    public ClickEvent(survival plugin){
        ClickEvent.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerJoinEvent e) {
        String name = e.getPlayer().getName().toLowerCase();
    }

/**    @EventHandler
    public void on(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getInventory();
        if(inv==null) return;
        if(inv.getHolder() instanceof menu) {
            e.setCancelled(true);
        }
    }
**/

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
        if(e.getRightClicked() instanceof Player) {
            e.setCancelled(true);
            Player p = e.getPlayer();
            Inventory inp = Bukkit.createInventory(null, 9, "§8§lИгрок §c§l" + p.getName());
            //friends
            ItemStack friends = (new ItemStack(Material.TOTEM, 1));
            ItemMeta meta = friends.getItemMeta();
            meta.setDisplayName("§d§lДобавить в друзья");
            ArrayList<String> metal = new ArrayList<>();
            metal.add("§7Разработать описание (и функционал)");
            meta.setLore(metal);
            friends.setItemMeta(meta);
            inp.setItem(1, friends);
            //duels
            ItemStack duels = (new ItemStack(Material.DIAMOND_SWORD, 1));
            ItemMeta meta_duels = duels.getItemMeta();
            meta_duels.setDisplayName("§c§lВызвать на дуэль");
            duels.setItemMeta(meta_duels);
            inp.setItem(2, duels);
        }
    }

    @EventHandler
    public void on(InventoryCloseEvent e) {
        if(e.getInventory().getHolder() instanceof menu) {
            ((Player) e.getPlayer()).updateInventory();
        }
    }

    @EventHandler
    public void on(InventoryDragEvent e) {
        Inventory inv = e.getInventory();
        if(inv.getHolder() instanceof menu) {
            e.setCancelled(true);
        }
    }
    }

