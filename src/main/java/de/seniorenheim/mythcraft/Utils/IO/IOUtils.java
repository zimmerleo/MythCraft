package de.seniorenheim.mythcraft.Utils.IO;

import de.seniorenheim.mythcraft.Classes.Assassin.Assassin;
import de.seniorenheim.mythcraft.Classes.Hunter.Hunter;
import de.seniorenheim.mythcraft.Classes.Magician.Magician;
import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Classes.Warrior.Warrior;
import de.seniorenheim.mythcraft.MythCraft;
import net.minecraft.server.level.ServerPlayer;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.*;
import java.util.*;

public class IOUtils {

    public static void savePlayerClasses(HashMap<String, List<PlayerClass>> playerMap) {
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setIndent(2);
        dumperOptions.setPrettyFlow(true);
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(dumperOptions);

        try (FileWriter writer = new FileWriter("plugins/MythCraft/players.yml")) {
            yaml.dump(playerMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, List<PlayerClass>> readPlayerClasses() {
        HashMap<String, List<PlayerClass>> data = null;

        String filePath = "plugins/MythCraft/players.yml";

        DumperOptions dumperOptions = new DumperOptions();
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setTagInspector(tag -> true);
        Representer representer = new Representer(dumperOptions);
        Constructor constructor = new CustomClassLoaderConstructor(MythCraft.class.getClassLoader(), loaderOptions);

        Tag assassinTag = new Tag("!!de.seniorenheim.mythcraft.Classes.Assassin.Assassin");
        Tag warriorTag = new Tag("!!de.seniorenheim.mythcraft.Classes.Warrior.Warrior");
        Tag hunterTag = new Tag("!!de.seniorenheim.mythcraft.Classes.Hunter.Hunter");
        Tag magicianTag = new Tag("!!de.seniorenheim.mythcraft.Classes.Magician.Magician");

        constructor.addTypeDescription(new TypeDescription(Assassin.class, assassinTag));
        constructor.addTypeDescription(new TypeDescription(Warrior.class, warriorTag));
        constructor.addTypeDescription(new TypeDescription(Hunter.class, hunterTag));
        constructor.addTypeDescription(new TypeDescription(Magician.class, magicianTag));

        Yaml yaml = new Yaml(constructor, representer);

        try (InputStream inputStream = new FileInputStream(filePath)) {
            data = yaml.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static PlayerClass[] convert(List<PlayerClass> list) {
        PlayerClass[] result = new PlayerClass[10];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static List<PlayerClass> convert(PlayerClass[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void saveNPCs(List<ServerPlayer> npcList) {
        HashMap<String, List<ServerPlayer>> data = new HashMap<>();
        data.put("npcs", npcList);

        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setIndent(2);
        dumperOptions.setPrettyFlow(true);
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

        Yaml yaml = new Yaml(dumperOptions);

        try (FileWriter writer = new FileWriter("plugins/MythCraft/npcs.yml")) {
            yaml.dump(data, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ServerPlayer> readNPCs() {
        HashMap<String, List<ServerPlayer>> data = null;

        String filePath = "plugins/MythCraft/npcs.yml";

        DumperOptions dumperOptions = new DumperOptions();
        LoaderOptions loaderOptions = new LoaderOptions();
        loaderOptions.setTagInspector(tag -> true);
        Representer representer = new Representer(dumperOptions);
        Constructor constructor = new CustomClassLoaderConstructor(MythCraft.class.getClassLoader(), loaderOptions);

        //Tag npcTag = new Tag("");
        //constructor.addTypeDescription(new TypeDescription(Assassin.class, assassinTag));

        Yaml yaml = new Yaml(constructor, representer);

        try (InputStream inputStream = new FileInputStream(filePath)) {
            data = yaml.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data.get("npcs") != null ? data.get("npcs") : new ArrayList<>();
    }
}
