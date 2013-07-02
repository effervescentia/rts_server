package server_battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Battle {

	private static final int EXECUTION_POOL_SIZE = 4;

	public static void main(String args[]) {
		Map gameMap = new Map();
		units.GameUnits gameDatabase = new units.GameUnits();
		Order_Time_Matrix Orders = new Order_Time_Matrix(EXECUTION_POOL_SIZE, gameMap, gameDatabase);
		Orders.RegisterOrder_Type(new UnitCreationOrder_List());
		Orders.RegisterOrder_Type(new MovementOrder_List());
		Orders.RegisterOrder_Type(new UpdateOrder_List());
		
		PrintWriter logger = new PrintWriter("log.txt", "UTF-8");
		System.out.println("Let the game begin: ");
		
		String input;
		do{
			
			try{
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				input = bufferRead.readLine();
				logger.println(input);
				parseStringtoOrder(Orders, input);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
		}while(input != "exit");
		
		logger.close();
    }
	private static void parseStringtoOrder(Order_Time_Matrix Orders, String input){
		input = input.trim().substring(0, (input.length() - 1));
		String[] tokens = input.split("[(]");
		if(tokens[0] == "buildunit"){
			Orders.AddOrder(newOrder, "UnitCreation")
		}else if(tokens[0] == "moveunit"){
			Orders.AddOrder(newOrder, "Movement")
		}
		//Orders.AddOrder(newOrder, order_Listname)
	}
}
