package server_battle;


import units.Unit;

public class UnitCreationOrder extends Order {
	private static final long TICK_TIME = 1000;
	
	private final OrderQueue queue;
	private Unit Unit;
	private Position Position;
	
	private long remainingBuildTime;
	
	public UnitCreationOrder(Unit unit, Position position/*,Player player*/, OrderQueue queue){
		super(unit.getbuildTime() > 1 ? 1 : unit.getbuildTime());
		
		this.queue = queue;
		this.Unit = unit;
		this.Position = position;
		
		this.remainingBuildTime = unit.getbuildTime();
		
		queue.add(this, TICK_TIME);
	}
	
	@Override
	public void run() {
		remainingBuildTime -= TICK_TIME;
		
		if(remainingBuildTime >= TICK_TIME) {
			queue.add(this, TICK_TIME);
		} else if (remainingBuildTime > 0) {
			queue.add(this, remainingBuildTime);
		} else {
			//create the unit here, getgameQueue().Database.addUnit(Unit,Position/*,possibleBuildArea*/);
		}
	}	
}
