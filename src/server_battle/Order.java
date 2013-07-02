package server_battle;

import java.util.concurrent.atomic.AtomicLong;

public abstract class Order implements Runnable {
private long Order_ID;
protected OrderQueue order_Queue;
protected Map map;
protected units.GameUnits gameDatabase;
private static AtomicLong Unique_Subscription_ID = new AtomicLong();
//protected List<Subscription> subscription = new ArrayList<Subscription>();


public Order(){
	order_Queue = null;
}

public long getOrder_ID(){
	return Order_ID;
}
public void setOrder_ID(long order_ID){
	Order_ID = order_ID;
}
public void setSubscritables(OrderQueue orderQueue, Map Map,units. GameUnits GameDatabase){
	map = Map;
	gameDatabase = GameDatabase;
	order_Queue = orderQueue;
}
public void run() {}
protected void activation(){}
public Long activate(){
	activation();
	Order_ID = Unique_Subscription_ID.getAndIncrement();
	return Order_ID;
}

//public void addSubscription(){}
//public void removeSubscription(long sub_id){}
}