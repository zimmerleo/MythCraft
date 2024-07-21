package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.Hunter.Hunter;
import de.seniorenheim.mythcraft.MythCraft;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ArrowHitListener implements Listener {

    @EventHandler
    public void onArrowHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow && ((Arrow) e.getDamager()).getShooter() instanceof Player) {
            Player p = (Player) ((Arrow) e.getDamager()).getShooter();

            if (MythCraft.getInstance().getPlayingCharacters().containsKey(p.getName()) && MythCraft.getInstance().getPlayingCharacters().get(p.getName()) instanceof Hunter) {
                //DMG
            }
        }
    }
}
