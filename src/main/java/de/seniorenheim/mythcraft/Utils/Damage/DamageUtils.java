package de.seniorenheim.mythcraft.Utils.Damage;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Entities.CustomEntity;
import de.seniorenheim.mythcraft.Weapons.CustomWeapon;

import java.util.Random;

public class DamageUtils {

    public static double calculateDamage(PlayerClass playerClass, CustomWeapon customWeapon, CustomEntity customEntity) {
        Random random = new Random();
        double result = customEntity.getCurrentHP();

        //TODO

        return result;
    }
}
