package io.github.ctimet.specialbekt;

import io.github.ctimet.specialbekt.data.stickdata.StickData;
import io.github.ctimet.specialbekt.listener.AutoRegisterListener;
import io.github.ctimet.specialbekt.listener.MachineProtectListener;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class BektMain extends JavaPlugin implements SlimefunAddon {
    private static BektMain instance;
    private static Config cfg;
    @Override
    public void onEnable() {
        instance = this;
        cfg = new Config(this);
        saveDefaultConfig();
        saveResource("block.dat", false);
        BItemGroup.register();
        BItems.registerItems();
        StickData.init();
        //20221003
        Bukkit.getPluginManager().registerEvents(new MachineProtectListener(), this);
        if (cfg.getBoolean("options.auto-register"))
            Bukkit.getPluginManager().registerEvents(new AutoRegisterListener(), this);
        if (cfg.getBoolean("options.check-update"))
            new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "SpecialBekt", "master", false).start();
    }

    @Override
    public void onDisable() {
        StickData.stop();
    }

    public static Config getCfg() {
        return cfg;
    }

    public static BektMain getInstance() {
        return instance;
    }

    @Override
    public @NotNull JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/CTimet/SpecialBekt/issues";
    }
}
