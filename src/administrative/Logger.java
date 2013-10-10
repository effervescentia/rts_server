package administrative;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import server_battle.Order_Lists;

public class Logger{
	private List<outputChannel> channelList;
	private Date currentDateTime;
	
	public Logger(){
		currentDateTime = new Date();
	}
	public boolean initialize(List<String> fileNames, List<String> ComPorts){
		PrintWriter outputFile = null;
		OutputStream serialchannel = null;
		
		if (fileNames.size() == ComPorts.size()){
			for(int i = 0; i < fileNames.size(); i++){
				
				try{
					outputFile = new PrintWriter(fileNames.get(i)+".txt", "UTF-8");
				}catch(Exception e){
					return false;
				}
				
				try{
					//KEEP GOING RIGHT HERE JOSH
					serialchannel = new 
				}catch(Exception e){
					
				}
			}
			return true;
		}else
			return false;
	}
	public void logln(String Message){
		outputFile.println(new Timestamp(currentDateTime.getTime()) + ":   " + Message);
	}
	public void close(){
		
		outputFile.close();
	}
	
}

