package de.seniorenheim.mythcraft.Utils.Trackers;

import de.seniorenheim.mythcraft.MythCraft;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.List;

public class NPCTracker {

    public NPCTracker() {
        trackNPCs();
    }

    private void trackNPCs() {
        List<ServerPlayer> npcs = IOUtils.readNPCs();

        Bukkit.getScheduler().runTaskTimer(MythCraft.getPlugin(MythCraft.class), new Runnable() {
            @Override
            public void run() {
                if (!npcs.isEmpty() && !Bukkit.getOnlinePlayers().isEmpty()) {
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        ServerPlayer sp = ((CraftPlayer) p).getHandle();

                        for (ServerPlayer npc : npcs) {

                            //SEND PACKETS TO SPAWN?

                            if (npc.hasLineOfSight(sp) && npc.distanceTo(sp) <= 7) {
                                ServerGamePacketListenerImpl connection = sp.connection;

                                //SEND PACKETS TO ROTATE & MOVE;
                            }
                        }
                    }
                }
            }
        }, 0, 5);
    }
}
