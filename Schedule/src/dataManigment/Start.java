package dataManigment;

import gui.GuiControl;
import java.util.List;
import java.util.PriorityQueue;


public class Start {
	
	// will read in workers for text fill
	
	private static Month month;
	

	public static void main(String [ ] args){

		
		WorkerInfoHandaler.getInstance().readInStaff();

		boolean workingOnGUI = true;
		if (workingOnGUI){
			
			// This will call the Start.makeMonth()
			GuiControl.getInstence().startWorkerMainMenu();

		}else{
			createMonth(7,0);
			month.schedule();
		}

			

		
	}

	public static void createMonth(int daysInMonth, int monthStartsOn){
		
		month = new Month(daysInMonth, monthStartsOn);
	}
	/**
	 * @return the month
	 */
	public static Month getMonth() {
		return month;
	}
}
