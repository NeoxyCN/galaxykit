package me.neoxy.galaxykit;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ConsoleCommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "galaxykit",
        name = "GalaxyKit",
        version = "1.0-SNAPSHOT",
        description = "Plugin for ALLSTARS S3",
        authors = {"Neoxy"}
)
public class Galaxykit {
    public final ProxyServer server;
    private final Logger logger;

    @Inject
    public Galaxykit(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("GalaxyKit has been initialized。");
        //Config config = new Config();
        //logger.info(config.loadConfig());
    }

    @Subscribe
    public void onCommandExecute(CommandExecuteEvent event) {
        PermissionControl ppp = new PermissionControl(logger);
        logger.info(ppp.checkCmdByGroup("admin"));
        if (event.getCommandSource() instanceof ConsoleCommandSource) {
            //Console execute command
        } else if (event.getCommandSource() instanceof Player) {
            //Player execute command
            //TODO 权限控制从这里开始
            PermissionControl pc = new PermissionControl(logger);
            String groupName = (pc.checkGroupByUsername("username"));
            Boolean status = (pc.checkAvaByGroupAndCmd(groupName, event.getCommand()));
            if (!status) {
                event.setResult(CommandExecuteEvent.CommandResult.denied());
                MessageMan m = new MessageMan();
                m.sendPlayerMessage(event.getCommandSource(), "Your command has been denied, becaused you don not have the permission to do that.");
            }
        }
    }
}
