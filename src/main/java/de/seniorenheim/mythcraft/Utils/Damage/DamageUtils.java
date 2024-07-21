package de.seniorenheim.mythcraft.Utils.Damage;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Entities.CustomEntity;
import de.seniorenheim.mythcraft.Items.Weapons.CustomWeapon;
import de.seniorenheim.mythcraft.Utils.Elements.Elements;
import org.bukkit.entity.LivingEntity;

import java.util.HashMap;
import java.util.Random;

public class DamageUtils {

public static double calculateDamage(PlayerClass playerClass, CustomWeapon weapon, CustomEntity target) {
        Random random = new Random();
        double result = 0;

        HashMap<Elements, Float> dbv = weapon.getDamageBaseValues();
        float[] dbvs = {
                (dbv.containsKey(Elements.NORMAL) ? dbv.get(Elements.NORMAL) : 0), (dbv.containsKey(Elements.WATER) ? dbv.get(Elements.WATER) : 0), (dbv.containsKey(Elements.FIRE) ? dbv.get(Elements.FIRE) : 0),
                (dbv.containsKey(Elements.GRASS) ? dbv.get(Elements.GRASS) : 0), (dbv.containsKey(Elements.THUNDER) ? dbv.get(Elements.THUNDER) : 0),
                (dbv.containsKey(Elements.DARK) ? dbv.get(Elements.DARK) : 0), (dbv.containsKey(Elements.NECROTIC) ? dbv.get(Elements.NECROTIC) : 0), (dbv.containsKey(Elements.DIVINE) ? dbv.get(Elements.DIVINE) : 0)
        };

        HashMap<Elements, Float> dm = weapon.getDamageMultipliers();
        float[] dms = {
                (dm.containsKey(Elements.NORMAL) ? dm.get(Elements.NORMAL) : 0), (dm.containsKey(Elements.WATER) ? dm.get(Elements.WATER) : 0), (dm.containsKey(Elements.FIRE) ? dm.get(Elements.FIRE) : 0),
                (dm.containsKey(Elements.GRASS) ? dm.get(Elements.GRASS) : 0), (dm.containsKey(Elements.THUNDER) ? dm.get(Elements.THUNDER) : 0),
                (dm.containsKey(Elements.DARK) ? dm.get(Elements.DARK) : 0), (dm.containsKey(Elements.NECROTIC) ? dm.get(Elements.NECROTIC) : 0), (dm.containsKey(Elements.DIVINE) ? dm.get(Elements.DIVINE) : 0)
        };

        return result;
    }
}
