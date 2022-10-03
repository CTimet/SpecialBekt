package io.github.ctimet.specialbekt.listener;

import io.github.ctimet.specialbekt.data.stickdata.StickData;
import io.github.thebusybiscuit.slimefun4.api.events.AndroidMineEvent;
import io.github.thebusybiscuit.slimefun4.api.events.BlockPlacerPlaceEvent;
import io.github.thebusybiscuit.slimefun4.api.events.ExplosiveToolBreakBlocksEvent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityChangeBlockEvent;

import java.util.List;
import java.util.Objects;

public class MachineProtectListener implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public static void onPlace(BlockPlaceEvent event)
    {
        //方块放置
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBreak(BlockBreakEvent event)
    {
        //方块破坏
        protect(event.getBlock());
    }

    @EventHandler
    public static void onIgnite(BlockIgniteEvent event)
    {
        //方块被燃烧
        protect(event.getBlock());
    }

    @EventHandler
    public static void onPiston(BlockPistonExtendEvent event)
    {
        //活塞事件
        for (Block block : event.getBlocks()) protect(block);
    }

    @EventHandler
    public static void onBlockExp(BlockExplodeEvent event)
    {
        //方块爆炸事件
        List<Block> blocks = event.blockList();
        for (Block block : blocks) {
            protect(block);
        }
    }

    @EventHandler
    public static void onEntityChangeBlock(EntityChangeBlockEvent event)
    {
        //实体修改方块事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBlockDropItem(BlockDropItemEvent event)
    {
        //方块掉落事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onAndroidBreakBlock(AndroidMineEvent event)
    {
        //机器人挖掘方块事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onBlockPlayerPlace(BlockPlacerPlaceEvent event)
    {
        //BlockPlayer放置方块事件
        protect(event.getBlock());
    }

    @EventHandler
    public static void onExplosiveToolBreakBlocks(ExplosiveToolBreakBlocksEvent event)
    {
        //爆炸工具爆炸事件
        protect(event.getPrimaryBlock());
        for (Block block : event.getAdditionalBlocks())
        {
            protect(block);
        }
    }

    //------------------------------自动保护机制------------------------------//

    public static void protect(Block block)
    {
        Location location = block.getLocation();

        String xyz = location.getX() + "&" + location.getY() + "&" + location.getZ() + "&" + Objects.requireNonNull(location.getWorld()).getName();

        StickData.removeData(xyz);
    }
}
