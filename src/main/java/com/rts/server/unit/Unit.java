package com.rts.server.unit;

import java.awt.Point;
import java.util.concurrent.atomic.AtomicInteger;

import com.rts.server.unit.stat.Stat;

public abstract class Unit {
	private static final AtomicInteger uniqueIdCounter = new AtomicInteger();

	public enum UnitType {
		Marine
	}

	public final int uniqueId;
	public final int buildTime;
	protected long updateOrder;
	protected Stat movementSpeed;
	private final UnitType unitType;

	private Point position;

	public Unit(UnitType pUnitType, int pBuildTime, int pMoveSpeed) {
		uniqueId = uniqueIdCounter.getAndIncrement();
		buildTime = pBuildTime;
		unitType = pUnitType;
		movementSpeed = new Stat(pMoveSpeed);
		position = new Point();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point pPosition) {
		position.setLocation(pPosition);
	}

	public void update() {
		isUpdateRequired();
	}

	public boolean isUpdateRequired() {
		return false;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public int getBuildTime() {
		return buildTime;
	}

	public String toString() {
		return unitType.toString();

	}

	public int getMoveSpeed() {
		return movementSpeed.getModified();
	}

	public int getBaseMoveSpeed() {
		return movementSpeed.getBase();
	}

	public void addMoveSpeed(int pModifier) {
		movementSpeed.addModifier(pModifier);
	}

	public void resetMoveSpeed() {
		movementSpeed.resetModifier();
	}
}