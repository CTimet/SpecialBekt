package io.github.ctimet.specialbekt.listener;

import io.github.ctimet.specialbekt.items.RegisterStick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class AutoRegisterListener implements Listener {
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        RegisterStick.registerBlock(event.getPlayer(), event.getBlock());
    }
}
