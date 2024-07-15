package de.seniorenheim.mythcraft.Utils.PlayerClasses;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import de.seniorenheim.mythcraft.Utils.Inventories.ClassChoosingInventory;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class PlayerClassUtils {

    public static int transformInvSlotToIndex(int slot) {
        int[] slots = {11, 12, 13, 14, 15, 20, 21, 22, 23, 24};

        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == slot) {
                return i;
            }
        }
        return -1;
    }

    public static double calculateMaxXP(int characterLevel) {
        return 100 * Math.pow(2, characterLevel);
    }

    public static void openClassChoosingInventory(Player player) {
        HashMap<String, List<PlayerClass>> map = IOUtils.readYaml();
        PlayerClass[] playerClasses = new PlayerClass[10];
        if (map != null) {
            if (map.containsKey(player.getName())) {

                try {
                    //TODO ClassCastException
                    playerClasses = IOUtils.convert(map.get(player.getName()));
                } catch (ClassCastException ex) {
                    ex.printStackTrace();
                }
            }
        }
        player.openInventory(new ClassChoosingInventory().getInventory(playerClasses));
    }
}
