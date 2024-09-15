package com.alessiodp.oreannouncer.velocity.addons.external;

import com.alessiodp.core.common.ADPPlugin;
import com.alessiodp.core.common.addons.external.MetricsHandler;
import lombok.NonNull;

public class VelocityMetricsHandler extends MetricsHandler {
	public VelocityMetricsHandler(@NonNull ADPPlugin plugin) {
		super(plugin);
	}

	@Override
	protected void registerMetrics() {
		// no-op, no metrics
		plugin.getLogger().warn("Metrics are not supported on Velocity");
	}
}
