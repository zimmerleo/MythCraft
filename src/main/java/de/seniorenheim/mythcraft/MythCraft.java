package de.seniorenheim.mythcraft;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Commands.ClassCommand;
import de.seniorenheim.mythcraft.Listeners.*;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MythCraft extends JavaPlugin {

    private static MythCraft instance;
    private ArrayList<Player> characterCreation = new ArrayList<>();
    private ArrayList<Player> kickedByEvent = new ArrayList<>();
    private HashMap<String, PlayerClass>  playingCharacters = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        kickAll();

        try {
            initializeFiles();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        loadListeners();
        loadCommands();
        PlayerClassUtils.trackPlayers();
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

    public ArrayList<Player> getKickedByEvent() {
        return kickedByEvent;
    }

    public ArrayList<Player> getCharacterCreation() {
        return characterCreation;
    }

    private void kickAll() {
        if (!Bukkit.getOnlinePlayers().isEmpty()) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.kickPlayer("§4Kicked due to a reload!");
            }
        }
    }
    private void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new JoinListener(), this);
        pm.registerEvents(new ResourcePackListener(), this);
        pm.registerEvents(new InvClickListener(), this);
        pm.registerEvents(new QuitListener(), this);
        pm.registerEvents(new InteractListener(), this);
        pm.registerEvents(new InvCloseListener(), this);
        pm.registerEvents(new BowShootingListener(), this);
    }

    private void loadCommands() {
        getCommand("class").setExecutor(new ClassCommand());
    }

    private void initializeFiles() throws IOException {
        List<File> files = List.of(new File("plugins//MythCraft/players.yml"));

        for (File file : files) {
            if (!file.exists()) {
                createFile(file);
            }
        }
    }
    private void createFile(File file) throws IOException {
        file.createNewFile();
        saveFile(file);
    }
    private void saveFile(File file) throws IOException {
        new YamlConfiguration().save(file);
    }
}
