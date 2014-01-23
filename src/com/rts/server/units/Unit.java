package com.rts.server.units;

import java.awt.Point;
import java.util.concurrent.atomic.AtomicInteger;

import com.rts.server.units.Unit;

public abstract class Unit {
	private static final AtomicInteger uniqueIdCounter = new AtomicInteger();
	
	public final int uniqueId, buildTime;
	protected long updateOrder;
	private final String name;
	
	private Point position;
	protected final int movementSpeed;
	protected int movementSpeedMod;
	
	public Unit (String name, int buildTime, int movementSpeed)	{
		uniqueId = uniqueIdCounter.getAndIncrement();
		this.movementSpeed = movementSpeed;
		this.position = new Point();
		this.buildTime = buildTime;
		this.name = name;
	}
	
	public Point getPosition () {
		return position;
	}

	public void setPosition (Point newPosition) {
		position.setLocation(newPosition);
	}
	
	public void update(){isupdaterequired();}
	public boolean isupdaterequired(){return false;}
	
	public String getName() {
		return name;
	}
	public int getbuildTime() {
		return buildTime;
	}
	public int getmovespeed(){
		return movementSpeed + movementSpeedMod;
	}
	public int getbasemovespeed(){
		return movementSpeed;
	}
	public void addmovespeed(int modifier){
		movementSpeedMod += modifier;
	}
	public void resetmovespeed(){
		movementSpeedMod = 0;
	}
	public String toString() {
		return this.getName();
		
	}
}