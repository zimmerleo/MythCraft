package de.seniorenheim.mythcraft.Inventories;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.ResourceUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ClassChoosingInventory {

    public Inventory getInventory(PlayerClass[] playerClasses) {

        int[] slots = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};

        Inventory inventory = Bukkit.createInventory(null, 36, "§6Your characters");

        for (int i = 0; i < slots.length; i++) {
            PlayerClass pc = playerClasses[i];

            ItemStack item;
            ItemMeta meta;

            if (pc != null) {
                item = new ItemStack(pc.getMaterial());
                meta = item.getItemMeta();
                meta.setDisplayName("§7[§6" + pc.getLevel() + "§7] §6" + pc.getClassName());
                meta.setLore(List.of(
                        "§c" + pc.getCurrentHitPoints() + " §7/ §c" + pc.getMaxHitPoints() + " ❤",
                        ResourceUtils.getColor(pc.getResource()) + pc.getCurrentResourcePoints() + " §7/ " + ResourceUtils.getColor(pc.getResource()) + pc.getMaxResourcePoints() + " " + ResourceUtils.getAsString(pc.getResource()),
                        "§a" + pc.getStrength() + "S §7| §a" + pc.getDexterity() + "D §7| §a" + pc.getAgility() + "A §7| §a" + pc.getLuck() + "L §7| §a" + pc.getConstitution() + "C §7| §a" + pc.getResistance() + "R §7| §a" + pc.getIntelligence() + "I"
                ));
            } else {
                item = new ItemStack(Material.GREEN_DYE);
                meta = item.getItemMeta();
                meta.setDisplayName("§a+ >>");
            }

            item.setItemMeta(meta);

            inventory.setItem(slots[i], item);
        }
        return inventory;
    }
}
