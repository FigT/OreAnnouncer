package com.alessiodp.oreannouncer.velocity.messaging.bungee;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.velocity.messaging.bungee.VelocityBungeecordDispatcher;
import org.jetbrains.annotations.NotNull;

public class VelocityOABungeecordDispatcher extends VelocityBungeecordDispatcher {
	public VelocityOABungeecordDispatcher(@NotNull ADPPlugin plugin) {
		super(plugin, false, true, false);
	}
}
