package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Inventories.ClassChoosingInventory;
import de.seniorenheim.mythcraft.Utils.IOUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import java.util.HashMap;

public class ResourcePackListener implements Listener {

    @EventHandler
    public void onResourcePackChange(PlayerResourcePackStatusEvent e) {
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED)) {
            e.getPlayer().kickPlayer("§4Resource-Pack was not accepted!");

        } else {
            HashMap<String, PlayerClass[]> map = IOUtils.readYaml();
            PlayerClass[] playerClasses = new PlayerClass[10];
            if (map != null) {
                if (map.containsKey(e.getPlayer().getName())) {

                    try {
                        //TODO ClassCastException
                        playerClasses = map.get(e.getPlayer().getName());
                    } catch (ClassCastException ex) {
                        ex.printStackTrace();
                    }
                }
            }
            e.getPlayer().openInventory(new ClassChoosingInventory().getInventory(playerClasses));
        }
    }
}
