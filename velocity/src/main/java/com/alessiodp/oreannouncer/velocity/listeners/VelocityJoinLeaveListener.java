package com.alessiodp.oreannouncer.velocity.listeners;

import com.alessiodp.core.velocity.user.VelocityUser;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.listeners.JoinLeaveListener;
import com.velocitypowered.api.event.PostOrder;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.connection.PostLoginEvent;

public class VelocityJoinLeaveListener extends JoinLeaveListener {

	public VelocityJoinLeaveListener(OreAnnouncerPlugin plugin) {
		super(plugin);
	}

	@Subscribe(order = PostOrder.LATE)
	public void onPlayerJoin(PostLoginEvent event) {
		super.onPlayerJoin(new VelocityUser(plugin, event.getPlayer()));
	}

	@Subscribe
	public void onPlayerQuit(DisconnectEvent event) {
		super.onPlayerQuit(new VelocityUser(plugin, event.getPlayer()));
	}
}
