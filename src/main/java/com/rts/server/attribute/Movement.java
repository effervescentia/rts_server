package com.rts.server.attribute;

public class Movement extends Attribute {

	private int speed;

	// Also include a list of acceptable modifications from buffs/debuffs

	public Movement(int pSpeed) {
		type = AttributeType.Movement;
		speed = pSpeed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int pSpeed) {
		speed = pSpeed;
	}

}
