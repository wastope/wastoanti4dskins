package me.byteswing.wastoanti4dskins.bungee;

import me.byteswing.wastoanti4dskins.common.SkinChecker;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class WastoAnti4DBungee extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Инициализация WastoAnti4DSkins...");
        getProxy().getPluginManager().registerListener(this, this);
    }

    @EventHandler
    public void onJoin(PostLoginEvent e) {
        ProxiedPlayer player = e.getPlayer();

        if (SkinChecker.has4dSkin(player.getUniqueId())) {
            player.disconnect(TextComponent.fromLegacy(SkinChecker.KICK_MESSAGE));
        }
    }
}
