package com.alessiodp.oreannouncer.velocity.configuration;

import com.alessiodp.oreannouncer.velocity.configuration.data.VelocityConfigMain;
import com.alessiodp.oreannouncer.velocity.configuration.data.VelocityMessages;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.configuration.OAConfigurationManager;

public class VelocityOAConfigurationManager extends OAConfigurationManager {

	public VelocityOAConfigurationManager(OreAnnouncerPlugin plugin) {
		super(plugin);

		getConfigs().add(new VelocityConfigMain(plugin));
		getConfigs().add(new VelocityMessages(plugin));
	}
}
