package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.MythCraft;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (MythCraft.getInstance().getPlayingCharacters().containsKey(p.getName())) {
            PlayerClass pc = MythCraft.getInstance().getPlayingCharacters().get(p.getName());

            e.setFormat("§8[§7" + pc.getLevel() + " §8| §7" + pc.getClassName() + "§8] §2" + p.getName() + " §8> " + e.getMessage().replaceAll("&", "§"));
        } else {
            e.setCancelled(true);
        }
    }
}
