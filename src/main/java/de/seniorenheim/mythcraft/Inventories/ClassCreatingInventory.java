package de.seniorenheim.mythcraft.Inventories;

import de.seniorenheim.mythcraft.Classes.Assassin.Assassin;
import de.seniorenheim.mythcraft.Classes.Hunter.Hunter;
import de.seniorenheim.mythcraft.Classes.Magician.Magician;
import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Classes.Warrior.Warrior;
import de.seniorenheim.mythcraft.Utils.ResourceUtils;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ClassCreatingInventory {

    public Inventory getInventory() {

        int[] slots = {10, 12, 14, 16};
        Assassin a = new Assassin();
        a.setSlot(-1);
        Hunter h = new Hunter();
        h.setSlot(-1);
        Magician m = new Magician();
        m.setSlot(-1);
        Warrior w = new Warrior();
        w.setSlot(-1);

        PlayerClass[] classes = {a, h, m, w};

        Inventory inventory = Bukkit.createInventory(null, 27, "§6Create a new character");

        for (int i = 0; i < slots.length; i++) {

            ItemStack item = new ItemStack(classes[i].getMaterial());
            ItemMeta meta = item.getItemMeta();

                meta.setDisplayName("§2" + classes[i].getClassName());
                meta.setLore(List.of(
                        "§7> §aResource: " + ResourceUtils.getColor(classes[i].getResource()) + ResourceUtils.getAsString(classes[i].getResource()),
                        "§7> §a" + classes[i].getStrength() + "S §7| §a" + classes[i].getDexterity() + "D §7| §a" + classes[i].getAgility() + "A §7| §a" + classes[i].getLuck() + "L §7| §a" + classes[i].getConstitution() + "C §7| §a" + classes[i].getResistance() + "R §7| §a" + classes[i].getIntelligence() + "I",
                        "",
                        "§7> §aClick to choose >>"
                ));

            item.setItemMeta(meta);

            inventory.setItem(slots[i], item);
        }
        return inventory;
    }
}
