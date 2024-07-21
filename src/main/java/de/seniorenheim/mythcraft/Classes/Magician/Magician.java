package de.seniorenheim.mythcraft.Classes.Magician;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Material;

public class Magician extends PlayerClass {

    public Magician() {
        super("Magician", Resource.MANA, Material.STICK,  0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, (short) 1, PlayerClassUtils.calculateMaxXP(1), 0);
    }
}
