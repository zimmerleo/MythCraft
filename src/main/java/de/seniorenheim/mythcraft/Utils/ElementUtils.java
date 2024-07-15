package de.seniorenheim.mythcraft.Utils;

import de.seniorenheim.mythcraft.Elements.Elements;

public class ElementUtils {

    public static Elements[] getStrengths(Elements e) {
        return switch (e) {
            case FIRE -> new Elements[]{Elements.GRASS};
            case WATER -> new Elements[]{Elements.FIRE};
            case GRASS -> new Elements[]{Elements.ELECTRIC};
            case ELECTRIC -> new Elements[]{Elements.WATER};
            case NECROTIC -> new Elements[]{Elements.GRASS, Elements.WATER};
            case DARK -> new Elements[]{Elements.FIRE, Elements.ELECTRIC};
            case DIVINE -> new Elements[]{Elements.DARK, Elements.NECROTIC};
        };
    }

    public static Elements[] getWeaknesses(Elements e) {
        return switch (e) {
            case FIRE -> new Elements[]{Elements.WATER, Elements.DARK};
            case WATER -> new Elements[]{Elements.ELECTRIC, Elements.NECROTIC};
            case GRASS -> new Elements[]{Elements.FIRE, Elements.NECROTIC};
            case ELECTRIC -> new Elements[]{Elements.GRASS, Elements.DARK};
            case NECROTIC, DARK -> new Elements[]{Elements.DIVINE};
            case DIVINE -> new Elements[]{};
        };
    }

    public static String getColor(Elements e) {
        return switch (e) {
            case FIRE -> "§c";
            case WATER -> "§9";
            case GRASS -> "§a";
            case ELECTRIC -> "§e";
            case NECROTIC -> "§7";
            case DARK -> "§8";
            case DIVINE -> "§6";
        };
    }

    public static String getAsString(Elements e) {
        return e.toString().substring(0, 1).toUpperCase() + e.toString().substring(1).toLowerCase();
    }
}
