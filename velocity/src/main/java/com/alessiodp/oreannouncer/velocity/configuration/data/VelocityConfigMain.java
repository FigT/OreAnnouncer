package com.alessiodp.oreannouncer.velocity.configuration.data;

import com.alessiodp.core.common.configuration.ConfigOption;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.configuration.OAConstants;
import com.alessiodp.oreannouncer.common.configuration.data.ConfigMain;
import lombok.Getter;

import java.util.List;

public class VelocityConfigMain extends ConfigMain {
	@Getter private final String fileName = "config.yml";
	@Getter private final String resourceName = "velocity/config.yml";
	@Getter private final int latestVersion = OAConstants.VERSION_VELOCITY_CONFIG;

	// Blocks settings
	@ConfigOption(path = "blocks.list-allowed")
	public static List<String> BLOCKS_LISTALLOWED;

	public VelocityConfigMain(OreAnnouncerPlugin plugin) {
		super(plugin);
	}
}
