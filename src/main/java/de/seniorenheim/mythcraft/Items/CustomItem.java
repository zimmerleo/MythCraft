package de.seniorenheim.mythcraft.Items;

import de.seniorenheim.mythcraft.Utils.Rarities.Rarity;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CustomItem {

    protected ItemStack item;
    protected String displayName;
    protected Rarity rarity;
    protected short level;
    protected HashMap<String, Float> effects;

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public HashMap<String, Float> getEffects() {
        return effects;
    }

    public void setEffects(HashMap<String, Float> effects) {
        this.effects = effects;
    }
}
