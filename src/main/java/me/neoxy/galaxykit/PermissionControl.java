package me.neoxy.galaxykit;

import com.moandjiezana.toml.Toml;
import me.neoxy.galaxykit.NeoIO;

import java.util.List;

public class PermissionControl {
    //依据用户名查询所在组
    public String checkGroupByUsername(String username) {
        Toml tom = (new NeoIO().loadToml("./plugins/galaxykit/group.toml"));
        List<Object> groupList = tom.getList("group");
        //这里得到group 然后读取所有的组 挨个组遍历


        return "s";
    }

    //依据组和命令 查询是否能用这个命令
    public boolean checkAvaByGroupAndCmd(String group, String command) {
        return false;
    }

    //依据组 查询所有可用命令
    public String checkCmdByGroup(String group) {
        return "";
    }
}
