package server_battle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Order_Lists {
protected static AtomicLong Unique_Order_ID = new AtomicLong();
protected List<Order> Outstanding_Orders = new ArrayList<Order>();
protected final Order_Time_Matrix orders;
protected final String name;


public Order_Lists(Order_Time_Matrix orders, String name){
	this.orders = orders;
	this.name = name;
	orders.RegisterOrder_Type(this);
}

public String getName(){
	return name;
}
protected Order_Time_Matrix getOrder_Time_Matrix(){
	return orders;
}

public long add(Order order){
	order.setOrder_ID(GetandIncrement());
	Outstanding_Orders.add(order);
	return order.getOrder_ID();
}

public void updategeo(long order_ID/*,geodata*/){
	for(Order x:Outstanding_Orders){
		if(x.getOrder_ID() == order_ID)
			x.updategeo();
	}
}
public void updatesub(long order_ID/*,subdata*/){
	for(Order x:Outstanding_Orders){
		if(x.getOrder_ID() == order_ID)
			x.updatesub();
	}
}

public Order remove(long order_ID){
	int index = 0;
	for(Order order : Outstanding_Orders){
		if(order.getOrder_ID() == order_ID)
			return Outstanding_Orders.remove(index);
		else
			index++;
	}
	return null;
}

protected synchronized long GetandIncrement(){
	return Unique_Order_ID.getAndIncrement();
}
}
