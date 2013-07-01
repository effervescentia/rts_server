package server_battle;

import units.Unit;

public class UpdateOrder extends Order{
private final Unit unit;

public UpdateOrder(Unit Unit, long time){
	super(time);
	this.unit = Unit;
}

public void run(){
	unit.update();
	if(unit.isupdaterequired()){
		addupdatetime();
		setupdatetime(true);
	}
}
}
