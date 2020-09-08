package ru.korwillion.GUIMenu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {
    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("§5§lМеню")) {


            e.setCancelled(true);

//отложу на потом

            switch (e.getSlot()) {

                case 11:

                    p.closeInventory();
                    break;
            }
        }
    }
}
