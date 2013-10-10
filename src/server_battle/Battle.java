package server_battle;

import java.io.*;
import java.util.*;
import gnu.io.*;

import administrative.Logger;

public class Battle {

	private static final int EXECUTION_POOL_SIZE = 4;
	private static Logger Log = new Logger();
	
	public static void main(String args[]) throws Exception {
		Map gameMap = new Map();
		units.GameUnits gameDatabase = new units.GameUnits();
		Order_Time_Matrix Orders = new Order_Time_Matrix(EXECUTION_POOL_SIZE, gameMap, gameDatabase);
		Orders.RegisterOrder_Type(new UnitCreationOrder_List());
		Orders.RegisterOrder_Type(new MovementOrder_List());
		Orders.RegisterOrder_Type(new UpdateOrder_List());

		
		if(Log.initialize("log.txt")){
		}
		else{
			System.out.println("Log File failed to open");
			throw new Exception("LogFailedtoOpen");
		}
		
		System.out.println("Let the game begin: ");
		
		String input;
		do{
			input = "";
			try{
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				input = bufferRead.readLine();
				Log.logln(input);
				if(!parseStringtoOrder(Orders, input)){
					Log.logln(input + " DID NOT COMPILE");
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		
		}while(input != "exit");
		outputCurrentState(Orders, gameDatabase, gameMap);
		Log.close();
    }
	

	private static boolean parseStringtoOrder(Order_Time_Matrix Orders, String input){
		input = input.trim().substring(0, (input.length() - 1));
		String[] tokens = input.split("[(]");
		if(tokens[0] == "buildunit"){
			//Orders.AddOrder(newOrder, "UnitCreation");
			return true;
		}else if(tokens[0] == "moveunit"){
			//Orders.AddOrder(newOrder, "Movement");
			return true;
		}else{
			return false;
		}
		//Orders.AddOrder(newOrder, order_Listname)
	}
	
	private static void outputCurrentState(Order_Time_Matrix Orders, units.GameUnits gameDatabase, Map gameMap){
		
	}
}
