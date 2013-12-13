package server_battle;

import java.io.*;
import java.util.*;
import units.*;
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

		Properties p = new Properties(System.getProperties());
		p.setProperty("jcommander.debug", "true");
		System.setProperties(p);
		
		init();
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
			outputCurrentState(Orders, gameDatabase, gameMap);
		}while(input != "exit");
		
		outputCurrentState(Orders, gameDatabase, gameMap);
		Log.close();
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
			
			Position createPosition = new Position(Integer.parseInt(inParse[2]),Integer.parseInt(inParse[3]));
			
			if(createdUnit != null && createPosition != null)
				Orders.AddOrder(new UnitCreationOrder(createdUnit, createPosition), "UnitCreation");
			
			Log.logln("MainOut",createdUnit.getName());
		}else if(inParse[0] == "moveUnit"){
			//Orders.AddOrder(newOrder, "Movement");
		}else{
			return false;
		}
		return true;
		//Orders.AddOrder(newOrder, order_Listname)
	}
	
	private static void outputCurrentState(Order_Time_Matrix Orders, units.GameUnits gameDatabase, Map gameMap){
		Log.logln("MainOut", "Number of Orders on the Time Queue: " + Orders.queuePeek());
	}
}
