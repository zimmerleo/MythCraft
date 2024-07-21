package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.MythCraft;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InvCloseListener implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Player p = (Player) e.getPlayer();

        if (!MythCraft.getInstance().getPlayingCharacters().containsKey(p.getName())
                && !MythCraft.getInstance().getKickedByEvent().contains(p)
                && !MythCraft.getInstance().getCharacterCreation().contains(p)) {
            MythCraft.getInstance().getKickedByEvent().add(p);
            p.kickPlayer("§4You need to choose a class to play!");

            Bukkit.getScheduler().runTaskLater(MythCraft.getPlugin(MythCraft.class), new Runnable() {
                @Override
                public void run() {
                    MythCraft.getInstance().getKickedByEvent().remove(p);
                }
            }, 3*20);
        }
    }
}
