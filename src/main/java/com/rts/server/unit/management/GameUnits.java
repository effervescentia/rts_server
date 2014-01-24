package com.rts.server.unit.management;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rts.server.unit.Unit;

public class GameUnits {
	private static final Logger log = Logger.getLogger(GameUnits.class);
	LinkedHashMap<Integer, Unit> unitList = new LinkedHashMap<Integer, Unit>();
	UnitMap unitLocation = new UnitMap();

	public void createUnit(Unit unit, Point position) {
		log.info("Creating unit: " + unit);
		unitLocation.addUnit(unit.uniqueId, position);
		unitList.put(unit.uniqueId, unit);
		log.info("Check: " + unitList.containsKey(unit.uniqueId) + ", stuff: "
				+ unitList.get(unit.uniqueId));
	}

	public void removeUnit(int uniqueId) {
		log.info("Removing unit: " + Integer.toString(uniqueId));
		unitLocation.deleteUnit(uniqueId);
		unitList.remove(uniqueId);
	}

	public boolean moveUnit(int uniqueId, Point newPosition) {
		log.info("Moving unit: " + Integer.toString(uniqueId));

		boolean moved = unitLocation.moveUnit(uniqueId, unitList.get(uniqueId)
				.getPosition(), newPosition);

		if (moved) {
			unitList.get(uniqueId).setPosition(newPosition);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param position
	 * @return list of units at the specified position
	 */
	public List<Unit> getUnits(Point position) {
		log.info("Looking for units at position: " + position.toString());
		Set<Integer> uniqueIds = unitLocation.getUnits(position);
		ArrayList<Unit> units = new ArrayList<Unit>(uniqueIds.size());
		for (Integer uniqueId : uniqueIds) {
			units.add(unitList.get(uniqueId));
		}
		return units;
	}

	public Unit getUnit(int uniqueId) {
		log.info("Getting unit: " + Integer.toString(uniqueId));
		return unitList.get(uniqueId);
	}

	public void checkUnit(int uniqueId) {
		log.info("Checking unit: " + Integer.toString(uniqueId));
		log.info(Integer.toString(uniqueId) + " is at postion "
				+ unitList.get(uniqueId).getPosition().toString());
	}
}
