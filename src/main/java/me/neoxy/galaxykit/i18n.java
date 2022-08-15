package me.neoxy.galaxykit;

public class i18n {
    // info1 - Init
    // error1 - Perm limited

    private String language = "en-US";

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
        return "none";
    }
}
