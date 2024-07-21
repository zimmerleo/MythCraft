package de.seniorenheim.mythcraft.Items.Consumables;

import de.seniorenheim.mythcraft.Items.CustomItem;
import de.seniorenheim.mythcraft.Utils.Rarities.Rarity;
import de.seniorenheim.mythcraft.Utils.Rarities.RarityUtils;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import de.seniorenheim.mythcraft.Utils.Resources.ResourceUtils;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomConsumable extends CustomItem {
    private Resource resource;

    public CustomConsumable(ItemStack item, String displayName, Rarity rarity, short level, Resource resource, HashMap<String, Float> effects) {
        this.item = item;
        this.displayName = displayName;
        this.rarity = rarity;
        this.level = level;
        this.resource = resource;
        this.effects = effects;
    }

    private List<String> createLore() {
        ArrayList<String> lore = new ArrayList<>(List.of(
                "§8┌────────────────────────",
                "§8├ " + RarityUtils.getColor(rarity) + RarityUtils.getAsString(rarity) + " Consumable",
                "§8├ " + "§cRequired Level: §7" + level,
                "§8├ " + "§aRegenerates " + ResourceUtils.getColor(resource) + effects.get(ResourceUtils.getAsString(resource)) + " " + ResourceUtils.getAsString(resource),
                (!effects.isEmpty() ? "§8├────────────────────────" : "§8└────────────────────────")
        ));
        if (!effects.isEmpty()) {
            for (String s : effects.keySet()) {
                if (!s.equals(ResourceUtils.getAsString(resource))) {
                    lore.add("§8├ " + (effects.get(s) < 0 ? "§c-" : "§a+") + effects.get(s) + "% " + s);
                }
            }
            lore.add("§8└────────────────────────");
        }
        return lore;
    }

    public ItemStack build() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setUnbreakable(true);
        meta.setLore(createLore());
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        return item;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}