package CalenderGui;

import java.awt.GridLayout;

import javax.swing.JFrame;

import dataManigment.Month;
import dataManigment.Week;

public class CalenderMainMenu extends JFrame{
	WeekGui[] weekGuis;
	Month month;
	public CalenderMainMenu(int daysInMonth, int monthStartsOn) {
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//month.createWeeks(daysInMonth,monthStartsOn);
		createWeeks(daysInMonth,monthStartsOn);
		setLayout(new GridLayout(weekGuis.length,1));
		
		for (WeekGui week : weekGuis){
			add(week.calendarPane);
		}


	}private void createWeeks(int daysInMonth, int monthStartsOn){
		// Determines how many weeks are in the month
		int efectiveDaysInMonth = daysInMonth + monthStartsOn;
		int numberOfWeeks = efectiveDaysInMonth / 7;
		//Rounds up if needed
		if (efectiveDaysInMonth % 7 !=0){
			numberOfWeeks++;
		}

		//Determine how many week to put in array
		weekGuis = new WeekGui[numberOfWeeks];
		
		weekGuis[0] = new WeekGui();
		int lastWeekMade = 0;
		int lastDayMade = weekGuis[0].makeDays(monthStartsOn);
		while (lastDayMade < daysInMonth && lastWeekMade < weekGuis.length-1){
			weekGuis[lastWeekMade + 1] = new WeekGui();
			lastDayMade = weekGuis[lastWeekMade +1].makeDays(lastDayMade+1,daysInMonth);
			System.out.println(lastDayMade);
			lastWeekMade ++;
			
		}
	

		
	}

}
