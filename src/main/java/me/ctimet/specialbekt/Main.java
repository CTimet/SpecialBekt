package me.ctimet.specialbekt;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements SlimefunAddon {
    private static Main instance;
    private static Config cfg;
    private static final ItemGroup SPECIAL_BEKT_ITEM_GROUP = new ItemGroup(new NamespacedKey(Main.getInstance(), "SPECIAL_BEKT_ITEM_GROUP"), new CustomItemStack(Material.BEDROCK, "&lSpecialBekt"));
    @Override
    public void onEnable() {
        instance = this;
        cfg = new Config(this);
        BItems.registerItems();
        if (cfg.getBoolean("options.check-update"))
            new GuizhanBuildsUpdater(instance, getFile(), "CTimet", "SpecialBekt", "master", false).start();
    }

    @Override
    public void onDisable() {

    }

    public static Config getCfg() {
        return cfg;
    }

    public static Main getInstance() {
        return instance;
    }

    public static ItemGroup getSpecialBektItemGroup() {
        return SPECIAL_BEKT_ITEM_GROUP;
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
