package me.neoxy.galaxykit;

import me.neoxy.galaxykit.Utils.i18n;
import org.slf4j.Logger;

public class Initialization {
    public static void Init(Logger logger) {
        Config conf = new Config();
        i18n i = new i18n(conf.loadKey("language"));
        logger.info(i.loadLang("info1"));
    }
}
