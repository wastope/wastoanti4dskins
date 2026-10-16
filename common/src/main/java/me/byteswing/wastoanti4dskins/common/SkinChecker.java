package me.byteswing.wastoanti4dskins.common;

import org.geysermc.geyser.api.GeyserApi;
import org.geysermc.geyser.api.connection.GeyserConnection;
import org.geysermc.geyser.session.GeyserSession;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public final class SkinChecker {

    public static final String KICK_MESSAGE = "§c§lНедопустимый скин";

    private SkinChecker() {
    }

    public static boolean has4dSkin(UUID uuid) {
        GeyserApi api = GeyserApi.api();
        return has4dSkin(api.connectionByUuid(uuid));
    }

    public static boolean has4dSkin(GeyserConnection connection) {
        if (!(connection instanceof GeyserSession session)) return false;
        if (session.getClientData() == null) return false;
        byte[] geometryName = session.getClientData().getGeometryName();
        if (geometryName == null) return false;
        return is4dGeometry(new String(geometryName, StandardCharsets.UTF_8));
    }

    public static boolean is4dGeometry(String geometry) {
        if (geometry == null || geometry.isEmpty()) return false;

        return !(geometry.contains("geometry.humanoid.customSlim") ||
                geometry.contains("geometry.humanoid.custom") ||
                geometry.contains("geometry.persona_"));
    }
}
