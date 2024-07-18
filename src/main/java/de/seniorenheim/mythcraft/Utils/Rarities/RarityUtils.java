package de.seniorenheim.mythcraft.Utils.Rarities;

public class RarityUtils {

    public static String getColor(Rarity rarity) {
        return switch (rarity) {
            case COMMON -> "§f";
            case UNCOMMON -> "§7";
            case RARE -> "§9";
            case UNIQUE -> "§5";
            case LEGENDARY -> "§6";
        };
    }

    public static String getAsString(Rarity rarity) {
        return rarity.toString().substring(0, 1).toUpperCase() + rarity.toString().substring(1).toLowerCase();
    }
}
