package unit_management;

import java.awt.Point;
import java.util.LinkedHashMap;
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
		unitLocation.moveUnit(uniqueId, newPosition);
		//set unit location in unit class 
		//unitList.get(unit.uniqueId).set(newPosition);
	}
	
	public Unit GetUnit (Point newPosition) { // gets unit closest to position
		Battle.Log.logln("UnitStatus","Looking up unit at position: " + newPosition.toString());
		return null;
	}
	
	public Unit GetUnit (int uniqueId) {
		Battle.Log.logln("UnitStatus","Moving unit: " + Integer.toString(uniqueId));
		return unitList.get(uniqueId);
		
	}
}
