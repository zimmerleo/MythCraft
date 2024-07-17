package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        e.getPlayer().setGameMode(e.getPlayer().isOp() ? e.getPlayer().getGameMode() : GameMode.ADVENTURE);
        e.getPlayer().setResourcePack("https://cdn.modrinth.com/data/r4GILswZ/versions/FfTSsnUr/Faithful%2064x%20-%20Release%204.zip");
        PlayerClassUtils.openClassChoosingInventory(e.getPlayer());

        KeyedBossBar bb1 = Bukkit.getBossBar(NamespacedKey.fromString(e.getPlayer().getName().toLowerCase() + "hp", MythCraft.getPlugin(MythCraft.class)));
        KeyedBossBar bb2 = Bukkit.getBossBar(NamespacedKey.fromString(e.getPlayer().getName().toLowerCase() + "res", MythCraft.getPlugin(MythCraft.class)));

        if (bb1 == null && bb2 == null) {
            bb1 = Bukkit.createBossBar(NamespacedKey.fromString(e.getPlayer().getName().toLowerCase() + "hp", MythCraft.getPlugin(MythCraft.class)), null, BarColor.GREEN, BarStyle.SOLID);

            bb2 = Bukkit.createBossBar(NamespacedKey.fromString(e.getPlayer().getName().toLowerCase() + "res", MythCraft.getPlugin(MythCraft.class)),null, BarColor.WHITE, BarStyle.SOLID);
            bb1.addPlayer(e.getPlayer());
            bb2.addPlayer(e.getPlayer());
            bb1.setVisible(false);
            bb2.setVisible(false);
        }
    }
}
