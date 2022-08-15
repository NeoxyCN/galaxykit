package me.neoxy.galaxykit;

import com.moandjiezana.toml.Toml;

import java.util.ArrayList;
import java.util.List;

public class Config {
    private Toml t;
    private final String path = "./plugins/galaxykit/config.toml";

    public Toml loadConfig() {
        //return ((new NeoIO()).loadFile("./plugins/galaxykit/config.yml"));
        return t;
    }

    public void Config() {
        t = new NeoIO().loadToml(path);
    }

    //这里是直接加载config.toml中的一个Key（大概叫这个名字吧
    public String loadKey(String keyName) {
        try {
            switch (keyName) {
                case "disable-sevrer":
                    List<Object> list = t.getList("disable-server");
                    break;
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
                case "disable-sevrer":
                    List = t.getList("disable-server");
                    break;
            }
        } catch (Exception e) {

        }

        return List;
    }
}
