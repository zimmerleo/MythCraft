package de.seniorenheim.mythcraft.Classes.Warrior;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resources;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Material;

public class Warrior extends PlayerClass {

    public Warrior() {
        super("Warrior", Resources.RAGE, Material.IRON_SWORD,  0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, 0, PlayerClassUtils.calculateMaxXP(0), 0);
    }
}
