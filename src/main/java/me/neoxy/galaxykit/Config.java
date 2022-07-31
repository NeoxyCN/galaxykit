package me.neoxy.galaxykit;

import java.io.BufferedReader;
import java.io.FileReader;

import me.neoxy.galaxykit.Galaxykit;

public class Config {
    public String loadConfig() {
        String content = "";
        StringBuffer raw = new StringBuffer();
        try {
            BufferedReader i = new BufferedReader(new FileReader("./plugins/galaxykit/config.yml"));
            while ((content = i.readLine()) != null) {
                raw.append(content);
            }

        } catch (Exception e) {

        }
        return (raw.toString());
    }
}
