package com.alessiodp.oreannouncer.velocity.commands;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.velocity.commands.utils.VelocityCommandUtils;
import com.alessiodp.oreannouncer.velocity.commands.main.VelocityCommandOA;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.commands.OACommandManager;
import com.alessiodp.oreannouncer.common.configuration.data.ConfigMain;

import java.util.ArrayList;

public class VelocityOACommandManager extends OACommandManager {

	public VelocityOACommandManager(ADPPlugin plugin) {
		super(plugin);
	}

	@Override
	public void prepareCommands() {
		super.prepareCommands();
		commandUtils = new VelocityCommandUtils(plugin, ConfigMain.COMMANDS_MISC_ON, ConfigMain.COMMANDS_MISC_OFF);
	}

	@Override
	public void registerCommands() {
		mainCommands = new ArrayList<>();
		mainCommands.add(new VelocityCommandOA((OreAnnouncerPlugin) plugin));
	}
}
