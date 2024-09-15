package com.alessiodp.oreannouncer.velocity;

import com.alessiodp.core.common.bootstrap.ADPBootstrap;
import com.alessiodp.core.common.configuration.Constants;
import com.alessiodp.core.velocity.addons.internal.VelocityJsonHandler;
import com.alessiodp.core.velocity.scheduling.ADPVelocityScheduler;
import com.alessiodp.oreannouncer.velocity.addons.VelocityOAAddonManager;
import com.alessiodp.oreannouncer.velocity.addons.external.VelocityMetricsHandler;
import com.alessiodp.oreannouncer.velocity.blocks.VelocityBlockManager;
import com.alessiodp.oreannouncer.velocity.bootstrap.VelocityOreAnnouncerBootstrap;
import com.alessiodp.oreannouncer.velocity.commands.VelocityOACommandManager;
import com.alessiodp.oreannouncer.velocity.configuration.VelocityOAConfigurationManager;
import com.alessiodp.oreannouncer.velocity.events.VelocityEventManager;
import com.alessiodp.oreannouncer.velocity.listeners.VelocityJoinLeaveListener;
import com.alessiodp.oreannouncer.velocity.messaging.VelocityOAMessenger;
import com.alessiodp.oreannouncer.velocity.players.VelocityPlayerManager;
import com.alessiodp.oreannouncer.velocity.utils.VelocityMessageUtils;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import lombok.Getter;

public class VelocityOreAnnouncerPlugin extends OreAnnouncerPlugin {

	@Getter private final int bstatsId = -1;

	public VelocityOreAnnouncerPlugin(ADPBootstrap bootstrap) {
		super(bootstrap);
	}

	@Override
	protected void initializeCore() {
		scheduler = new ADPVelocityScheduler(this);
		configurationManager = new VelocityOAConfigurationManager(this);
		messageUtils = new VelocityMessageUtils(this);
		messenger = new VelocityOAMessenger(this);

		super.initializeCore();
	}

	@Override
	protected void loadCore() {
		blockManager = new VelocityBlockManager(this);
		playerManager = new VelocityPlayerManager(this);
		commandManager = new VelocityOACommandManager(this);

		super.loadCore();
	}

	@Override
	protected void postHandle() {
		addonManager = new VelocityOAAddonManager(this);
		eventManager = new VelocityEventManager(this);

		super.postHandle();

		new VelocityMetricsHandler(this);
	}

	@Override
	protected void initializeJsonHandler() {
		jsonHandler = new VelocityJsonHandler(this);
	}

	@Override
	protected void registerListeners() {
		getLoggerManager().logDebug(Constants.DEBUG_PLUGIN_REGISTERING, true);
		VelocityOreAnnouncerBootstrap plugin = (VelocityOreAnnouncerBootstrap) getBootstrap();

		plugin.registerListener(new VelocityJoinLeaveListener(this));
	}

	@Override
	public boolean isBungeeCordEnabled() {
		return false;
	}

	@Override
	public String getServerName() {
		return "";
	}

	@Override
	public String getServerId() {
		return "";
	}
}

