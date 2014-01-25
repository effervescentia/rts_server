package unit_management;

import java.awt.Point;
import java.util.*;

import server_battle.Battle;
import units.Unit;

public class GameUnits {
	LinkedHashMap<Integer, Unit> unitList = new LinkedHashMap<Integer, Unit>();
	UnitMap unitLocation = new UnitMap();
	
	public void createUnit(Unit unit, Point position) {
		Battle.Log.logln("UnitStatus","Creating unit: " + unit.getName());
		unit.setPosition(position);
		unitLocation.addUnit(unit.uniqueId, position);
		unitList.put(unit.uniqueId, unit);
		Battle.Log.logln("UnitStatus", "Check: " + unitList.containsKey(unit.uniqueId) + ", stuff: " + unitList.get(unit.uniqueId).getName());
	}
	
	public void removeUnit (int uniqueId) {
		Battle.Log.logln("UnitStatus","Removing unit: " + Integer.toString(uniqueId));
		unitLocation.deleteUnit(uniqueId);
		unitList.remove(uniqueId);
	}
	
	public boolean moveUnit (int uniqueId, Point newPosition) {
		Battle.Log.logln("UnitStatus","Moving unit: " + Integer.toString(uniqueId));
		
		boolean unitMove = unitLocation.moveUnit(uniqueId, unitList.get(uniqueId).getPosition(), newPosition);
		if(unitMove)
		{
			unitList.get(uniqueId).setPosition(newPosition);
			return true;
		}else
			return false;
	}
	
	public ArrayList<Unit> getUnits (Point position) { // gets units at position
		Battle.Log.logln("UnitStatus","Looking up units at position: " + position.toString());
		Set<Integer> uniqueIds = unitLocation.getUnits(position);
		ArrayList<Unit> units = new ArrayList<Unit>(uniqueIds.size());
		for (Integer uniqueId : uniqueIds) {
			units.add(unitList.get(uniqueId));
		}
		return units;
	}
	
	public Unit getUnit (int uniqueId) {
		Battle.Log.logln("UnitStatus","Getting Unit : " + Integer.toString(uniqueId));
		return unitList.get(uniqueId);	
	}
	public void checkUnit (int uniqueId) {
		Battle.Log.logln("UnitStatus","Checking Unit : " + Integer.toString(uniqueId));
		Battle.Log.logln("UnitStatus",Integer.toString(uniqueId) + " is at Position: " + unitList.get(uniqueId).getPosition().toString());	
	}
}
