package DaysOffRequestGui;
import CalenderGui.CalenderGuiControl;
import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;
/*
 * WorkerGuiControl is in charge of managing
 * all windows dealing with worker setup
 * IE names days off and evenchaly type of worker
 */
public class WorkerGuiControl {
	// list of all workers
	java.util.List<Worker> workers;
	// will read in workers for text fill
	WorkerInfoHandaler handaler;
	
	
	public WorkerGuiControl(){
		// Initiates workerInfoHandaler
		handaler = new WorkerInfoHandaler();
		//Reads in staff from text document
		workers = handaler.readInStaff();
		// deploy workerMainMenu
		startWorkerMainMenu();
	}
	
	/*
	 * Instructs the WorkerInfoHandeler to wright the 
	 * staff list to a text fill for fucher use
	 */
	void saveStaff(){
		handaler.wrightOutStaff(workers);
		
	}

	/*
	 * deploys WorkerEditWindow
	 */
	public void startWorkerEditWindow(Worker worker) {
		WorkerEditWindow workerEditWindow = new WorkerEditWindow(worker,this);
		
	}

/*
 * deploys WorkerMainMenu
 */
	public void startWorkerMainMenu() {
		WorkerMainMenu workerMainMenu = new WorkerMainMenu(this);
		
	}

/*
 * deplys WorkerAddGui
 */
	public void startWorkerAddGui() {
		WorkerAddGui workerAddGui = new WorkerAddGui(this);
		
	}
	void startCalenderGui(){
		CalenderGuiControl cal = new CalenderGuiControl();
	}
}
