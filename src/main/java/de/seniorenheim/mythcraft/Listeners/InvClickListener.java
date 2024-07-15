package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.Assassin.Assassin;
import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Utils.Inventories.ClassCreatingInventory;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import de.seniorenheim.mythcraft.Utils.PlayerClasses.PlayerClassUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class InvClickListener implements Listener {

    private static int slotSave;

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        HashMap<String, PlayerClass> playingCharacters = MythCraft.getPlugin(MythCraft.class).getPlayingCharacters();
        HashMap<String, List<PlayerClass>> existingCharacters = (IOUtils.readYaml() != null ? IOUtils.readYaml() : new HashMap<>());
        PlayerClass[] playerClasses = (existingCharacters.isEmpty() ? new PlayerClass[10] : IOUtils.convert(existingCharacters.get(p.getName())));

        switch (e.getView().getTitle()) {
            case "§6Your characters" -> {
                if (e.getCurrentItem() != null) {
                    ItemStack item = e.getCurrentItem();

                    if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {

                        switch (item.getItemMeta().getDisplayName()) {
                            case "§a+ >>" -> {
                                slotSave = e.getSlot();
                                p.openInventory(new ClassCreatingInventory().getInventory());
                            }
                            default -> {
                                PlayerClass chosenClass = playerClasses[PlayerClassUtils.transformInvSlotToIndex(e.getSlot())];

                                setNewCharacter(p, playingCharacters, existingCharacters, playerClasses, chosenClass);
                            }
                        }
                    }
                }

            } case "§6Create a new character" -> {
                if (e.getCurrentItem() != null) {
                    ItemStack item = e.getCurrentItem();

                    if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {

                        switch (item.getItemMeta().getDisplayName()) {
                            case "§2Assassin" -> {
                                Assassin assassin = new Assassin();
                                assassin.setSlot(PlayerClassUtils.transformInvSlotToIndex(slotSave));
                                playerClasses[PlayerClassUtils.transformInvSlotToIndex(slotSave)] = assassin;

                                setNewCharacter(p, playingCharacters, existingCharacters, playerClasses, assassin);
                            }
                            default -> {}
                        }
                    }
                }
            }
            default -> {}
        }
    }

    private void setNewCharacter(Player p, HashMap<String, PlayerClass> playingCharacters, HashMap<String, List<PlayerClass>> existingCharacters, PlayerClass[] playerClasses, PlayerClass chosenClass) {
        if (playingCharacters.containsKey(p.getName())) {
            PlayerClass previousClass = playingCharacters.get(p.getName());

            playerClasses[previousClass.getSlot()] = previousClass;

            existingCharacters.put(p.getName(), IOUtils.convert(playerClasses));
            IOUtils.saveYaml(existingCharacters);
        }
        playingCharacters.put(p.getName(), chosenClass);
    }
}
