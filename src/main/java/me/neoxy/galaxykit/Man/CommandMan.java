package me.neoxy.galaxykit.Man;

public class CommandMan {
    public String Analyze(String command) {
        //此处传入的命令形式应为 op NeoxyCN 这种不带/的形式
        String[] commandArray = command.split(" ");
        return commandArray[0];
    }
}
