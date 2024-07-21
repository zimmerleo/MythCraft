package de.seniorenheim.mythcraft.Listeners;

import de.seniorenheim.mythcraft.Classes.Assassin.Assassin;
import de.seniorenheim.mythcraft.Classes.Hunter.Hunter;
import de.seniorenheim.mythcraft.Classes.Magician.Magician;
import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.Classes.Warrior.Warrior;
import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.Interactions.InteractionUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.HashMap;

public class InteractListener implements Listener {

    private HashMap<String, org.bukkit.event.block.Action[]> actionMap = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getHand() == EquipmentSlot.OFF_HAND) { return; }
        Player p = e.getPlayer();
        PlayerClass pc = MythCraft.getInstance().getPlayingCharacters().get(p.getName());

        org.bukkit.event.block.Action[] actions = actionMap.containsKey(p.getName()) ? actionMap.get(p.getName()) : new org.bukkit.event.block.Action[3];

        for (int i = 0; i < actions.length; i++) {
            if (actions[i] == null) {

                if (e.getItem() != null && e.getItem().getType() == pc.getMaterial()) {
                    if (i == 0) {
                        if (pc instanceof Assassin || pc instanceof Warrior) {
                            switch (e.getAction()) {
                                case RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK -> {
                                    actions[i] = e.getAction();
                                }
                            }
                        } else if (pc instanceof Magician) {
                            switch (e.getAction()) {
                                case LEFT_CLICK_AIR, LEFT_CLICK_BLOCK -> {
                                    actions[i] = e.getAction();
                                }
                                case RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK -> {
                                    InteractionUtils.magician_basicAttack(p);
                                }
                            }
                        } else if (pc instanceof Hunter) {
                            switch (e.getAction()) {
                                case LEFT_CLICK_AIR, LEFT_CLICK_BLOCK -> {
                                    actions[i] = e.getAction();
                                }
                                case RIGHT_CLICK_AIR, RIGHT_CLICK_BLOCK -> {
                                    InteractionUtils.hunter_basicAttack(p);
                                }
                            }
                        }
                    } else {
                        actions[i] = e.getAction();
                    }
                }

                if (actions[actions.length - 1] != null) {
                    actionMap.remove(p.getName());
                    InteractionUtils.performInteractions(actions, pc, p);
                } else {
                    actionMap.put(p.getName(), actions);
                }
                break;
            }
        }
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(InteractionUtils.convertActionsToString(actions)));
    }
}
