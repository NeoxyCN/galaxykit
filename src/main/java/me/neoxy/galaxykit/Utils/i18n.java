package me.neoxy.galaxykit.Utils;

import me.neoxy.galaxykit.IO.NeoIO;

import java.io.BufferedReader;
import java.io.IOException;

public class i18n {
    // line 1 info1 - Init
    // line 2 error1 - Perm limited
    enum code {
        na,//line 0 不存在
        info1,//line 1
        error1;
    }

    private String language = "en-US";
    private NeoIO nio = new NeoIO();

    public i18n(String lang) {
        switch (lang) {
            case "en-US":
                break;
            case "zh-CN":
                language = lang;
                break;
            default:
                break;
        }
    }

    public String loadString(String key) {
        // info1->line1
        //先得到info1在第几行
        //然后Line=num就行了

        //这里判断key在enum的第几个
        int num = 0;
        for (code i : code.values()) {
            if (i.equals(key)) {
                num = i.ordinal();
            }
        }

        BufferedReader bf = nio.loadLang(language);
        try {
            int line = 0;
            String s;
            while ((s = bf.readLine()) != null) {
                //根据在第几行 取第几个lang line=1 ->读第一行
                line++;
                if (line == num) {
                    return s;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "none";
    }
}
