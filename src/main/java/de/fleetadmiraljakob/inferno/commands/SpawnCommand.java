package de.fleetadmiraljakob.inferno.commands;

import de.fleetadmiraljakob.inferno.Inferno;
import de.fleetadmiraljakob.inferno.utils.FileConfig;
import de.fleetadmiraljakob.inferno.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player))
            return true;

        Player player = (Player) sender;
        FileConfig spawns = new FileConfig("locations.yml");
        if(label.equalsIgnoreCase("setspawn")) {
            if(player.hasPermission("de.fleetadmiraljakob.inferno.setspawn")) {
                spawns.set("spawn", LocationUtils.loc2Str(player.getLocation()));
                spawns.saveConfig();
                player.sendMessage(Inferno.PREFIX + "Spawn set.");
            } else {
                player.sendMessage(Inferno.PREFIX + "§cYou've no rights to set the spawn.");
            }
            return true;
        }

        if (spawns.contains("spawn")) {
            LocationUtils.teleport(player, LocationUtils.str2Loc(spawns.getString("spawn")));
        } else {
            player.sendMessage(Inferno.PREFIX + "No spawn has been set yet.");
        }

        return true;
    }
}