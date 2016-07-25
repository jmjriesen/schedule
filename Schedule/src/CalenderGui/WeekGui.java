package CalenderGui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;

public class WeekGui {
	int daysInWeek;
	JPanel calendarPane;
	GridLayout calendarLayout = new GridLayout(1,8);
	protected WeekGui(int weekNumber) {
		constructer(weekNumber,7);	

	}

	public WeekGui(int weekNumber, int numberOfDaysInWeek) {
		constructer(numberOfDaysInWeek, numberOfDaysInWeek);
	}
	private void constructer(int weekNumber, int numberOfDaysInWeek) {
		daysInWeek = numberOfDaysInWeek;
		System.out.println(daysInWeek);
		calendarPane.setLayout(calendarLayout);
	}
}
