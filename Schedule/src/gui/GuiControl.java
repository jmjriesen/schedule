package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Day;
import dataManigment.Month;
import dataManigment.Start;
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
		
		
	}
	/*
	 * Instructs the WorkerInfoHandeler to wright the 
	 * staff list to a text fill for fucher use
	 */
	void saveStaff(){
		Start.handaler.wrightOutStaff();

	}
	public void startWorkerMainMenu(){
		WorkerMainMenu workerMainMenu = new WorkerMainMenu();
		changePanel(workerMainMenu.getPanel());
	}

	public void startCalenderMainMenu() {
		
		MonthGui monthGui = new MonthGui(Start.getMonth());
		changePanel(monthGui.getMonthDesplay());
	}

	public void startCalenderSettingsWindow() {
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

	public void startDayEditWindow(DayGui dayGui) {
		changePanel(dayGui.getEditDayPanel());
		
	}
	
}
