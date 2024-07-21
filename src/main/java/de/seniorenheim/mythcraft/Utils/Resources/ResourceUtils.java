package de.seniorenheim.mythcraft.Utils.Resources;


public class ResourceUtils {

    public static String getColor(Resource r) {
        return switch (r) {
            case ENERGY -> "§e";
            case MANA -> "§9";
            case RAGE -> "§c";
        };
    }

    public static String getAsString(Resource r) {
        return r.toString().substring(0, 1).toUpperCase() + r.toString().substring(1).toLowerCase();
    }
}
