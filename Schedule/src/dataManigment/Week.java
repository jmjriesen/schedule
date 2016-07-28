package dataManigment;

import CalenderGui.DayGui;

public class Week {
	Day[] days;
	
	public int makeDays(int monthStartsOn) {
		int lastDayMade = 0;
		for (int i = 0 ;i<(7-monthStartsOn);i++){
			days[7-(i+1)] = new Day(7-(monthStartsOn+i));
			lastDayMade = i;
		}
		
		
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
		
		return lastDayMade;
	}
}
