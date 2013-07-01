package units;

import java.util.concurrent.atomic.AtomicInteger;

import units.Unit;

public abstract class Unit {
	private static final AtomicInteger uniqueIdCounter = new AtomicInteger();
	
	// unique id
	public final int uniqueId, buildTime;
	//protected final ToDoQueue toDoQueue;
	protected long updateOrder;
	private final String name;
	
	public Unit (/*ToDoQueue toDoQueue,*/ String name, int buildTime)	{
		uniqueId = uniqueIdCounter.getAndIncrement();
//		this.toDoQueue = toDoQueue;
		this.buildTime = buildTime;
		this.name = name;
	}
	
	public void update(){isupdaterequired();}
	public boolean isupdaterequired(){return false;}
	
	public String getName() {
		return name;
	}
	public int getbuildTime() {
		return buildTime;
	}
}