package server_battle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Order implements Runnable {
private long Order_ID;
private final long firsttime;
private static AtomicLong Unique_Subscription_ID = new AtomicLong();
protected List<Subscription> subscription = new ArrayList<Subscription>();


public Order(long Time){
	firsttime = Time;
}
public long getfirsttime(){
	return firsttime;
}
public long getOrder_ID(){
	return Order_ID;
}
public void setOrder_ID(long order_ID){
	Order_ID = order_ID;
}
public void run() {}
public long addSubscription(Subscription subscript){
	long x;
	x = subscript.setUnique_ID(Unique_Subscription_ID.getAndIncrement());
	subscription.add(subscript);
	subscript.activate();
	return x;
}
public void removeSubscription(long sub_id){
	
}
}