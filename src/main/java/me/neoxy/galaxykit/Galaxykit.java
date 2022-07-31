package me.neoxy.galaxykit;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.command.CommandExecuteEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;
import me.neoxy.galaxykit.MessageMan;

@Plugin(
        id = "galaxykit",
        name = "GalaxyKit",
        version = "1.0-SNAPSHOT",
        description = "Plugin for ALLSTARS S3",
        authors = {"Neoxy"}
)
public class Galaxykit {
    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public Galaxykit(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("GalaxyKit has been initialized。");
        //server.getEventManager().register(this,new );
    }

    @Subscribe
    public void onCommandExecute(CommandExecuteEvent event) {
        //logger.info(event.getCommand().toString());
        event.setResult(CommandExecuteEvent.CommandResult.denied());
        MessageMan m = new MessageMan();
        m.sendPlayerMessage(event.getCommandSource(),"Your command has been denied, becaused you don not have the permission to do that.");
    }
}
