package de.seniorenheim.mythcraft;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Listeners.InvClickListener;
import de.seniorenheim.mythcraft.Listeners.JoinListener;
import de.seniorenheim.mythcraft.Listeners.QuitListener;
import de.seniorenheim.mythcraft.Listeners.ResourcePackListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public final class MythCraft extends JavaPlugin {

    private static MythCraft instance;
    private HashMap<String, PlayerClass>  playingCharacters = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        kickAll();
        try {
            new YamlConfiguration().save(new File("plugins//MythCraft/players.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loadListeners();

    }

    @Override
    public void onDisable() {

    }

    public static MythCraft getInstance() {
        return instance;
    }

    public HashMap<String, PlayerClass> getPlayingCharacters() {
        return playingCharacters;
    }

    private void kickAll() {
        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.kickPlayer("§cKicked due to a reload!");
            }
        }
    }
    private void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ResourcePackListener(), this);
        pm.registerEvents(new InvClickListener(), this);
        pm.registerEvents(new QuitListener(), this);
    }
}
