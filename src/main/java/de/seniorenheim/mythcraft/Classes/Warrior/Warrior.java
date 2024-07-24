package de.seniorenheim.mythcraft.Classes.Warrior;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import de.seniorenheim.mythcraft.Classes.PlayerClassUtils;
import org.bukkit.Material;

public class Warrior extends PlayerClass {

    public Warrior() {
        super("Warrior", Resource.RAGE, Material.IRON_SWORD,  0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, (short) 1, PlayerClassUtils.calculateMaxXP(1), 0);
    }
}
