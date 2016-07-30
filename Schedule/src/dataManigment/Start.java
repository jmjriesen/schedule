package dataManigment;

import gui.GuiControl;
import java.util.List;




//temp
public class Start {
	public static void main(String [ ] args){
		
		
		boolean workingOnGUI = true;
		if (workingOnGUI){
		
			
			GuiControl gui = new GuiControl();

			
			
		}else{
		 WorkerInfoHandaler handaler = new WorkerInfoHandaler();
		 List<Worker> staff = handaler.readInStaff();
		 Shedule july = new Shedule(staff);
		july.fillOutShedual();
		july.printShedual();
		}
		 
				 
	}

}
