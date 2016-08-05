package dataManigment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//singliet class
public class WorkerInfoHandaler {
	private static WorkerInfoHandaler workerInfoHandaler;
	
	public static WorkerInfoHandaler getInstance(){
		
		if (workerInfoHandaler==null){
			workerInfoHandaler = new WorkerInfoHandaler();
		}
		
		return workerInfoHandaler;
	}
	private WorkerInfoHandaler(){
		
	}
	
	
	
	
	
	private String fileName= "WorkerInfo.txt";
		
		
		
		public void readInStaff(){
			String line;
			
		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null){
				String[] splitString = line.split(",");
				//first sysmble second worker Type
				
				Worker worker = new Worker(splitString[0],Integer.valueOf(splitString[1]));
				
				for(int i= 2; i< splitString.length; i++){
					Integer dayOff = Integer.valueOf(splitString[i]);
					worker.requestOff(dayOff);
				}
			}
			
			
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		}



		public void wrightOutStaff() {
			// TODO Auto-generated method stub
			try {
				FileWriter fileWriter = new FileWriter(fileName);
				BufferedWriter bufferdWriter = new BufferedWriter(fileWriter);
				String output = "";



				for(Worker worker : Worker.getWorkers()){
					output += worker.getSymbol();
					output += ",";
					output += Integer.toString(worker.getType());
					output +=",";
					for (int dayRequestedOff : worker.getRequestedOff()){
						output += dayRequestedOff;
						output += ",";
					}
					output +="\n";
				}


				bufferdWriter.write(output);
				bufferdWriter.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}




		}
		
		
}
