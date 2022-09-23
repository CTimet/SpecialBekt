package me.ctimet.specialbekt.log;

import me.ctimet.specialbekt.Main;

import java.util.logging.Logger;

public class Log {
    private static final Logger log = Main.getInstance().getLogger();
    public static void info(String mes) {
        log.info(mes);
    }
    public static void warn(String mes) {
        log.warning(mes);
    }
}
