package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Month;
import dataManigment.Week;


public class MonthGui {
	WeekGui[] weekGuis;
	Month month;
	private JPanel monthDesplay;


	public MonthGui(int daysInMonth, int monthStartsOn) {
		

		month = new Month();
		month.createWeeks(daysInMonth,monthStartsOn);
		
		monthDesplay = new JPanel();
		monthDesplay.setLayout(new GridLayout(month.weeks.length,1));

		for (Week week : month.weeks){
			monthDesplay.add(week.getWeekGui().getThumbnailPanel());
			
		}

	}

	protected JPanel getMonthDesplay(){
		return monthDesplay;
	}

}
