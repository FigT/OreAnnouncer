package com.alessiodp.oreannouncer.velocity.players;

import com.alessiodp.oreannouncer.velocity.players.objects.VelocityOAPlayerImpl;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.players.PlayerManager;
import com.alessiodp.oreannouncer.common.players.objects.OAPlayerImpl;

import java.util.UUID;

public class VelocityPlayerManager extends PlayerManager {

	public VelocityPlayerManager(OreAnnouncerPlugin plugin) {
		super(plugin);
	}

	@Override
	public OAPlayerImpl initializePlayer(UUID playerUUID) {
		return new VelocityOAPlayerImpl(plugin, playerUUID);
	}
}
