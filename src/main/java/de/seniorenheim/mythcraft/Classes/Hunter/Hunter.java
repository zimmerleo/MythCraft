package de.seniorenheim.mythcraft.Classes.Hunter;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resources;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Material;

public class Hunter extends PlayerClass {
    public Hunter() {
        super("Hunter", Resources.ENERGY, Material.BOW,  0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, 0, PlayerClassUtils.calculateMaxXP(0), 0);
    }
}
