package de.seniorenheim.mythcraft.Utils;


import de.seniorenheim.mythcraft.Resources.Resources;

public class ResourceUtils {

    public static String getColor(Resources r) {
        return switch (r) {
            case ENERGY -> "§e";
            case MANA -> "§9";
            case RAGE -> "§c";
        };
    }

    public static String getAsString(Resources r) {
        return r.toString().substring(0, 1).toUpperCase() + r.toString().substring(1).toLowerCase();
    }
}
