package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Items.Consumables.CustomConsumable;
import de.seniorenheim.mythcraft.Items.Weapons.CustomWeapon;
import de.seniorenheim.mythcraft.Utils.Elements.Elements;
import de.seniorenheim.mythcraft.Utils.Rarities.Rarity;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import org.bukkit.Material;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Classes.PlayerClassUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        e.getPlayer().setGameMode(e.getPlayer().isOp() ? e.getPlayer().getGameMode() : GameMode.ADVENTURE);
        e.getPlayer().setResourcePack("https://cdn.modrinth.com/data/r4GILswZ/versions/FfTSsnUr/Faithful%2064x%20-%20Release%204.zip");

        HashMap<Elements, Float> h1 = new HashMap<>(); h1.put(Elements.NORMAL, 234F);
        HashMap<Elements, Float> h2 = new HashMap<>(); h2.put(Elements.FIRE, 57.3F);
        HashMap<String, Float> h3 = new HashMap<>(); h3.put("XP", 19.9F);
        e.getPlayer().getInventory().addItem(new CustomWeapon(new ItemStack(Material.SHEARS), "§4DEATH'S DAGGER", Rarity.LEGENDARY, Short.MAX_VALUE, (short) 69, h1, h2, h3).build());
        e.getPlayer().getInventory().addItem(new CustomConsumable(new ItemStack(Material.POTION, 1, (short) 8197), "§aHealth Potion", Rarity.COMMON, (short) 1, Resource.MANA, h3).build());

        setupBossBars(e.getPlayer());
        PlayerClassUtils.openClassChoosingInventory(e.getPlayer());
    }

    private void setupBossBars(Player p) {
        KeyedBossBar bb1 = Bukkit.createBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "hp", MythCraft.getPlugin(MythCraft.class)), null, BarColor.GREEN, BarStyle.SOLID);
        KeyedBossBar bb2 = Bukkit.createBossBar(NamespacedKey.fromString(p.getName().toLowerCase() + "res", MythCraft.getPlugin(MythCraft.class)),null, BarColor.WHITE, BarStyle.SOLID);
        bb1.addPlayer(p);
        bb2.addPlayer(p);
        bb1.setVisible(false);
        bb2.setVisible(false);
    }
}
