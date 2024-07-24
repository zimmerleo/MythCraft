package de.seniorenheim.mythcraft.Utils.Trackers;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;

public class PlayerTracker {

    public PlayerTracker() {
        trackPlayerStats();
        trackPlayerQuests();
    }

    private void trackPlayerStats() {
        Bukkit.getScheduler().runTaskTimer(MythCraft.getPlugin(MythCraft.class), new Runnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    KeyedBossBar bb1 = Bukkit.getBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "hp", MythCraft.getPlugin(MythCraft.class)));
                    KeyedBossBar bb2 = Bukkit.getBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "res", MythCraft.getPlugin(MythCraft.class)));

                    if (MythCraft.getInstance().getPlayingCharacters().containsKey(p.getName())) {
                        PlayerClass pc = MythCraft.getInstance().getPlayingCharacters().get(p.getName());

                        p.setLevel(pc.getLevel());
                        p.setExp((float) (pc.getCurrentXP() / pc.getMaxXP()));

                        double d1 = pc.getCurrentHitPoints() / pc.getMaxHitPoints();
                        bb1.setProgress(d1);
                        bb1.setColor(d1 >= .5 ? BarColor.GREEN : d1 >= .25 ? BarColor.YELLOW : BarColor.RED);

                        double d2 = pc.getCurrentResourcePoints() / pc.getMaxResourcePoints();
                        bb2.setProgress(d2);
                        bb2.setColor(pc.getResource() == Resource.ENERGY ? BarColor.YELLOW : pc.getResource() == Resource.MANA ? BarColor.BLUE : BarColor.RED);

                        bb1.setVisible(true);
                        bb2.setVisible(true);
                    } else {
                        bb1.setVisible(false);
                        bb2.setVisible(false);
                    }
                }
            }
        },0, 5);
    }

    private void trackPlayerQuests() {
        Bukkit.getScheduler().runTaskTimer(MythCraft.getPlugin(MythCraft.class), new Runnable() {
            @Override
            public void run() {
                //TODO
            }
        }, 0, 1);
    }
}
