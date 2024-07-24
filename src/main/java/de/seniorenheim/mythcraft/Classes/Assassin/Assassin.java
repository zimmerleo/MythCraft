package de.seniorenheim.mythcraft.Classes.Assassin;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import de.seniorenheim.mythcraft.Classes.PlayerClassUtils;
import org.bukkit.Material;

public class Assassin extends PlayerClass {
    public Assassin() {
        super("Assassin", Resource.ENERGY, Material.SHEARS, 0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, (short) 1, PlayerClassUtils.calculateMaxXP(1), 0);
    }
}
