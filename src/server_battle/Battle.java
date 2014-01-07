package server_battle;

import java.awt.Point;
import java.io.*;
import units.*;
import administrative.Logger;

public class Battle {

	private static final int EXECUTION_POOL_SIZE = 4;
	public static Logger Log = new Logger();
	
	public static void main(String args[]) throws Exception {
		//List<String> fileNames = Arrays.asList("MainOut","UnitStatus","OrderStatus","Engine");
		//List<String> comPorts = Arrays.asList("COM1","COM2","COM3","COM4");
		//Log.initialize(fileNames, comPorts);
		
		Map gameMap = new Map();
		unit_management.GameUnits gameDatabase = new unit_management.GameUnits();
		Order_Time_Matrix Orders = new Order_Time_Matrix(EXECUTION_POOL_SIZE, gameMap, gameDatabase);
		Orders.RegisterOrder_Type(new UnitCreationOrder_List());
		Orders.RegisterOrder_Type(new MovementOrder_List());
		Orders.RegisterOrder_Type(new UpdateOrder_List());

		init();

		
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
			outputCurrentState(Orders, gameDatabase, gameMap);
		}while(input != "exit");
		
		outputCurrentState(Orders, gameDatabase, gameMap);
		//Log.close();
    }
	
	private static void init(){
	}
	

	private static boolean parseStringtoOrder(Order_Time_Matrix Orders, String input){
		String[] inParse = input.trim().split(" ");
		if(inParse[0].equals("createUnit")){
			Log.logln("MainOut","HOLYSHITIMABAT");
			Unit createdUnit;
			
			if(inParse[1].equals("marine") || inParse[1].equals("Marine") || inParse[1].equals("m"))
				createdUnit = new Marine();
			else
				createdUnit = null;
			
			Point createPosition = new Point(Integer.parseInt(inParse[2]),Integer.parseInt(inParse[3]));
			
			if(createdUnit != null && createPosition != null)
				Orders.AddOrder(new UnitCreationOrder(createdUnit, createPosition), "UnitCreation");
			
			Log.logln("MainOut",createdUnit.getName());
		}else if(inParse[0].equals("moveUnit")){
			//Orders.AddOrder(newOrder, "Movement");
		}else if(inParse[0].equals("checkUnit")){
			Orders.getGameDatabase().getUnit(Integer.parseInt(inParse[1]));
		}else{
			return false;
		}
		return true;
		//Orders.AddOrder(newOrder, order_Listname);
	}
	
	private static void outputCurrentState(Order_Time_Matrix Orders, unit_management.GameUnits gameDatabase, Map gameMap){
		Log.logln("MainOut", "Number of Orders on the Time Queue: " + Orders.queuePeek());
	}
}
