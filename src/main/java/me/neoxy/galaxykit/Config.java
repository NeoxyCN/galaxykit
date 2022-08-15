package me.neoxy.galaxykit;

import com.moandjiezana.toml.Toml;
import me.neoxy.galaxykit.io.NeoIO;

import java.util.List;

public class Config {
    private Toml t;
    private final String path = "./plugins/galaxykit/config.toml";

    public Toml loadConfig() {
        //return ((new NeoIO()).loadFile("./plugins/galaxykit/config.yml"));
        return t;
    }

    public Config() {
        t = new NeoIO().loadToml(path);
    }

    //这里是直接加载config.toml中的一个Key（大概叫这个名字吧
    public String loadKey(String keyName) {
        try {
            switch (keyName) {
                case "auto-update":
                    break;
                case "language":
                    break;
                case "channel":
                    break;
            }
        } catch (Exception e) {

        }
        return "none";
    }

    public List<Object> loadList(String keyName) {
        List<Object> List = null;
        try {
            switch (keyName) {
                case "disable-server":
                    List = t.getList("disable-server");
                    return List;
            }
        } catch (Exception e) {

        }

        return List;
    }
}
