package me.ctimet.specialbekt;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class BItemGroup {
    private static final ItemGroup SPECIAL_BEKT_ITEM_GROUP = new ItemGroup(new NamespacedKey(Main.getInstance(), "SPECIAL_BEKT_ITEM_GROUP"), new CustomItemStack(Material.BEDROCK, "&lSpecialBekt"));
    public static ItemGroup getSpecialBektItemGroup() {
        return SPECIAL_BEKT_ITEM_GROUP;
    }
    public static void register() {
        SPECIAL_BEKT_ITEM_GROUP.register(Main.getInstance());
    }
}
