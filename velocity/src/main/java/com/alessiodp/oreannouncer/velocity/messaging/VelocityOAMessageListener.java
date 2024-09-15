package com.alessiodp.oreannouncer.velocity.messaging;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.velocity.messaging.VelocityMessageListener;
import com.alessiodp.oreannouncer.velocity.messaging.bungee.VelocityOABungeecordListener;
import org.jetbrains.annotations.NotNull;

public class VelocityOAMessageListener extends VelocityMessageListener {

	public VelocityOAMessageListener(@NotNull ADPPlugin plugin) {
		super(
				plugin,
				new VelocityOABungeecordListener(plugin),
				null
		);
	}
}
