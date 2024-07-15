package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Inventories.ClassChoosingInventory;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

import java.util.HashMap;
import java.util.List;

public class ResourcePackListener implements Listener {

    @EventHandler
    public void onResourcePackChange(PlayerResourcePackStatusEvent e) {
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED)) {
            e.getPlayer().kickPlayer("§4Resource-Pack was not accepted!");

        } else {
            PlayerClassUtils.openClassChoosingInventory(e.getPlayer());
        }
    }
}
