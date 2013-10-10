package units;

import java.util.LinkedHashMap;

import server_battle.Position;

public class GameUnits {
	LinkedHashMap<Integer, Unit> unitList = new LinkedHashMap<Integer, Unit>();
	UnitLocation unitLocation = new UnitLocation();
	
	public void CreateUnit(Unit unit, Position position) {
		// should probably have mutex but #yolo
		unitList.put(unit.uniqueId, unit);
		unitLocation.AddUnit(unit.uniqueId, position);
	}
	
	public void RemoveUnit (int uniqueId) {
		// should probably have mutex but #yolo
		unitList.remove(uniqueId);
		unitLocation.DeleteUnit(uniqueId);
	}
	
	public void MoveUnit (int uniqueId, Position newPosition) {
		unitLocation.MoveUnit(uniqueId, newPosition);
		//set unit location in unit class 
		//unitList.get(unit.uniqueId).set(newPosition);
	}
	
	public Unit GetUnit (Position newPosition) { // gets unit closest to position
		
		return null;
		
	}
	
	public Unit GetUnit (int uniqueId) {
		return unitList.get(uniqueId);
		
	}
}
