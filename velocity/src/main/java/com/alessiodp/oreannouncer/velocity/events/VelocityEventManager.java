package com.alessiodp.oreannouncer.velocity.events;

import com.alessiodp.core.velocity.events.VelocityEventDispatcher;
import com.alessiodp.oreannouncer.api.events.common.IAdvancedAlertEvent;
import com.alessiodp.oreannouncer.api.events.common.IAlertEvent;
import com.alessiodp.oreannouncer.api.events.common.IBlockDestroyEvent;
import com.alessiodp.oreannouncer.api.events.velocity.common.VelocityOreAnnouncerAdvancedAlertEvent;
import com.alessiodp.oreannouncer.api.events.velocity.common.VelocityOreAnnouncerAlertEvent;
import com.alessiodp.oreannouncer.api.events.velocity.common.VelocityOreAnnouncerBlockDestroyEvent;
import com.alessiodp.oreannouncer.api.interfaces.BlockLocation;
import com.alessiodp.oreannouncer.api.interfaces.OABlock;
import com.alessiodp.oreannouncer.api.interfaces.OAPlayer;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import com.alessiodp.oreannouncer.common.events.EventManager;
import lombok.NonNull;

public class VelocityEventManager extends EventManager {
	public VelocityEventManager(@NonNull OreAnnouncerPlugin plugin) {
		super(plugin, new VelocityEventDispatcher(plugin));
	}

	@Override
	public IAlertEvent prepareAlertEvent(OAPlayer player, OABlock block, int number, BlockLocation location, int lightLevel, int heightLevel) {
		return new VelocityOreAnnouncerAlertEvent(player, block, number, location, lightLevel, heightLevel);
	}

	@Override
	public IAdvancedAlertEvent prepareAdvancedEvent(OAPlayer player, OABlock block, int total, long elapsedTime, BlockLocation location, int lightLevel, int heightLevel) {
		return new VelocityOreAnnouncerAdvancedAlertEvent(player, block, total, elapsedTime, location, lightLevel, heightLevel);
	}

	@Override
	public IBlockDestroyEvent prepareBlockDestroyEvent(OAPlayer player, OABlock block, BlockLocation blockLocation) {
		return new VelocityOreAnnouncerBlockDestroyEvent(player, block, blockLocation);
	}
}
