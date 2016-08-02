package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Month;
import dataManigment.Week;


public class MonthGui {
	private Month month;
	private WeekGui[] weekGuis;
	
	
	private JPanel monthDesplay;


	public MonthGui(Month month) {
		
		//month that is to be despladed
		this.month = month;
		
		//creating Weekguis for each week in month
		weekGuis = new WeekGui[month.getWeeks().length];
		for (int index = 0; index<month.getWeeks().length; index++){
			if (month.getWeeks()[index] != null){
				weekGuis[index] = new WeekGui(month.getWeeks()[index]); 
			}
		}
		
		
		
		monthDesplay = new JPanel();
		monthDesplay.setLayout(new GridLayout(weekGuis.length,1));

		for (WeekGui weekgui : weekGuis){
			monthDesplay.add(weekgui.getThumbnailPanel());
			
		}

	}

	protected JPanel getMonthDesplay(){
		return monthDesplay;
	}

}
