package me.neoxy.galaxykit;

import com.moandjiezana.toml.Toml;
import me.neoxy.galaxykit.NeoIO;

public class Config {
    public Toml loadConfig() {
        //return ((new NeoIO()).loadFile("./plugins/galaxykit/config.yml"));
        return (new NeoIO().loadToml("./plugins/galaxykit/config.toml"));
    }
}
