package me.ctimet.specialbekt.items;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.ctimet.specialbekt.data.PlayerBlock;
import me.ctimet.specialbekt.data.StickData;
import me.ctimet.specialbekt.log.Chat;
import me.ctimet.specialbekt.log.Color;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
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

        PlayerBlock pb = StickData.getBlockData(xyz);
        if (pb != null) {
            Material material = pb.material();
            if (material == block.getType()) {
                BlockStorage.setBlockInfo(block, pb.json(), true);
                StickData.remove(xyz);
                chat.sendInfo("方块已修复");
            } else {
                chat.sendErr("方块类型匹配错误！插件无法修复方块");
            }
        } else {
            chat.sendMessageWithoutHead("该方块未被注册，插件无法修复", Color.YELLOW);
        }
    }
}
