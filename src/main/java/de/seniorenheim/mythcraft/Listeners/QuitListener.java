package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.IOUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.setQuitMessage("");
        Player p = e.getPlayer();

        if (MythCraft.getPlugin(MythCraft.class).getPlayingCharacters().containsKey(p.getName())) {

            HashMap<String, PlayerClass[]> map = IOUtils.readYaml() != null ? IOUtils.readYaml() : new HashMap<>();
            PlayerClass[] playerClasses = map.get(p.getName()) != null ? map.get(p.getName()) : new PlayerClass[10];
            playerClasses[MythCraft.getPlugin(MythCraft.class).getPlayingCharacters().get(p.getName()).getSlot()] = MythCraft.getPlugin(MythCraft.class).getPlayingCharacters().get(p.getName());

            map.put(p.getName(), playerClasses);

            IOUtils.saveYaml(map);
        }
    }
}
