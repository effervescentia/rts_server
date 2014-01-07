package unit_management;

import java.awt.Point;
import java.util.*;

import com.google.common.collect.HashMultimap;

// Grid/Database that maps location to unique id
public class UnitMap {
	HashMultimap<Point, Integer> unitMap; //TODO make threadsafe
	
	UnitMap () {
		unitMap = HashMultimap.create();
	}
	
	UnitMap (int x, int y) {
		unitMap = HashMultimap.create(x*y, 10);
	}
	
	public void addUnit (final int uniqueId, Point position) {
		unitMap.put(position, uniqueId);
	}
	
	public void moveUnit (final int uniqueId, Point oldPosition, Point newPosition) {
		unitMap.remove(oldPosition, uniqueId);
		unitMap.put(newPosition, uniqueId);
	}
	
	public Set<Integer> getUnits (final Point position) {
		Set<Integer> unitIds = unitMap.get(position);
		return unitIds;
	}
	
	
	public void deleteUnit (final int uniqueId) {
	}
}
