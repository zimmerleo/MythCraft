package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.Hunter.Hunter;
import de.seniorenheim.mythcraft.MythCraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class BowShootingListener implements Listener {

    @EventHandler
    public void onBowShoot(EntityShootBowEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();

            if (MythCraft.getInstance().getPlayingCharacters().get(p.getName()) instanceof Hunter) {
                e.setConsumeItem(false);
                e.setCancelled(true);
            }
        }
    }
}
