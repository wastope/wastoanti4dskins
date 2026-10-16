package me.byteswing.wastoanti4dskins.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.Player;
import me.byteswing.wastoanti4dskins.common.BuildConstants;
import me.byteswing.wastoanti4dskins.common.SkinChecker;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.slf4j.Logger;

@Plugin(
        id = "wastoanti4dskins",
        name = "WastoAnti4DSkins",
        version = BuildConstants.VERSION,
        authors = {"byteswing"},
        dependencies = {@Dependency(id = "geyser")}
)
public class WastoAnti4D {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        logger.info("Инициализация WastoAnti4DSkins...");
    }

    @Subscribe
    public void onJoin(PostLoginEvent e) {
        Player player = e.getPlayer();

        if (SkinChecker.has4dSkin(player.getUniqueId())) {
            player.disconnect(LegacyComponentSerializer.legacySection().deserialize(SkinChecker.KICK_MESSAGE));
        }
    }
}
