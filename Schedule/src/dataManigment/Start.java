package dataManigment;

import gui.GuiControl;
import java.util.List;





public class Start {
	
	// will read in workers for text fill
	static WorkerInfoHandaler handaler;
	private static Month month;
	
	

	

	public static void main(String [ ] args){

		
		//loudes workers
		// Initiates workerInfoHandaler
		handaler = new WorkerInfoHandaler();
		//Reads in staff from text document
		handaler.readInStaff();
		// deploy workerMainMenu

		boolean workingOnGUI = false;
		if (workingOnGUI){
			
			// This will call the Start.makeMonth()
			GuiControl.getInstence().startCalenderSettingsWindow();

		}else{
			createMonth(7,0);
			month.schedule();
			System.out.println("done");
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
