package dataManigment;

import CalenderGui.DayGui;
import CalenderGui.WeekGui;

public class Week {
	public Day[] days = new Day[7];
	public WeekGui weekGui = new WeekGui(this);
	
	public int makeDays(int monthStartsOn) {
		int lastDayMade = 0;
		for (int i = 0 ;i<(7-monthStartsOn);i++){
			days[7-(i+1)] = new Day(7-(monthStartsOn+i));
			lastDayMade = i;
		}
		
		weekGui.addDaysPanel();
		return lastDayMade+1;
	}
public int makeDays(int DateWeekStartsOn, int daysInMonth) {
		
		int numberOfDaysMade = 0;
		int lastDayMade = DateWeekStartsOn -1;
		
		while(numberOfDaysMade<7 && lastDayMade < daysInMonth){
			days[numberOfDaysMade] = new Day(lastDayMade +1);
			lastDayMade++;
			numberOfDaysMade++;
		}
		weekGui.addDaysPanel();
		return lastDayMade;
	}
}
