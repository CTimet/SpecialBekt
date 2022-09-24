package me.ctimet.specialbekt.items;

import me.ctimet.specialbekt.log.Chat;
import me.ctimet.specialbekt.data.StickData;
import me.ctimet.specialbekt.log.Color;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;
import java.util.Optional;

public class RegisterStick extends SlimefunItem {
    public RegisterStick(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        this.addItemHandler((ItemUseHandler) RegisterStick::onClick);
    }

    private static void onClick(PlayerRightClickEvent event) {
        event.cancel();
        Optional<Block> b = event.getClickedBlock();
        Block block;
        if (b.isPresent()) {
            block = b.get();
        } else return;

        Player player = event.getPlayer();
        registerBlock(player, block);
    }

    public static void registerBlock(Player player, Block block) {
        Chat chat = new Chat(player);
        if (BlockStorage.check(block) == null) {
            chat.sendMessageWithoutHead("不可注册非sf方块", Color.YELLOW);
            return;
        }

        Location location = block.getLocation();
        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + Objects.requireNonNull(location.getWorld()).getName();

        if (StickData.contains(xyz)) {
            chat.sendMessageWithoutHead("该方块已被注册", Color.YELLOW);
            return;
        }

        StickData.putBlockData(xyz, BlockStorage.getBlockInfoAsJson(block));

        chat.sendMessageWithoutHead("方块已成功注册", Color.GREEN);
    }
}
