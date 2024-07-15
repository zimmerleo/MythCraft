package de.seniorenheim.mythcraft.Classes;

import de.seniorenheim.mythcraft.Utils.Resources.Resources;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.Material;

public class PlayerClass {

    private final String className;
    private final Resources resource;
    private final Material material;
    private int slot;


    private int strength; //Damage +0.5% / pt; Penetration +0.25 % / pt; up to (up to 100pt)
    private int dexterity; //DodgeChance +1.5% / pt; ResourceRegeneration +0.25 / pt; up to (60pt)
    private int agility; //Speed buff?; MaxResourcePoints +5 / pt in case of Energy; up to (??pt)
    private int luck; //CritChance +1.5% / pt LootChance +0.5% / pt; up to (60pt);
    private int constitution; //MaxHitPoints +5% / pt; DamageReflection +0.5% / pt; up to (60pt)
    private int resistance; //DamageReduction +2% / pt; MaxResourcePoints +5 / pt in case of Rage; up to (45pt)
    private int intelligence; //CooldownReduction 2% / pt; MaxResourcePoints +5 / pt in case of Mana; up to (45pt)

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

    public void setMaxXP(double maxXP) {
        this.maxXP = maxXP;
    }

    public double getCurrentXP() {
        return currentXP;
    }

    public void setCurrentXP(double currentXP) {
        this.currentXP = currentXP;
    }
}
