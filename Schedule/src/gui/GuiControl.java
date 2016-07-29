package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;

public class GuiControl extends JFrame{
	// list of all workers
	java.util.List<Worker> workers;
	// will read in workers for text fill
	WorkerInfoHandaler handaler;

	public GuiControl(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
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
	protected void startWorkerMainMenu(){
		WorkerMainMenu workerMainMenu = new WorkerMainMenu(this);
		changePanel(workerMainMenu.getPanel());
	}

	protected void startCalenderMainMenu(int daysInMonth,int monthStartsOn) {
		MonthGui monthGui = new MonthGui(daysInMonth, monthStartsOn);
		changePanel(monthGui.getMonthDesplay());
	}

	protected void startCalenderSettingsWindow() {
		CalenderSettingsWindow calenderSettingsWindow = new CalenderSettingsWindow(this);
		//this.removeAll();
		changePanel(calenderSettingsWindow.getPanel());

	}
	private void changePanel(JPanel newPanel){
		this.getContentPane().removeAll();
		this.add(newPanel);
		this.pack();
		this.revalidate();
	}
	public void startWorkerEditWindow(Worker worker) {
		WorkerEditWindow workerEditWindow = new WorkerEditWindow(worker,this);
		changePanel(workerEditWindow.getPanel());
		
		
	}
	public void startWorkerAddGui() {
		WorkerAddGui workerAddGui = new WorkerAddGui(this);
		changePanel(workerAddGui.getPanel());
		
	}
	public void startCalenderGui() {
		// TODO Auto-generated method stub
		
	}
}
