package units;

import java.util.LinkedHashMap;

import server_battle.Position;

public class GameUnits {
	LinkedHashMap<Integer, Unit> unitList = new LinkedHashMap<Integer, Unit>();
	UnitLocation unitLocation = new UnitLocation();
	
	public void CreateUnit(Unit unit, Position position) {
		// should probably have mutex
		unitList.put(unit.uniqueId, unit);
		unitLocation.AddUnit(unit.uniqueId, position);
	}
	
	public void RemoveUnit (Unit unit, Position position) {
		// should probably have mutex
		unitList.put(unit.uniqueId, unit);
		unitLocation.AddUnit(unit.uniqueId, position);
	}
}
