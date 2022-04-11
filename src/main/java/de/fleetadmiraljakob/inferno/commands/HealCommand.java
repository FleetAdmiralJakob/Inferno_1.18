package de.fleetadmiraljakob.inferno.commands;

import de.fleetadmiraljakob.inferno.Inferno;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

            if(!(sender instanceof Player)) {
                Inferno.INSTANCE.log("You're not a player");
                return true;
                }

            Player player = (Player) sender;

            if(player.hasPermission("de.fletadmiraljakob.heal")) {
                player.setHealth(20d);
                player.setFoodLevel(20);
                player.sendMessage(Inferno.PREFIX + "You've been healed");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 0.2f, 1.2f);
            } else {
                player.sendMessage(Inferno.PREFIX + "§cYou've no rights to heal.");
                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.2f, 1.2f);
            }

            return true;
    }
}
