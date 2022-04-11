package de.fleetadmiraljakob.inferno;

import de.fleetadmiraljakob.inferno.commands.HealCommand;
import de.fleetadmiraljakob.inferno.commands.SpawnCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Inferno extends JavaPlugin {

    public static String PREFIX = "§aInferno §7§o";
    public static Inferno INSTANCE;

    public Inferno() {
        INSTANCE = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.register();

        log("Plugin loaded.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("Unload Plugin");
    }

    public void log (String text) {
        Bukkit.getConsoleSender().sendMessage(PREFIX + text);
    }

    private void register() {
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
        Bukkit.getPluginCommand("spawn").setExecutor(new SpawnCommand());
    }
}
