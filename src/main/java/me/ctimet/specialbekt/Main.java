package me.ctimet.specialbekt;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import me.ctimet.specialbekt.data.StickData;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements SlimefunAddon {
    private static Main instance;
    private static Config cfg;
    @Override
    public void onEnable() {
        instance = this;
        cfg = new Config(this);
        saveDefaultConfig();
        saveResource("block.dat", false);
        BItemGroup.register();
        BItems.registerItems();
        StickData.readData();
        StickData.startTimer();
        Bukkit.getPluginManager().registerEvents(new MachineProtectListener(), this);
//        if (cfg.getBoolean("options.check-update"))
//            new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "SpecialBekt", "master", false).start();
    }

    @Override
    public void onDisable() {
        StickData.stopTimer();
        StickData.saveData();
    }

    public static Config getCfg() {
        return cfg;
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/CTimet/SpecialBekt/issues";
    }
}
