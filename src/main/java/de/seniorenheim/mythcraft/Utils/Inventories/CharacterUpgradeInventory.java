package de.seniorenheim.mythcraft.Utils.Inventories;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CharacterUpgradeInventory {

    public Inventory getUpgradeInventory(PlayerClass playerClass) {
        Inventory inventory = Bukkit.createInventory(null, 27, "§6Upgrade your character");

        //TODO

        return inventory;
    }

    public Inventory getAttributeInventory(PlayerClass playerClass) {
        Inventory inventory = Bukkit.createInventory(null, 24, "§6Increase your Attributes");

        ItemStack increase = new ItemStack(Material.LIME_DYE);
        ItemMeta increaseMeta = increase.getItemMeta();
        increaseMeta.setDisplayName("§2+");
        increase.setItemMeta(increaseMeta);

        ItemStack decrease = new ItemStack(Material.RED_DYE);
        ItemMeta decreaseMeta = decrease.getItemMeta();
        decreaseMeta.setDisplayName("§4-");
        decrease.setItemMeta(decreaseMeta);

        ItemStack strength = new ItemStack(Material.YELLOW_DYE);
        ItemMeta strengthMeta = strength.getItemMeta();
        strengthMeta.setDisplayName("§cStrength");
        strengthMeta.setLore(List.of("§7> §dCurrent Level: " + playerClass.getStrength()));
        strength.setItemMeta(strengthMeta);

        ItemStack dexterity = new ItemStack(Material.YELLOW_DYE);
        ItemMeta dexterityMeta = dexterity.getItemMeta();
        dexterityMeta.setDisplayName("§eDexterity");
        dexterityMeta.setLore(List.of("§7> §dCurrent Level: " + playerClass.getDexterity()));
        dexterity.setItemMeta(dexterityMeta);

        ItemStack agility = new ItemStack(Material.YELLOW_DYE);
        ItemMeta agilityMeta = agility.getItemMeta();
        agilityMeta.setDisplayName("§fAgility");
        agilityMeta.setLore(List.of("§7> §dCurrent Level: " + playerClass.getAgility()));
        agility.setItemMeta(agilityMeta);

        ItemStack constitution = new ItemStack(Material.YELLOW_DYE);
        ItemMeta constitutionMeta = constitution.getItemMeta();
        constitutionMeta.setDisplayName("§6Constitution");
        constitutionMeta.setLore(List.of("§7> §dCurrent Level: " + playerClass.getConstitution()));
        constitution.setItemMeta(constitutionMeta);

        ItemStack resistance = new ItemStack(Material.YELLOW_DYE);
        ItemMeta resistanceMeta = resistance.getItemMeta();
        resistanceMeta.setDisplayName("§8Resistance");
        resistanceMeta.setLore(List.of("§7> §dCurrent Level: " + playerClass.getResistance()));
        resistance.setItemMeta(resistanceMeta);

        ItemStack intelligence = new ItemStack(Material.YELLOW_DYE);
        ItemMeta intelligenceMeta = intelligence.getItemMeta();
        intelligenceMeta.setDisplayName("§9Intelligence");
        intelligenceMeta.setLore(List.of("§7> §dCurrent Level: " + playerClass.getIntelligence()));
        intelligence.setItemMeta(intelligenceMeta);


        for (int i = 0; i < 7; i++) {
            inventory.setItem(i, increase);
        }

        inventory.addItem(strength, dexterity, agility, constitution, resistance, intelligence);

        for (int i = 16; i < inventory.getSize(); i++) {
            inventory.setItem(i, decrease);
        }

        return inventory;
    }
}
