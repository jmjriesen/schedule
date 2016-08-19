package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dataManigment.Day;
import dataManigment.Month;
import dataManigment.Start;
import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;

public class GuiControl extends JFrame{
	private JScrollPane scroll ;
	private static GuiControl guiControl;
	
	// will read in workers for text fill
	

	public static GuiControl getInstence(){
		if (guiControl == null){
			guiControl = new GuiControl();
		}
		return guiControl;
	}
	
	 private  GuiControl(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(300,600);
		
	}
	/*
	 * Instructs the WorkerInfoHandeler to wright the 
	 * staff list to a text fill for fucher use
	 */
	void saveStaff(){
		WorkerInfoHandaler.getInstance().wrightOutStaff();

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
		scroll = new JScrollPane(newPanel);
		add(scroll,BorderLayout.WEST);
		//this.add(newPanel);
		this.pack();
		//resizes widow if it is to large for the pi screen
		if(this.getSize().getHeight()>400){
			setSize(this.getWidth(),400);
			
		}		
		this.revalidate();
		
	}
	public void startWorkerEditWindow(Worker worker) {
		WorkerEditWindow workerEditWindow = new WorkerEditWindow(worker);
		this.changePanel(workerEditWindow.getPanel());
		
	}
	public void startWorkerAddGui() {
		WorkerAddGui workerAddGui = new WorkerAddGui();
		changePanel(workerAddGui.getPanel());
		
	}

	public void startDayEditWindow(DayGui dayGui) {
		changePanel(dayGui.getEditDayPanel());
		
	}

	
	
}
