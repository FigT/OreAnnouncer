package com.alessiodp.oreannouncer.velocity.bootstrap;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.velocity.addons.external.bstats.velocity.Metrics;
import com.alessiodp.core.velocity.bootstrap.ADPVelocityBootstrap;
import com.alessiodp.oreannouncer.velocity.VelocityOreAnnouncerPlugin;
import com.google.inject.Inject;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.nio.file.Path;

public class VelocityOreAnnouncerBootstrap extends ADPVelocityBootstrap {

	@Inject
	public VelocityOreAnnouncerBootstrap(ProxyServer server, Logger logger, @DataDirectory Path dataDirectory, Metrics.Factory metricsFactory) {
		super(server, logger, dataDirectory, metricsFactory);
	}

	@Override
	protected ADPPlugin initializePlugin() {
		return new VelocityOreAnnouncerPlugin(this);
	}

	@Override
	public @NotNull String getAuthor() {
		return "AlessioDP";
	}

	@Override
	public @NotNull String getVersion() {
		return "2.8.5";
	}
}
