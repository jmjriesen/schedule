package CalenderGui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataManigment.Day;
import dataManigment.Week;

public class WeekGui {
	Week week;
	//all days in this week week
	public DayGui[] daysGui = new DayGui[7];
	
	JPanel calendarPane = new JPanel();
	GridLayout calendarLayout = new GridLayout(1,8);
	JButton weekNumberButton;
	
	public WeekGui(Week week) {
		this.week = week;
		
		//panal requierd for nesting gridlayouts
		calendarPane.setLayout(calendarLayout);
		// making a buton evenchaly will lead to week wide eddit window
		weekNumberButton = new JButton("Week");
		calendarPane.add(weekNumberButton);
	}



	public void addDaysPanel() {
		
		
		for(Day day: week.days){
			if(day==null){
				calendarPane.add(new JLabel());
			}else{
				calendarPane.add(day.dayGui.panel);
				
			}
		}
	}

// The creation of day guis are being moved to the day class
/*
	public int makeDays(int monthStartsOn) {
		int lastDayMade = 0;
		for (int i = 0 ;i<(7-monthStartsOn);i++){
			daysGui[7-(i+1)] = new DayGui(7-(monthStartsOn+i));
			lastDayMade = i;
		}
		addDaysPanel();
		
		return lastDayMade+1;
	}



	public int makeDays(int DateWeekStartsOn, int daysInMonth) {
		
		int numberOfDaysMade = 0;
		int lastDayMade = DateWeekStartsOn -1;
		
		while(numberOfDaysMade<7 && lastDayMade < daysInMonth){
			daysGui[numberOfDaysMade] = new DayGui(lastDayMade +1);
			lastDayMade++;
			numberOfDaysMade++;
		}
		addDaysPanel();
		return lastDayMade;
	}
	*/
}
