package de.seniorenheim.mythcraft.Utils.Interactions;

import de.seniorenheim.mythcraft.Classes.PlayerClass;
import de.seniorenheim.mythcraft.MythCraft;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public class InteractionUtils {

    public static String convertActionsToString(Action[] actions) {
        StringBuilder result = new StringBuilder();
        for (Action a : actions) {
            if (a == null) {
                result.append(" ");
            } else {
                result.append(a == Action.LEFT_CLICK_AIR || a == Action.LEFT_CLICK_BLOCK ? "§dL §7> " : "§bR §7> ");
            }
        }
        return result.substring(0, result.length()-2);
    }

    public static void performInteractions(org.bukkit.event.block.Action[] actions, PlayerClass pc, Player p) {
        switch (pc.getClassName()) {
            case "Assassin" -> {
                if (actions[1].equals(Action.LEFT_CLICK_AIR) || actions[1].equals(Action.LEFT_CLICK_BLOCK)) {
                    if (actions[2].equals(Action.LEFT_CLICK_AIR) || actions[2].equals(Action.LEFT_CLICK_BLOCK)) {

                    } else {

                    }
                } else {
                    if (actions[2].equals(Action.LEFT_CLICK_AIR) || actions[2].equals(Action.LEFT_CLICK_BLOCK)) {

                    } else {

                    }
                }

            } case "Hunter" -> {

            } case "Magician" -> {

            } case "Warrior" -> {

            }
        }
    }

    //UNFINISHED
    public static void assassin_knifeThrow(Player player) {
        Location location = player.getEyeLocation();
        Vector direction = location.getDirection();

        ArmorStand knifeStand = (ArmorStand) player.getWorld().spawnEntity(location.add(direction.multiply(1.5)).add(0, -2, 0), EntityType.ARMOR_STAND);
        knifeStand.setVisible(false);
        knifeStand.setGravity(false);
        knifeStand.setMarker(true);
        knifeStand.setHelmet(new ItemStack(Material.SHEARS));

        new BukkitRunnable() {
            @Override
            public void run() {
                if (knifeStand.isDead() || !knifeStand.isValid()) {
                    this.cancel();
                    return;
                }

                Location knifeLocation = knifeStand.getLocation().add(direction);

                for (LivingEntity entity : knifeLocation.getWorld().getLivingEntities()) {
                    if (entity.getLocation().distance(knifeLocation) < 1 && !entity.equals(player)) {
                        player.sendMessage("Hit!");
                        //DMG
                        knifeStand.remove();
                        this.cancel();
                        return;
                    }
                }

                knifeStand.teleport(knifeLocation);
            }
        }.runTaskTimer(MythCraft.getPlugin(MythCraft.class), 0, 1);
    }

    //UNFINISHED
    private static void bladedancer_knifeStorm(Player p, int level) {
        Random random = new Random();

        for (int i = 0; i < 50; i++) {
            double angle = random.nextDouble() * 2 * Math.PI;
            double xOffset = 3 * level * Math.cos(angle);
            double zOffset = 3 * level * Math.sin(angle);

            Location spawnLocation = p.getLocation().clone().add(xOffset, -1, zOffset);

            ArmorStand armorStand = p.getWorld().spawn(spawnLocation, ArmorStand.class);
            armorStand.setVisible(false);
            armorStand.setGravity(false);
            armorStand.setMarker(true);
            armorStand.getEquipment().setHelmet(new ItemStack(Material.SHEARS));

            Bukkit.getScheduler().runTaskLater(MythCraft.getPlugin(MythCraft.class), new Runnable() {
                @Override
                public void run() {
                    armorStand.remove();
                }
            }, 20L * 5 * level);
        }
    }
}
