package net.angusbeefgaming.antiprofpro;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class AntiProfPro extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Performium Anti-Curse Enabled and ready to protect chat!");
        // Setup the Event Listener
        getServer().getPluginManager().registerEvents(new onCurseWord(), this);
        // Setup the Config file
    }
    @Override
    public void onDisable() {
        getLogger().warning("Alert! Performium Anti-Curse has been Disabled!");
    }
}
    