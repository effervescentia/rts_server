package com.rts.server.orders;

import java.awt.Point;
import java.util.ArrayList;

import com.rts.server.unit.Unit;

/**
 * 
 * Order that relates to unit movement
 * 
 */
public class MovementOrder extends Order {
	private Unit unit;
	private ArrayList<Point> remainingMovement;
	private Point moveGoal;
	private Point currentMovement;
	private double currentTickTime;

	public MovementOrder(int pUid, Point pMoveGoal/* ,Player player */) {
		unit = gameDatabase.getUnit(pUid);
		moveGoal = pMoveGoal;
	}

	public void activation() {
		// pathme
		// remainingMovement = pathme(moveGoal);
		currentMovement = remainingMovement.get(0);
		remainingMovement.remove(0);
		if (unit.getPosition().x != currentMovement.x
				&& unit.getPosition().y != currentMovement.y)
			currentTickTime = Math.sqrt(2) * unit.getBaseMoveSpeed();
		else
			currentTickTime = unit.getBaseMoveSpeed();

		currentTickTime *= 1000;
		orderQueue.add(this, (int) currentTickTime);
	}

	@Override
	public void run() {
		boolean lastMove = gameDatabase
				.moveUnit(unit.uniqueId, currentMovement);
		if (lastMove) {
			currentMovement = remainingMovement.get(0);
			remainingMovement.remove(0);
			if (unit.getPosition().x != currentMovement.x
					&& unit.getPosition().y != currentMovement.y)
				currentTickTime = Math.sqrt(2) * unit.getBaseMoveSpeed();
			else
				currentTickTime = unit.getBaseMoveSpeed();

			currentTickTime *= 1000;
			orderQueue.add(this, (int) currentTickTime);
		} else {
			// repathme
			// remainingMovement = pathme(moveGoal);
			// run();
		}
	}
}
