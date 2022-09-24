package me.ctimet.specialbekt;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.ctimet.specialbekt.items.FixStick;
import me.ctimet.specialbekt.items.RegisterStick;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class BItems {
    public static final SlimefunItemStack SPECIAL_BEKT_SUPERFIX_REG = new SlimefunItemStack(
            "SPECIAL_BEKT_SUPERFIX_REG",
            Material.STICK,
            "&a超级修复-注册",
            "",
            "&7注册你的机器",
            "&7当你的机器被卡掉时",
            "&7可以通过 &b超级修复-修复&7 来修复你的机器"
    );
    public static final SlimefunItemStack SPECIAL_BEKT_SUPERFIX_FIX = new SlimefunItemStack(
            "SPECIAL_BEKT_SUPERFIX_FIX",
            Material.STICK,
            "&a超级修复-修复",
            "",
            "&7修复你的机器",
            "&7当你的机器被卡成原版方块时",
            "&7你可以用此物品右键机器来修复你的机器",
            "&7前提是你的机器必须已经经过 &b超级修复-注册 &7注册",
            "&7未被注册的机器将&4修复失败！"
    );
    public static void registerItems() {
        new RegisterStick(
                BItemGroup.getSpecialBektItemGroup(),
                SPECIAL_BEKT_SUPERFIX_REG,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, item(Material.STONE), null,
                        null, item(Material.STONE), null,
                        null, item(Material.STONE), null
                }
        ).register(Main.getInstance());
        new FixStick(
                BItemGroup.getSpecialBektItemGroup(),
                SPECIAL_BEKT_SUPERFIX_FIX,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[] {
                        null, item(Material.REDSTONE), null,
                        null, item(Material.REDSTONE), null,
                        null, item(Material.REDSTONE), null
                }
        ).register(Main.getInstance());
    }
    private static ItemStack item(Material material) {
        return new ItemStack(material);
    }
}
