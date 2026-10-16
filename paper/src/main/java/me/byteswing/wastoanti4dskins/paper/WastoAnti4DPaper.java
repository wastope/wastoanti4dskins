package me.byteswing.wastoanti4dskins.paper;

import me.byteswing.wastoanti4dskins.common.SkinChecker;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WastoAnti4DPaper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Инициализация WastoAnti4DSkins...");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (SkinChecker.has4dSkin(player.getUniqueId())) {
            player.kick(LegacyComponentSerializer.legacySection().deserialize(SkinChecker.KICK_MESSAGE));
        }
    }
}
