package me.ctimet.specialbekt.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.ctimet.specialbekt.data.StickData;
import me.ctimet.specialbekt.log.Chat;
import me.ctimet.specialbekt.log.Color;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Optional;

public class FixStick extends SlimefunItem {
    public FixStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) FixStick::onClick);
    }

    private static void onClick(PlayerRightClickEvent event) {
        event.cancel();
        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else return;

        Chat chat = new Chat(event.getPlayer());

        if (BlockStorage.check(block) != null) {
            chat.sendMessageWithoutHead("插件认为该方块未损坏，不可修复！", Color.YELLOW);
            return;
        }
        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + Objects.requireNonNull(location.getWorld()).getName();

        String json = StickData.getBlockData(xyz);
        if (json != null) {
            BlockStorage.setBlockInfo(block, json, true);
            StickData.remove(xyz);
            chat.sendInfo("方块已被修复");
        } else {
            chat.sendErr("该方块未被注册，不可修复！");
        }
    }
}
