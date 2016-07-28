package CalenderGui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import dataManigment.Month;
import dataManigment.Week;


public class MonthGui extends JFrame{
	WeekGui[] weekGuis;
	Month month;
	public MonthGui(int daysInMonth, int monthStartsOn) {
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		month = new Month();
		month.createWeeks(daysInMonth,monthStartsOn);
		
		setLayout(new GridLayout(month.weeks.length,1));
		
		
		for (Week week : month.weeks){
			add(week.weekGui.calendarPane);
		}


	}

}
