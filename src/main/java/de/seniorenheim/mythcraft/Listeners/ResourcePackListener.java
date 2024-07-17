package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.MythCraft;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;

public class ResourcePackListener implements Listener {

    @EventHandler
    public void onResourcePackChange(PlayerResourcePackStatusEvent e) {
        if (e.getStatus().equals(PlayerResourcePackStatusEvent.Status.DECLINED)) {
            MythCraft.getInstance().getKickedByEvent().add(e.getPlayer());
            e.getPlayer().kickPlayer("§4Resource-Pack was not accepted!");

            Bukkit.getScheduler().runTaskLater(MythCraft.getPlugin(MythCraft.class), new Runnable() {
                @Override
                public void run() {
                    MythCraft.getInstance().getKickedByEvent().remove(e.getPlayer());
                }
            }, 3*20);
        }
    }
}
