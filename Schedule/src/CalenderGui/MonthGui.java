package CalenderGui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Month;
import dataManigment.Week;


public class MonthGui extends JFrame{
	WeekGui[] weekGuis;
	Month month;
	JPanel monthDesplay;
	public MonthGui(int daysInMonth, int monthStartsOn) {
		
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		month = new Month();
		month.createWeeks(daysInMonth,monthStartsOn);
		setLayout(new GridLayout(month.weeks.length,1));
		
		monthDesplay = new JPanel();
		monthDesplay.setLayout(new GridLayout(month.weeks.length,1));
		
		
		
		
		for (Week week : month.weeks){
			monthDesplay.add(week.getWeekGui().getThumbnailPanel());
			
	}
		monthDesplay.
		add(monthDesplay);
		pack();

	}
	protected JPanel getMonthDesplay(){
		return monthDesplay;
	}

}
