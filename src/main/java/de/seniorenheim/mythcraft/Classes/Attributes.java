package de.seniorenheim.mythcraft.Classes;

public class Attributes {

    private int strength; //Damage +0.5% / pt; Penetration +0.25 % / pt; up to (up to 100pt)
    private int dexterity; //DodgeChance +1.5% / pt; ResourceRegeneration +0.25 / pt; up to (60pt)
    private int agility; //Speed buff?; MaxResourcePoints +5 / pt in case of Energy; up to (??pt)
    private int luck; //CritChance +1.5% / pt LootChance +0.5% / pt; up to (60pt);
    private int constitution; //MaxHitPoints +5% / pt; DamageReflection +0.5% / pt; up to (60pt)
    private int resistance; //DamageReduction +2% / pt; MaxResourcePoints +5 / pt in case of Rage; up to (45pt)
    private int intelligence; //CooldownReduction 2% / pt; MaxResourcePoints +5 / pt in case of Mana; up to (45pt)

    public Attributes(int strength, int dexterity, int agility, int luck, int constitution, int resistance, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.luck = luck;
        this.constitution = constitution;
        this.resistance = resistance;
        this.intelligence = intelligence;
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
}
