package server_battle;

import java.util.ArrayList;
import java.util.List;

public class Order_Time_Matrix {
	private final OrderQueue orderQueue;
	private final OrderService orderService;
	protected List<Order_Lists> order_Lists;
	
	public Order_Time_Matrix(int poolsize){
		orderQueue = new OrderQueue();
		orderService = new OrderService(orderQueue,poolsize);
		order_Lists = new ArrayList<Order_Lists>();
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
	public void AddOrder(Order newOrder, String order_Listname){
		FindByName(order_Listname).add(newOrder);
		/*subscription stuff*/
	}
	public void RemoveOrder(long order_id, String order_Listname){
		FindByName(order_Listname).remove(order_id);
		orderQueue.remove(order_id);
		/*remove all its geo/general subscriptions*/
	}
	public void RegisterOrder_Type(Order_Lists newOrder_Lists){
		order_Lists.add(newOrder_Lists);
	}
}
