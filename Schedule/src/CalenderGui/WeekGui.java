package CalenderGui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeekGui {
	
	//all days in this week week
	DayGui[] daysGui = new DayGui[7];
	
	JPanel calendarPane = new JPanel();
	GridLayout calendarLayout = new GridLayout(1,8);
	JButton weekNumberButton;
	
	protected WeekGui() {
		// temp variable will evenchaly be replaced by a list of days
		
		//panal requierd for nesting gridlayouts
		calendarPane.setLayout(calendarLayout);
		// making a buton evenchaly will lead to week wide eddit window
		weekNumberButton = new JButton("Week");
		calendarPane.add(weekNumberButton);
	}



	private void addDaysPanel() {
		
		
		for(DayGui day:daysGui){
			if(day==null){
				calendarPane.add(new JLabel());
			}else{
				calendarPane.add(day.panel);
				
			}
		}
	}



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
}
