package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Items.CustomItem;
import de.seniorenheim.mythcraft.Utils.Rarities.Rarity;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        e.getPlayer().setResourcePack("https://cdn.modrinth.com/data/r4GILswZ/versions/FfTSsnUr/Faithful%2064x%20-%20Release%204.zip");

        e.getPlayer().getInventory().addItem(new CustomItem(new ItemStack(Material.SHEARS), "§4DEATH'S DAGGER", Rarity.LEGENDARY, Short.MAX_VALUE, (short) 69, new HashMap<>(), new HashMap<>(), new HashMap<>()).build());
    }
}
