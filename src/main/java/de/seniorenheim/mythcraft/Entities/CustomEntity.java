package de.seniorenheim.mythcraft.Entities;

import de.seniorenheim.mythcraft.Utils.Elements.Elements;
import de.seniorenheim.mythcraft.Utils.Entities.EntityTier;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class CustomEntity {

    private final String entityName;

    private final EntityType entityType;
    private final EntityTier entityTier;

    private final int entityLevel;
    private final Elements element;

    private final ItemStack[] armor;
    private final ItemStack weapon;
    private final HashMap<ItemStack, Integer> lootMap;

    private double maxHP;
    private double currentHP;

    private int waterResist;
    private int fireResist;
    private int grassResist;
    private int thunderResist;
    private int darkResist;
    private int necroticResist;
    private int divineResist;

    private double baseDamage;
    private double percentDamage;


    public CustomEntity(String entityName, EntityType entityType, EntityTier entityTier, int entityLevel, Elements element, ItemStack[] armor, ItemStack weapon, HashMap<ItemStack, Integer> lootMap, double maxHP, double currentHP, int waterResist, int fireResist, int grassResist, int thunderResist, int darkResist, int necroticResist, int divineResist, double baseDamage, double percentDamage) {
        this.entityName = entityName;
        this.entityType = entityType;
        this.entityTier = entityTier;
        this.entityLevel = entityLevel;
        this.element = element;
        this.armor = armor;
        this.weapon = weapon;
        this.lootMap = lootMap;
        this.maxHP = maxHP;
        this.currentHP = currentHP;
        this.waterResist = waterResist;
        this.fireResist = fireResist;
        this.grassResist = grassResist;
        this.thunderResist = thunderResist;
        this.darkResist = darkResist;
        this.necroticResist = necroticResist;
        this.divineResist = divineResist;
        this.baseDamage = baseDamage;
        this.percentDamage = percentDamage;
    }

    public String getEntityName() {
        return entityName;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public EntityTier getEntityTier() {
        return entityTier;
    }

    public double getXPMultiplier() {
        return (entityTier == EntityTier.COMMON ? 1 : 1.5);
    }

    public int getEntityLevel() {
        return entityLevel;
    }

    public Elements getElement() {
        return element;
    }

    public ItemStack[] getArmor() {
        return armor;
    }

    public ItemStack getWeapon() {
        return weapon;
    }

    public HashMap<ItemStack, Integer> getLootMap() {
        return lootMap;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public double getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public int getWaterResist() {
        return waterResist;
    }

    public void setWaterResist(int waterResist) {
        this.waterResist = waterResist;
    }

    public int getFireResist() {
        return fireResist;
    }

    public void setFireResist(int fireResist) {
        this.fireResist = fireResist;
    }

    public int getGrassResist() {
        return grassResist;
    }

    public void setGrassResist(int grassResist) {
        this.grassResist = grassResist;
    }

    public int getThunderResist() {
        return thunderResist;
    }

    public void setThunderResist(int thunderResist) {
        this.thunderResist = thunderResist;
    }

    public int getDarkResist() {
        return darkResist;
    }

    public void setDarkResist(int darkResist) {
        this.darkResist = darkResist;
    }

    public int getNecroticResist() {
        return necroticResist;
    }

    public void setNecroticResist(int necroticResist) {
        this.necroticResist = necroticResist;
    }

    public int getDivineResist() {
        return divineResist;
    }

    public void setDivineResist(int divineResist) {
        this.divineResist = divineResist;
    }

    public double getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    public double getPercentDamage() {
        return percentDamage;
    }

    public void setPercentDamage(double percentDamage) {
        this.percentDamage = percentDamage;
    }
}