package me.neoxy.galaxykit;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.player.PlayerChatEvent;
import com.velocitypowered.api.event.player.ServerConnectedEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ConsoleCommandSource;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;

@Plugin(
        id = "galaxykit",
        name = "GalaxyKit",
        version = "1.0.2",
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

    //public void

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("GalaxyKit has been initialized。");
        //Config config = new Config();
        //logger.info(config.loadConfig());
    }
/*
    @Subscribe
    public void onPlayerSendMessage(PlayerChatEvent event) {
        event.setResult(PlayerChatEvent.ChatResult.denied());
        Player player = event.getPlayer();
        String m = String.format("[%s][%s]%s",
                player.getCurrentServer().get().getServer().getServerInfo().getName(),
                player.getUsername(),
                event.getMessage()
        );
        server.getAllPlayers().forEach(s -> s.sendMessage(Component.text(m)));
    }

 */

    @Subscribe
    public void onPlayerJoinServer(ServerConnectedEvent event) {
        Player player = event.getPlayer();
        String preServer = null;
        String nowServer = player.getCurrentServer().get().getServer().getServerInfo().getName();
        try {
            preServer = event.getPreviousServer().get().getServerInfo().getName();

        } catch (Exception error) {

        }
        if (preServer == null) {
            //不存在上一个服务器
            //TODO 配置文件
            String m = String.format("[%s]%s joined %s",
                    nowServer,
                    player.getUsername(),
                    nowServer
            );
            server.getAllPlayers().forEach(s -> s.sendMessage(Component.text(m)));
            player.sendMessage(Component.text(m));

        } else {
            //TODO 配置文件
            String m = String.format("[%s]%s switched %s from %s",
                    nowServer,
                    player.getUsername(),
                    nowServer,
                    preServer
            );
            server.getAllPlayers().forEach(s -> s.sendMessage(Component.text(m)));
            player.sendMessage(Component.text(m));
        }

    }

    @Subscribe
    public void onPlayerDisconnect(DisconnectEvent event) {
        Player player = event.getPlayer();
        String m = String.format("[ALLSTARS]%s left server",
                player.getUsername()
        );
        server.getAllPlayers().forEach(s -> s.sendMessage(Component.text(m)));
    }

    @Subscribe
    public void onCommandExecute(CommandExecuteEvent event) {
        //logger.info();
        //PermissionControl ppp = new PermissionControl(logger);
        //logger.info(ppp.checkCmdByGroup("admin"));
        if (event.getCommandSource() instanceof ConsoleCommandSource) {
            //Console execute command
        } else if (event.getCommandSource() instanceof Player) {
            String playerServer = ((Player) event.getCommandSource()).getCurrentServer().toString();
            //Player execute command
            Config conf = new Config();
            if (!(conf.loadList("disable-server").contains(playerServer))) {
                //...乱
                PermissionControl pc = new PermissionControl(logger);
                String groupName = (pc.checkGroupByUsername("username"));
                Boolean status = (pc.checkAvaByGroupAndCmd(groupName, new CommandMan().Analyze(event.getCommand())));
                if (!status) {
                    event.setResult(CommandExecuteEvent.CommandResult.denied());
                    MessageMan m = new MessageMan();
                    m.sendPlayerMessage(event.getCommandSource(), (new i18n((new Config()).loadKey("")).loadString("error1")));
                }
            }
        }
    }
}
