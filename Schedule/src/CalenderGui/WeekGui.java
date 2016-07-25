package CalenderGui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekGui {
	int daysInWeek;
	JPanel calendarPane = new JPanel();
	GridLayout calendarLayout = new GridLayout(1,8);
	JButton weekNumberButton;
	
	protected WeekGui(int weekNumber) {
		constructer(weekNumber,7);	

	}

	public WeekGui(int weekNumber, int numberOfDaysInWeek) {
		constructer(weekNumber, numberOfDaysInWeek);
	}
	
	
	private void constructer(int weekNumber, int numberOfDaysInWeek) {
		// temp variable will evenchaly be replaced by a list of days
		daysInWeek = numberOfDaysInWeek;
		//panal requierd for nesting gridlayouts
		calendarPane.setLayout(calendarLayout);
		// making a buton evenchaly will lead to week wide eddit window
		weekNumberButton = new JButton("Week"+Integer.toString(weekNumber));
		calendarPane.add(weekNumberButton);
		
	}
}
