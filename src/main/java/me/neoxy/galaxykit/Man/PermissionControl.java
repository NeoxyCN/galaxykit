package me.neoxy.galaxykit.Man;

import com.moandjiezana.toml.Toml;
import me.neoxy.galaxykit.IO.NeoIO;
import org.slf4j.Logger;

import java.util.List;

public class PermissionControl {
    private final Logger logger;

    public PermissionControl(Logger logger) {
        this.logger = logger;
    }

    //依据用户名查询所在组
    public String checkGroupByUsername(String username) {
        Toml tom = (new NeoIO().loadToml("./plugins/galaxykit/group.toml"));
        List<Object> groupList = tom.getList("group");
        //这里得到group 然后读取所有的组 挨个组遍历
        String trueGroup = "";
        int size = groupList.size();
        int i;
        //TODO 应该可以用List优化的
        for (i = 0; i < size; i = i + 1) {
            String groupName = groupList.get(i).toString();
            List<Object> userList = tom.getList(groupName);
            int size_USER = userList.size();
            int i2;
            //草 这里有个大坑 计数是从0开始的 而实际上有用户数量是2
            //num 0 user[0] 0<=2
            //num 1 user[1] 1<=2
            //num 2 -> error user[2] not defined 2<=2
            for (i2 = 0; i2 < size_USER; i2 = i2 + 1) {
                String getUsername = userList.get(i2).toString();
                if (getUsername.equals(username)) {
                    trueGroup = groupName;
                    return trueGroup;
                }
            }
        }
        return "default";

    }

    //依据组和命令 查询是否能用这个命令
    public boolean checkAvaByGroupAndCmd(String group, String command) {
        if (group.equals("admin")) {
            return true;
        }
        Toml tom = (new NeoIO().loadToml("./plugins/galaxykit/permission.toml"));
        List<Object> permissionList = tom.getList(group);
        if (permissionList.contains(command)) {
            return true;
        }
        return false;
    }

    //依据组 查询所有可用命令
    public String checkCmdByGroup(String group) {
        Toml tom = (new NeoIO().loadToml("./plugins/galaxykit/permission.toml"));
        List<String> permissionList = tom.getList(group);
        String str = String.join(",", permissionList);
        return str;
    }
}
