package de.seniorenheim.mythcraft.Classes;

import de.seniorenheim.mythcraft.Resources.Resources;
import de.seniorenheim.mythcraft.Utils.PlayerClassUtils;
import org.bukkit.Material;

public class PlayerClass {

    private final String className;
    private final Resources resource;
    private final Material material;
    private int slot;


    private int strength;
    private int dexterity;
    private int agility;
    private int luck;
    private int constitution;
    private int resistance;
    private int intelligence;

    private double maxHitPoints;
    private double currentHitPoints;
    private double maxResourcePoints;
    private double currentResourcePoints;
    private int level;
    private double maxXP;
    private double currentXP;

    public PlayerClass(String className, Resources resource, Material material, int slot, int strength, int dexterity, int agility, int luck, int constitution, int resistance, int intelligence, double maxHitPoints, double currentHitPoints, double maxResourcePoints, double currentResourcePoints, int level, double maxXP, double currentXP) {
        this.className = className;
        this.resource = resource;
        this.material = material;
        this.slot = slot;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.luck = luck;
        this.constitution = constitution;
        this.resistance = resistance;
        this.intelligence = intelligence;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.maxResourcePoints = maxResourcePoints;
        this.currentResourcePoints = currentResourcePoints;
        this.level = level;
        this.maxXP = maxXP;
        this.currentXP = currentXP;
    }

    public String getClassName() {
        return className;
    }

    public Resources getResource() {
        return resource;
    }

    public Material getMaterial() {
        return material;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public double getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(double maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public double getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(double currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public double getMaxResourcePoints() {
        return maxResourcePoints;
    }

    public void setMaxResourcePoints(double maxResourcePoints) {
        this.maxResourcePoints = maxResourcePoints;
    }

    public double getCurrentResourcePoints() {
        return currentResourcePoints;
    }

    public void setCurrentResourcePoints(double currentResourcePoints) {
        this.currentResourcePoints = currentResourcePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMaxXP() {
        return maxXP;
    }

    public void setMaxXP() {
        this.maxXP = PlayerClassUtils.calculateMaxXP(level);
    }

    public double getCurrentXP() {
        return currentXP;
    }

    public void setCurrentXP(double currentXP) {
        this.currentXP = currentXP;
    }
}
