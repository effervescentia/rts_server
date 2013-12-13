package server_battle;

import java.util.ArrayList;
import java.util.List;

public class Order_Time_Matrix {
	private final OrderQueue orderQueue;
	private final Map map;
	private final units.GameUnits gameDatabase;
	private final OrderService orderService;
	protected List<Order_Lists> order_Lists;
	
	public Order_Time_Matrix(int poolsize, Map Map, units.GameUnits GameDatabase){
		orderQueue = new OrderQueue();
		orderService = new OrderService(orderQueue,poolsize);
		order_Lists = new ArrayList<Order_Lists>();
		map = Map;
		gameDatabase = GameDatabase;
		orderService.run();
	}
	private Order_Lists FindByName(String order_Listname){
		for(Order_Lists x: order_Lists){
			if(x.getName() == order_Listname){
				return x;
			}
		}
		return order_Lists.get(0);
	}
	public Long AddOrder(Order newOrder, String order_Listname){
		FindByName(order_Listname).add(newOrder);
		newOrder.setSubscritables(orderQueue,map,gameDatabase);
		return newOrder.activate();
	}
	public void RemoveOrder(Order order, String order_Listname){
		FindByName(order_Listname).remove(order);
		orderQueue.remove(order);
		/*remove all its geo/general subscriptions*/
	}
	public void RegisterOrder_Type(Order_Lists newOrder_Lists){
		order_Lists.add(newOrder_Lists);
	}
	public Integer queuePeek(){
		return orderQueue.numEnqueued();
	}
}
