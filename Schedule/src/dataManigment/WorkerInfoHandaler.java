package dataManigment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WorkerInfoHandaler {
		String fileName= "WorkerInfo.txt";
		
		
		
		public java.util.List<Worker> readInStaff(){
			String line;
			java.util.List<Worker> staff = new ArrayList<Worker>();

		
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null){
				String[] arr = line.split(",");
				Worker worker = new Worker(arr[0]);
				staff.add(worker);
				for(int i= 1; i< arr.length; i++){
					
					Integer dayOff = Integer.valueOf(arr[i]);
					worker.requestOff(dayOff);
				}
			}
			
			
			bufferedReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staff;
		}



		public void wrightOutStaff(List<Worker> workers) {
			// TODO Auto-generated method stub
			try {
				FileWriter fileWriter = new FileWriter(fileName);
				BufferedWriter bufferdWriter = new BufferedWriter(fileWriter);
				String output = "";



				for(Worker worker : workers){
					output += worker.getSymbol();
					output += ",";
					for(int i = 0; i< worker.getRequestedOff().size(); i++){
						output += Integer.toString((int) worker.getRequestedOff().get(i));
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
