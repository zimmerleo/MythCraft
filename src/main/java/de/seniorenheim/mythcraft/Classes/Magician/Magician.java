package de.seniorenheim.mythcraft.Classes.Magician;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resources;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Material;

public class Magician extends PlayerClass {

    public Magician() {
        super("Magician", Resources.MANA, Material.STICK,  0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, 0, PlayerClassUtils.calculateMaxXP(0), 0);
    }
}
