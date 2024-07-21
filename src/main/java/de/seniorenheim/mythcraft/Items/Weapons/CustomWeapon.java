package de.seniorenheim.mythcraft.Items.Weapons;

import de.seniorenheim.mythcraft.Items.CustomItem;
import de.seniorenheim.mythcraft.Utils.Elements.ElementUtils;
import de.seniorenheim.mythcraft.Utils.Elements.Elements;
import de.seniorenheim.mythcraft.Utils.Rarities.Rarity;
import de.seniorenheim.mythcraft.Utils.Rarities.RarityUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomWeapon extends CustomItem {
    private short durability;
    private HashMap<Elements, Float> damageBaseValues;
    private HashMap<Elements, Float> damageMultipliers;

    public CustomWeapon(ItemStack item, String displayName, Rarity rarity, short durability, short level, HashMap<Elements, Float> damageBaseValues, HashMap<Elements, Float> damageMultipliers, HashMap<String, Float> effects) {
        this.item = item;
        this.displayName = displayName;
        this.rarity = rarity;
        this.durability = durability;
        this.level = level;
        this.damageBaseValues = damageBaseValues;
        this.damageMultipliers = damageMultipliers;
        this.effects = effects;
    }

    private List<String> createLore() {
        ArrayList<String> lore = new ArrayList<>(List.of(
                "§8┌────────────────────────",
                "§8├ " + RarityUtils.getColor(rarity) + RarityUtils.getAsString(rarity) + " " + (item.getType() == Material.SHEARS ? "Dagger" : item.getType() == Material.STICK ? "Wand" : item.getType() == Material.BOW ? "Bow" : "Greatsword"),
                "§8├ " + "§cRestricted to §7" + (item.getType() == Material.SHEARS ? "Assassins" : item.getType() == Material.STICK ? "Magicians" : item.getType() == Material.BOW ? "Hunters" : "Warriors"),
                "§8├ " + "§cRequired Level: §7" + level,
                "§8├────────────────────────"
        ));
        for (Elements e : damageBaseValues.keySet()) {
            lore.add("§8├ " + (damageBaseValues.get(e) < 0 ? "§c-" : "§a+") + damageBaseValues.get(e) + " " + ElementUtils.getColor(e) + ElementUtils.getAsString(e) + " Damage");
        }
        lore.add("§8│");
        for (Elements e : damageMultipliers.keySet()) {
            lore.add("§8├ " + (damageMultipliers.get(e) < 0 ? "§c-" : "§a+") + damageMultipliers.get(e) + "% " + ElementUtils.getColor(e) + ElementUtils.getAsString(e) + " Damage");
        }
        lore.add("§8│");
        for (String s : effects.keySet()) {
            lore.add("§8├ " + (effects.get(s) < 0 ? "§c-" : "§a+") + effects.get(s) + "% " + s);
        }
        lore.add("§8└────────────────────────");
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

    public short getDurability() {
        return durability;
    }

    public void setDurability(short durability) {
        this.durability = durability;
    }

    public HashMap<Elements, Float> getDamageBaseValues() {
        return damageBaseValues;
    }

    public void setDamageBaseValues(HashMap<Elements, Float> damageBaseValues) {
        this.damageBaseValues = damageBaseValues;
    }

    public HashMap<Elements, Float> getDamageMultipliers() {
        return damageMultipliers;
    }

    public void setDamageMultipliers(HashMap<Elements, Float> damageMultipliers) {
        this.damageMultipliers = damageMultipliers;
    }
}
