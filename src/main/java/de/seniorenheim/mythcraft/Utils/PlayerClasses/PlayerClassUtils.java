package de.seniorenheim.mythcraft.Utils.PlayerClasses;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import de.seniorenheim.mythcraft.Utils.Inventories.ClassChoosingInventory;
import de.seniorenheim.mythcraft.Utils.Resources.Resources;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.*;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;

import java.util.*;

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

    public static void trackPlayers() {
        Bukkit.getScheduler().runTaskTimer(MythCraft.getPlugin(MythCraft.class), new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {

                    if (MythCraft.getInstance().getPlayingCharacters().containsKey(p.getName())) {
                        PlayerClass pc = MythCraft.getInstance().getPlayingCharacters().get(p.getName());

                        p.setLevel(pc.getLevel());
                        p.setExp((float) (pc.getCurrentXP() / pc.getMaxXP()));

                        KeyedBossBar bb1 = Bukkit.getBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "hp", MythCraft.getPlugin(MythCraft.class)));
                        KeyedBossBar bb2 = Bukkit.getBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "res", MythCraft.getPlugin(MythCraft.class)));

                        double d1 = pc.getCurrentHitPoints() / pc.getMaxHitPoints();
                        bb1.setProgress(d1);
                        bb1.setColor(d1 >= .5 ? BarColor.GREEN : d1 >= .25 ? BarColor.YELLOW : BarColor.RED);

                        double d2 = pc.getCurrentResourcePoints() / pc.getMaxResourcePoints();
                        bb2.setProgress(d2);
                        bb2.setColor(pc.getResource() == Resources.ENERGY ? BarColor.YELLOW : pc.getResource() == Resources.MANA ? BarColor.BLUE : BarColor.RED);

                        bb1.setVisible(true);
                        bb2.setVisible(true);
                    }
                }
            }
        },0, 5);
    }
}
