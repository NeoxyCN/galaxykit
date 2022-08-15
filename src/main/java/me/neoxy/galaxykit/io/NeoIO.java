package me.neoxy.galaxykit.io;

import com.moandjiezana.toml.Toml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class NeoIO {
    public String loadFile(String path) {
        //TODO 需要美化
        String content = "";
        StringBuffer raw = new StringBuffer();
        try {
            BufferedReader i = new BufferedReader(new FileReader(path));

            while ((content = i.readLine()) != null) {
                raw.append(new String(content) + "\n");
            }

        } catch (Exception e) {

        }
        return (raw.toString());
    }

    public String saveFile(String path) {
        return "";
    }

    public File simpleFileLoad(String path) {
        return (new File(path));
    }

    public Toml loadToml(String path) {
        return (new Toml().read(new NeoIO().simpleFileLoad(path)));
    }

    public void loadLang(String path) {
    }
}
