package dataManigment;

import java.util.List;
import DaysOffRequestGui.WorkerMainMenu;
import DaysOffRequestGui.WorkerGuiControl;




public class Start {
	public static void main(String [ ] args){
		
		
		boolean workingOnGUI = true;
		if (workingOnGUI){
		
			
			WorkerGuiControl gui = new WorkerGuiControl();

			
			
		}else{
		 WorkerInfoHandaler handaler = new WorkerInfoHandaler();
		 List<Worker> staff = handaler.readInStaff();
		 Shedule july = new Shedule(staff);
		july.fillOutShedual();
		july.printShedual();
		}
		 
		
		
		
		 
				 
	}

}
