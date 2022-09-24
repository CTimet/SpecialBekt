package me.ctimet.specialbekt.data;

import me.ctimet.specialbekt.Main;
import me.ctimet.specialbekt.log.Log;

import java.io.File;

public class PluginData {
    private static final File BLOCK_DAT = new File("plugins/SpecialBekt/block.dat");

    public static void check() {
        if (!BLOCK_DAT.exists()) {
            Log.info("创建block.dat...");
            Main.getInstance().saveResource("block.dat", false);
        }
    }

    public static File getBlockDat() {
        return BLOCK_DAT;
    }
}
