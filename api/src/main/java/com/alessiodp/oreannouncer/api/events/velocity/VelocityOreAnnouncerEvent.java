package com.alessiodp.oreannouncer.api.events.velocity;

import com.alessiodp.oreannouncer.api.events.OreAnnouncerEvent;
import com.alessiodp.oreannouncer.api.interfaces.OreAnnouncerAPI;
import org.jetbrains.annotations.NotNull;

public abstract class VelocityOreAnnouncerEvent implements OreAnnouncerEvent {
	private OreAnnouncerAPI api;

	@Override
	@NotNull
	public OreAnnouncerAPI getApi() {
		return api;
	}

	@Override
	public void setApi(OreAnnouncerAPI instance) {
		api = instance;
	}
}
