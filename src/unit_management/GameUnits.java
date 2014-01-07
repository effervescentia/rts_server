package unit_management;

import java.awt.Point;
import java.util.*;

import server_battle.Battle;
import units.Unit;

public class GameUnits {
	LinkedHashMap<Integer, Unit> unitList = new LinkedHashMap<Integer, Unit>();
	UnitMap unitLocation = new UnitMap();
	
	public void CreateUnit(Unit unit, Point position) {
		Battle.Log.logln("UnitStatus","Creating unit: " + unit.getName());
		unitList.put(unit.uniqueId, unit);
		unitLocation.addUnit(unit.uniqueId, position);
		Battle.Log.logln("UnitStatus", "Check: " + unitList.containsKey(unit.uniqueId) + ", stuff: " + unitList.get(unit.uniqueId).getName());
	}
	
	public void RemoveUnit (int uniqueId) {
		Battle.Log.logln("UnitStatus","Removing unit: " + Integer.toString(uniqueId));
		unitList.remove(uniqueId);
		unitLocation.deleteUnit(uniqueId);
	}
	
	public void MoveUnit (int uniqueId, Point newPosition) {
		Battle.Log.logln("UnitStatus","Moving unit: " + Integer.toString(uniqueId));
		unitLocation.moveUnit(uniqueId, unitList.get(uniqueId).getPosition(), newPosition);
		//set unit location in unit class 
		//unitList.get(unit.uniqueId).set(newPosition);
	}
	
	public ArrayList<Unit> GetUnits (Point position) { // gets units at position
		Battle.Log.logln("UnitStatus","Looking up units at position: " + position.toString());
		Set<Integer> uniqueIds = unitLocation.getUnits(position);
		ArrayList<Unit> units = new ArrayList<Unit>(uniqueIds.size());
		for (Integer uniqueId : uniqueIds) {
			units.add(unitList.get(uniqueId));
		}
		return units;
	}
	
	public Unit GetUnit (int uniqueId) {
		Battle.Log.logln("UnitStatus","Moving unit: " + Integer.toString(uniqueId));
		return unitList.get(uniqueId);	
	}
}
