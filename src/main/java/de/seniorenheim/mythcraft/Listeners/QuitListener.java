package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.List;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("");
        Player p = e.getPlayer();

        if (MythCraft.getPlugin(MythCraft.class).getPlayingCharacters().containsKey(p.getName())) {

            HashMap<String, List<PlayerClass>> map = IOUtils.readYaml() != null ? IOUtils.readYaml() : new HashMap<>();
            PlayerClass[] playerClasses = map.get(p.getName()) != null ? IOUtils.convert(map.get(p.getName())) : new PlayerClass[10];
            playerClasses[MythCraft.getPlugin(MythCraft.class).getPlayingCharacters().get(p.getName()).getSlot()] = MythCraft.getPlugin(MythCraft.class).getPlayingCharacters().get(p.getName());

            map.put(p.getName(), IOUtils.convert(playerClasses));

            IOUtils.saveYaml(map);
            MythCraft.getInstance().getPlayingCharacters().remove(p.getName());

            KeyedBossBar bb1 = Bukkit.getBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "hp", MythCraft.getPlugin(MythCraft.class)));
            KeyedBossBar bb2 = Bukkit.getBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "res", MythCraft.getPlugin(MythCraft.class)));

            if (bb1 != null && bb2 != null) {
                bb1.setVisible(false);
                bb2.setVisible(false);
            }
        }
    }
}
