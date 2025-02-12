package de.seniorenheim.mythcraft.Classes;

import de.seniorenheim.mythcraft.Quests.AbstractQuest;
import de.seniorenheim.mythcraft.Utils.Resources.Resource;
import org.bukkit.Material;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public class PlayerClass {

    private final String className;
    private final Resource resource;
    private final Material material;
    private int slot;
    //TODO
    private PlayerInventory inv;


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
    private short level;
    private double maxXP;
    private double currentXP;

    //TODO
    //private final List<AbstractQuest> quests;

    public PlayerClass(List<AbstractQuest> quests, double currentXP, double maxXP, short level, double currentResourcePoints, double maxResourcePoints, double currentHitPoints, double maxHitPoints, int intelligence, int resistance, int constitution, int luck, int agility, int dexterity, int strength, PlayerInventory inv, int slot, Material material, Resource resource, String className) {
        //this.quests = quests;
        this.currentXP = currentXP;
        this.maxXP = maxXP;
        this.level = level;
        this.currentResourcePoints = currentResourcePoints;
        this.maxResourcePoints = maxResourcePoints;
        this.currentHitPoints = currentHitPoints;
        this.maxHitPoints = maxHitPoints;
        this.intelligence = intelligence;
        this.resistance = resistance;
        this.constitution = constitution;
        this.luck = luck;
        this.agility = agility;
        this.dexterity = dexterity;
        this.strength = strength;
        this.inv = inv;
        this.slot = slot;
        this.material = material;
        this.resource = resource;
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public Resource getResource() {
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

    public PlayerInventory getInv() {
        return inv;
    }

    public void setInv(PlayerInventory inv) {
        this.inv = inv;
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

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
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

    /*public List<AbstractQuest> getQuests() {
        return quests;
    }*/
}
