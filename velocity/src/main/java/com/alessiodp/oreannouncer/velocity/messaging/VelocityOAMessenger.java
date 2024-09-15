package com.alessiodp.oreannouncer.velocity.messaging;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.common.messaging.ADPMessenger;

public class VelocityOAMessenger extends ADPMessenger {
	public VelocityOAMessenger(ADPPlugin plugin) {
		super(plugin);
		messageDispatcher = new VelocityOAMessageDispatcher(plugin);
		messageListener = new VelocityOAMessageListener(plugin);
	}

	@Override
	public void reload() {
		messageDispatcher.register();
		messageListener.register();
	}
}
