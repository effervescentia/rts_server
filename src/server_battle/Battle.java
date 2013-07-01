package server_battle;

public class Battle {

	private static final int EXECUTION_POOL_SIZE = 4;

	public static void main(String args[]) {
		Order_Time_Matrix Orders = new Order_Time_Matrix(EXECUTION_POOL_SIZE);
		new UnitCreationOrder_List(Orders);
    }
}
