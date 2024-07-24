package de.seniorenheim.mythcraft.Classes.Hunter;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import de.seniorenheim.mythcraft.Classes.PlayerClassUtils;
import org.bukkit.Material;

public class Hunter extends PlayerClass {
    public Hunter() {
        super("Hunter", Resource.ENERGY, Material.BOW,  0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, (short) 1, PlayerClassUtils.calculateMaxXP(1), 0);
    }
}
