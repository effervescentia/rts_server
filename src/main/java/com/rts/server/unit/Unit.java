package com.rts.server.unit;

import java.awt.Point;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Unit {
	private static final AtomicInteger uniqueIdCounter = new AtomicInteger();

	// private static final Logger log = Logger.getLogger(Unit.class);

	public final int uniqueId;
	private Point position;

	public Unit() {
		uniqueId = uniqueIdCounter.getAndIncrement();
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point pPosition) {
		position.setLocation(pPosition);
	}
}