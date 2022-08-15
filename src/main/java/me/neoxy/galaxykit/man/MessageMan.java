package me.neoxy.galaxykit.man;

import com.velocitypowered.api.command.CommandSource;
import net.kyori.adventure.text.Component;

public class MessageMan {
    public void sendPlayerMessage(CommandSource player, String content) {
        player.sendMessage(Component.text(content));
    }

    public void playerJoin() {

    }

}
