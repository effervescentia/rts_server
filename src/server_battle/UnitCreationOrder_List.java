package server_battle;

public class UnitCreationOrder_List extends Order_Lists{
	public UnitCreationOrder_List(Order_Time_Matrix orders){
		super(orders, "UnitCreation");
	}
	public long add(Order order){
		order.setOrder_ID(GetandIncrement());
		Outstanding_Orders.add(order);
		return order.getOrder_ID();
	}
}
