package de.seniorenheim.mythcraft.Commands;

import com.mojang.authlib.GameProfile;
import de.seniorenheim.mythcraft.Utils.IO.IOUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ClientInformation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_20_R3.CraftServer;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class NPCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {}
        else {
            Player p = (Player) sender;

            if (args.length == 1 && p.isOp()) {
                switch (args[0]) {
                    case "create" -> {
                        MinecraftServer server = ((CraftServer) p.getServer()).getServer();
                        ServerLevel world = ((CraftWorld) p.getWorld()).getHandle();
                        GameProfile profile = new GameProfile(UUID.randomUUID(), "Default Name");
                        ServerPlayer npc = new ServerPlayer(server, world, profile, ClientInformation.createDefault());

                        npc.spawnIn(world);
                        npc.setPos(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());

                        List<ServerPlayer> npcs = IOUtils.readNPCs();
                        npcs.add(npc);
                        IOUtils.saveNPCs(npcs);
                    }
                    case "remove" -> {
                        List<Entity> entities = p.getNearbyEntities(2, 2, 2);
                        if (!entities.isEmpty()) {
                            for (Entity entity : entities) {
                                if (entity instanceof Player) {
                                    ServerPlayer sp = ((CraftPlayer) entity).getHandle();

                                    List<ServerPlayer> npcs = IOUtils.readNPCs();
                                    if (npcs.remove(sp)) {
                                        IOUtils.saveNPCs(npcs);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
