package CalenderGui;

import javax.swing.JFrame;

public class CalenderMainMenu extends JFrame{
	

	public CalenderMainMenu(int daysInMonth, int monthStartsOn) {
		setSize(700,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// Determines how many weeks are in the month
		int numberOfWeeks =(daysInMonth+monthStartsOn)/7;
		//Rounds up if needed
		if ((daysInMonth+monthStartsOn) % 7 !=0){
			numberOfWeeks++;
			
		}
		System.out.println(numberOfWeeks);
	}

}
