package dataManigment;

import gui.GuiControl;
import java.util.List;




//temp
public class Start {
	// will read in workers for text fill
	static WorkerInfoHandaler handaler;
	private static Month month;
	
	/**
	 * @return the month
	 */
	public static Month getMonth() {
		return month;
	}

	

	public static void main(String [ ] args){

		
		//lodes workers
		// Initiates workerInfoHandaler
		handaler = new WorkerInfoHandaler();
		//Reads in staff from text document
		handaler.readInStaff();
		// deploy workerMainMenu

		boolean workingOnGUI = true;
		if (workingOnGUI){
			
			// This will call the Start.makeMonth()
			GuiControl.getInstence().startCalenderSettingsWindow();

		}
		


	}

	public static void createMonth(int daysInMonth, int monthStartsOn){
		
		month = new Month(daysInMonth, monthStartsOn);
	}
}
