package me.byteswing.wastoanti4dskins.geyser;

import me.byteswing.wastoanti4dskins.common.SkinChecker;
import org.geysermc.event.subscribe.Subscribe;
import org.geysermc.geyser.api.event.bedrock.SessionLoginEvent;
import org.geysermc.geyser.api.event.lifecycle.GeyserPostInitializeEvent;
import org.geysermc.geyser.api.extension.Extension;

public class WastoAnti4DExtension implements Extension {

    @Subscribe
    public void onPostInitialize(GeyserPostInitializeEvent event) {
        logger().info("Инициализация WastoAnti4DSkins...");
    }

    @Subscribe
    public void onLogin(SessionLoginEvent event) {
        if (SkinChecker.has4dSkin(event.connection())) {
            event.setCancelled(true, SkinChecker.KICK_MESSAGE);
        }
    }
}
