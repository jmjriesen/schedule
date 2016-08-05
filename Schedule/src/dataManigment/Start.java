package dataManigment;

import gui.GuiControl;
import java.util.List;
import java.util.PriorityQueue;


public class Start {
	
	// will read in workers for text fill
	public static WorkerInfoHandaler handaler;
	private static Month month;
	

	public static void main(String [ ] args){

		
		//loudes workers
		// Initiates workerInfoHandaler
		handaler = new WorkerInfoHandaler();
		//Reads in staff from text document
		handaler.readInStaff();
		// deploy workerMainMenu

		boolean workingOnGUI = true;
		if (workingOnGUI){
			
			// This will call the Start.makeMonth()
			GuiControl.getInstence().startWorkerMainMenu();

		}else{
			createMonth(7,0);
			month.schedule();
			System.out.println("done");

			for (Week week : month.getWeeks()){
				for(Day day:week.getDays()){
					if(day!=null){
						System.out.println(day.getDate());






						PriorityQueue<Shift> shiftHeap = new PriorityQueue<Shift>(day.getShifts());
						Shift shift = shiftHeap.poll();
						
						
						while (shift != null){

							

							if(shift!= null){
							System.out.println(shift.getWorkerTyp());
							
							
								for(Worker worker:shift.getSlots()){
									if (worker!=null){
										System.out.println(worker.getSymbol());
									}
								}
								
							shift = shiftHeap.poll();
							}
						}
					}
				}
			}
		}

		for(Worker worker:Worker.getWorkers()){
			System.out.println(worker.getSymbol());
			for (Shift shift : worker.getDaysWorking()){
				System.out.println(shift.getDate());
			}
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
