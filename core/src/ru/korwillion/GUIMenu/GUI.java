package ru.korwillion.GUIMenu;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import java.util.ArrayList;

public class GUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] strings) {
        if (sender instanceof Player) {

            Player p = (Player)sender;
            if (cmd.getName().equalsIgnoreCase("gui")) {

                Inventory gui = Bukkit.getServer().createInventory(p, 54, "§5§lМеню");

                ItemStack ref1 = new ItemStack(Material.BANNER);
                ItemStack border = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 1);
                for(int i = 0; i < gui.getContents().length; i++) {
                    if((i >= 0 && i <= 8) || (i >= 45 && i <= 53) || (i % 9 == 0) || ((i-8) % 9 == 0))
                        gui.setItem(i, border);
                }

                ItemMeta metaref1 = ref1.getItemMeta();
                ArrayList<String> lore = new ArrayList<String>();


                metaref1.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

                ref1.setItemMeta(metaref1);


                lore.add("§e§lЗ§f§lдесь можно купить все.");
                lore.add("§e§lМ§f§lожно юзать командой /shop.");
                lore.add("§e§lН§f§lажми, чтобы открыть.");

                metaref1.setLore(lore);
                metaref1.setDisplayName("§6§lМ§f§lгазин");

                ref1.setItemMeta(metaref1);
                gui.setItem(11, ref1);

                p.openInventory(gui);

            }
        }
        return false;
    }
}