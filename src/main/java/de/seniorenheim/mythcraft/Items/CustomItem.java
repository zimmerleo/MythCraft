package de.seniorenheim.mythcraft.Items;

import de.seniorenheim.mythcraft.Utils.Elements.ElementUtils;
import de.seniorenheim.mythcraft.Utils.Elements.Elements;
import de.seniorenheim.mythcraft.Utils.Rarities.Rarity;
import de.seniorenheim.mythcraft.Utils.Rarities.RarityUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomItem {

    private ItemStack item;
    private String displayName;
    private Rarity rarity;
    private short durability;

    private short level;
    private HashMap<Elements, Float> damageBaseValues;
    private HashMap<Elements, Float> damageMultipliers;
    private HashMap<String, Float> additionalEffects;

    public CustomItem(ItemStack item, String displayName, Rarity rarity, short durability, short level, HashMap<Elements, Float> damageBaseValues, HashMap<Elements, Float> damageMultipliers, HashMap<String, Float> additionalEffects) {
        this.item = item;
        this.displayName = displayName;
        this.rarity = rarity;
        this.durability = durability;
        this.level = level;
        this.damageBaseValues = damageBaseValues;
        this.damageMultipliers = damageMultipliers;
        this.additionalEffects = additionalEffects;
    }

    private List<String> createLore() {
        ArrayList<String> dbv = new ArrayList<>();
        for (Elements e : damageBaseValues.keySet()) {
            dbv.add("§8├ " + (damageBaseValues.get(e) < 0 ? "§c-" : "§a+") + ElementUtils.getColor(e) + damageBaseValues.get(e) + " " + ElementUtils.getAsString(e) + " Damage");
        }
        ArrayList<String> dm = new ArrayList<>();
        for (Elements e : damageMultipliers.keySet()) {
            dm.add("§8├ " + (damageMultipliers.get(e) < 0 ? "§c-" : "§a+") + ElementUtils.getColor(e) + damageMultipliers.get(e) + "% " + ElementUtils.getAsString(e) + " Damage");
        }
        ArrayList<String> ae = new ArrayList<>();
        for (String s : additionalEffects.keySet()) {
            ae.add("§8├ " + (additionalEffects.get(s) < 0 ? "§c-" : "§a+") + additionalEffects.get(s) + "% " + s);
        }

        ArrayList<String> lore = new ArrayList<>(List.of(
                "§8┌────────────────────────",
                "§8├ " + RarityUtils.getColor(rarity) + RarityUtils.getAsString(rarity) + " " + (item.getType() == Material.SHEARS ? "Dagger" : item.getType() == Material.STICK ? "Wand" : item.getType() == Material.BOW ? "Bow" : "Greatsword"),
                "§8├ " + "§cRestricted to §7" + (item.getType() == Material.SHEARS ? "Assassins" : item.getType() == Material.STICK ? "Magicians" : item.getType() == Material.BOW ? "Hunters" : "Warriors"),
                "§8├ " + "§cRequired Level: §7" + level,
                "§8├────────────────────────"));
        lore.addAll(dbv);
        lore.add("│");
        lore.addAll(dm);
        lore.add("│");
        lore.addAll(ae);
        lore.add("§8└────────────────────────");

        return lore;
    }

    public ItemStack build() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setUnbreakable(true);
        meta.setLore(createLore());
        return item;
    }
}
