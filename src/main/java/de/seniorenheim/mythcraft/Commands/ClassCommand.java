package de.seniorenheim.mythcraft.Commands;

import de.seniorenheim.mythcraft.Classes.PlayerClassUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClassCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            PlayerClassUtils.openClassChoosingInventory(player);

        }
        return false;
    }
}
