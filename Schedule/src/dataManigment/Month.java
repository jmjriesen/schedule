package dataManigment;

import gui.WeekGui;

public class Month {
	private Week[] weeks;

	public Month(int daysInMonth, int monthStartsOn) {
		this.createWeeks(daysInMonth,monthStartsOn);
	}

	private void createWeeks(int daysInMonth, int monthStartsOn){
		// Determines how many weeks are in the month
		int efectiveDaysInMonth = daysInMonth + monthStartsOn;
		int numberOfWeeks = efectiveDaysInMonth / 7;
		//Rounds up if needed
		if (efectiveDaysInMonth % 7 !=0){
			numberOfWeeks++;
		}

		//Determine how many week to put in array
		weeks = new Week[numberOfWeeks];

		weeks[0] = new Week();
		int lastWeekMade = 0;
		int lastDayMade = weeks[0].makeDays(monthStartsOn);
		while (lastDayMade < daysInMonth && lastWeekMade < weeks.length-1){
			weeks[lastWeekMade + 1] = new Week();
			lastDayMade = weeks[lastWeekMade +1].makeDays(lastDayMade+1,daysInMonth);

			lastWeekMade ++;

		}

	}
	/**
	 * passes the schedule command down to the weeks
	 */
	public void schedule(){
		for (Week week: weeks){
			week.schedule();
		}
	}
	public Week[] getWeeks(){
		return weeks;
	}
}
