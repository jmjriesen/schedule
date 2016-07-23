package CalenderGui;

import javax.swing.JFrame;

public class CalenderMainMenu extends JFrame{
	WeekGui[] weekGuis;

	public CalenderMainMenu(int daysInMonth, int monthStartsOn) {
		setSize(700,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// Determines how many weeks are in the month
		int efectiveDaysInMonth = daysInMonth+monthStartsOn;
		int numberOfWeeks =efectiveDaysInMonth/7;
		//Rounds up if needed
		if (efectiveDaysInMonth % 7 !=0){
			numberOfWeeks++;
			
		}
		//Determine how many week to put in array
		weekGuis = new WeekGui[numberOfWeeks];
		//week first initiation
		weekGuis[0] = new WeekGui(0,(7-monthStartsOn));
		
		//constructs all the weeks in the middel of the month
		for(int i= 1; i<numberOfWeeks-1;i++){
			weekGuis[i] = new WeekGui(i);


		}
		//lastWeek days initiontion

		//days in days remaining after full weeks
		int daysLeftOver = efectiveDaysInMonth%7;
		
		if (daysLeftOver ==0){//seven days in the week
			weekGuis[weekGuis.length-1] = new WeekGui(weekGuis.length);
		}else{//less then seven days in the week
			weekGuis[weekGuis.length-1] = new WeekGui(weekGuis.length,daysLeftOver);
		}



	}

}
