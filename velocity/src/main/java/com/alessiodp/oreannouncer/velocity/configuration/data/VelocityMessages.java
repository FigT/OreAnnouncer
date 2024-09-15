package com.alessiodp.oreannouncer.velocity.configuration.data;

import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.configuration.OAConstants;
import com.alessiodp.oreannouncer.common.configuration.data.Messages;
import lombok.Getter;

public class VelocityMessages extends Messages {
	@Getter private final String fileName = "messages.yml";
	@Getter private final String resourceName = "velocity/messages.yml";
	@Getter private final int latestVersion = OAConstants.VERSION_VELOCITY_MESSAGES;


	public VelocityMessages(OreAnnouncerPlugin plugin) {
		super(plugin);
	}
}