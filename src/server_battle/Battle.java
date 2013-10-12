package server_battle;

import java.io.*;
import java.util.*;

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
		List<String> fileNames = Arrays.asList("MainOut","UnitStatus","OrderStatus","Active");
		List<String> comPorts = Arrays.asList("COM1","COM2","COM3","COM4");

		Log.initialize(fileNames, comPorts);
		
		System.out.println("Let The Game Begin: ");
		Log.logln("MainOut", "Let the Game Begin");
		String input;
		do{
			input = "";
			try{
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				input = bufferRead.readLine();
				Log.logln("MainOut",input);
				if(!parseStringtoOrder(Orders, input)){
					Log.logln("MainOut", input + " DID NOT COMPILE");
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
