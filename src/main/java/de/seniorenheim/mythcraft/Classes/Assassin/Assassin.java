package de.seniorenheim.mythcraft.Classes.Assassin;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Resources.Resources;
import de.seniorenheim.mythcraft.Utils.PlayerClassUtils;
import org.bukkit.Material;

public class Assassin extends PlayerClass {
    public Assassin() {
        super("Assassin", Resources.ENERGY, Material.SHEARS, 0, 0, 0, 0, 0, 0, 0,0, 100, 100, 100, 100, 0, PlayerClassUtils.calculateMaxXP(0), 0);
    }

    public Assassin(String className, Resources resource, Material material, int slot, int strength, int dexterity, int agility, int luck, int constitution, int resistance, int intelligence, double maxHitPoints, double currentHitPoints, double maxResourcePoints, double currentResourcePoints, int level, double maxXP, double currentXP) {
        super(className, resource, material, slot, strength, dexterity, agility, luck, constitution, resistance, intelligence, maxHitPoints, currentHitPoints, maxResourcePoints, currentResourcePoints, level, maxXP, currentXP);
    }

    @Override
    public String getClassName() {
        return super.getClassName();
    }

    @Override
    public Resources getResource() {
        return super.getResource();
    }

    @Override
    public Material getMaterial() {
        return super.getMaterial();
    }

    @Override
    public int getSlot() {
        return super.getSlot();
    }

    @Override
    public void setSlot(int slot) {
        super.setSlot(slot);
    }

    @Override
    public int getStrength() {
        return super.getStrength();
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public int getDexterity() {
        return super.getDexterity();
    }

    @Override
    public void setDexterity(int dexterity) {
        super.setDexterity(dexterity);
    }

    @Override
    public int getAgility() {
        return super.getAgility();
    }

    @Override
    public void setAgility(int agility) {
        super.setAgility(agility);
    }

    @Override
    public int getLuck() {
        return super.getLuck();
    }

    @Override
    public void setLuck(int luck) {
        super.setLuck(luck);
    }

    @Override
    public int getConstitution() {
        return super.getConstitution();
    }

    @Override
    public void setConstitution(int constitution) {
        super.setConstitution(constitution);
    }

    @Override
    public int getResistance() {
        return super.getResistance();
    }

    @Override
    public void setResistance(int resistance) {
        super.setResistance(resistance);
    }

    @Override
    public int getIntelligence() {
        return super.getIntelligence();
    }

    @Override
    public void setIntelligence(int intelligence) {
        super.setIntelligence(intelligence);
    }

    @Override
    public double getMaxHitPoints() {
        return super.getMaxHitPoints();
    }

    @Override
    public void setMaxHitPoints(double maxHitPoints) {
        super.setMaxHitPoints(maxHitPoints);
    }

    @Override
    public double getCurrentHitPoints() {
        return super.getCurrentHitPoints();
    }

    @Override
    public void setCurrentHitPoints(double currentHitPoints) {
        super.setCurrentHitPoints(currentHitPoints);
    }

    @Override
    public double getMaxResourcePoints() {
        return super.getMaxResourcePoints();
    }

    @Override
    public void setMaxResourcePoints(double maxResourcePoints) {
        super.setMaxResourcePoints(maxResourcePoints);
    }

    @Override
    public double getCurrentResourcePoints() {
        return super.getCurrentResourcePoints();
    }

    @Override
    public void setCurrentResourcePoints(double currentResourcePoints) {
        super.setCurrentResourcePoints(currentResourcePoints);
    }

    @Override
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public void setLevel(int level) {
        super.setLevel(level);
    }

    @Override
    public double getMaxXP() {
        return super.getMaxXP();
    }

    @Override
    public void setMaxXP() {
        super.setMaxXP();
    }

    @Override
    public double getCurrentXP() {
        return super.getCurrentXP();
    }

    @Override
    public void setCurrentXP(double currentXP) {
        super.setCurrentXP(currentXP);
    }
}
