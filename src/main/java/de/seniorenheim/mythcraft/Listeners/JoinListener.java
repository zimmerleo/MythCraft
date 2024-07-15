package de.seniorenheim.mythcraft.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        e.getPlayer().setResourcePack("https://cdn.modrinth.com/data/r4GILswZ/versions/FfTSsnUr/Faithful%2064x%20-%20Release%204.zip");
    }
}
