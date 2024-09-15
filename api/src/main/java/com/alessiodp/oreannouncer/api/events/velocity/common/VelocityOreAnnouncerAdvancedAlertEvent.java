package com.alessiodp.oreannouncer.api.events.velocity.common;

import com.alessiodp.oreannouncer.api.events.common.IAdvancedAlertEvent;
import com.alessiodp.oreannouncer.api.events.velocity.VelocityOreAnnouncerEvent;
import com.alessiodp.oreannouncer.api.interfaces.BlockLocation;
import com.alessiodp.oreannouncer.api.interfaces.OABlock;
import com.alessiodp.oreannouncer.api.interfaces.OAPlayer;
import org.jetbrains.annotations.NotNull;

public class VelocityOreAnnouncerAdvancedAlertEvent extends VelocityOreAnnouncerEvent implements IAdvancedAlertEvent {
	private final OAPlayer player;
	private final OABlock block;
	private final int total;
	private final long elapsedTime;
	private final BlockLocation location;
	private final int lightLevel;
	private final int heightLevel;

	public VelocityOreAnnouncerAdvancedAlertEvent(OAPlayer player, OABlock block, int total, long elapsedTime, BlockLocation location, int lightLevel, int heightLevel) {
		this.player = player;
		this.block = block;
		this.total = total;
		this.elapsedTime = elapsedTime;
		this.location = location;
		this.lightLevel = lightLevel;
		this.heightLevel = heightLevel;
	}

	@NotNull
	@Override
	public OAPlayer getPlayer() {
		return player;
	}

	@NotNull
	@Override
	public OABlock getBlock() {
		return block;
	}

	@Override
	public int getTotalBlocks() {
		return total;
	}

	@Override
	public long getElapsedTime() {
		return elapsedTime;
	}

	@Override
	public BlockLocation getLocation() {
		return location;
	}

	@Override
	public int getLightLevel() {
		return lightLevel;
	}

	@Override
	public int getHeightLevel() {
		return heightLevel;
	}
}
