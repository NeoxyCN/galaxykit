package me.neoxy.galaxykit;

import com.moandjiezana.toml.Toml;
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
        //logger.info("groupSize:" + size);
        int i;
        for (i = 0; i < size; i = i + 1) {
            //logger.info("now num is:" + i);
            String groupName = groupList.get(i).toString();
            //logger.info("noew groupName is:" + groupName);
            List<Object> userList = tom.getList(groupName);
            int size_USER = userList.size();
            //logger.info("siez_user:" + size_USER);
            int i2;
            //草 这里有个大坑 计数是从0开始的 而实际上有用户数量是2
            //num 0 user[0] 0<=2
            //num 1 user[1] 1<=2
            //num 2 -> error user[2] not defined 2<=2
            for (i2 = 0; i2 < size_USER; i2 = i2 + 1) {
                //logger.info("now user num is" + i2);
                //logger.info(userList.get(i2).toString()+"11");
                //logger.info("username is" + username+"111");
                String getUsername = userList.get(i2).toString();
                username.toString();
                if (getUsername == username) {


                } else {
                    logger.info("应该能看见 说明判断一样");
                    trueGroup = groupName;
                    return trueGroup;
                }
            }
        }
        return "default";

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
