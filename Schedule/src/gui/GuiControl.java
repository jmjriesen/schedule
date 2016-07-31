package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;

public class GuiControl extends JFrame{
	private static GuiControl guiControl;
	
	// will read in workers for text fill
	WorkerInfoHandaler handaler;

	public static GuiControl getInstence(){
		if (guiControl == null){
			guiControl = new GuiControl();
		}
		return guiControl;
	}
	
	 private  GuiControl(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		// Initiates workerInfoHandaler
		handaler = new WorkerInfoHandaler();
		//Reads in staff from text document
		handaler.readInStaff();
		// deploy workerMainMenu
		startWorkerMainMenu();
	}
	/*
	 * Instructs the WorkerInfoHandeler to wright the 
	 * staff list to a text fill for fucher use
	 */
	void saveStaff(){
		handaler.wrightOutStaff();

	}
	protected void startWorkerMainMenu(){
		WorkerMainMenu workerMainMenu = new WorkerMainMenu();
		changePanel(workerMainMenu.getPanel());
	}

	protected void startCalenderMainMenu(int daysInMonth,int monthStartsOn) {
		MonthGui monthGui = new MonthGui(daysInMonth, monthStartsOn);
		changePanel(monthGui.getMonthDesplay());
	}

	protected void startCalenderSettingsWindow() {
		CalenderSettingsWindow calenderSettingsWindow = new CalenderSettingsWindow();
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
		WorkerEditWindow workerEditWindow = new WorkerEditWindow(worker);
		changePanel(workerEditWindow.getPanel());
		
		
	}
	public void startWorkerAddGui() {
		WorkerAddGui workerAddGui = new WorkerAddGui();
		changePanel(workerAddGui.getPanel());
		
	}
	
}
