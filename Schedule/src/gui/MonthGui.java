package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dataManigment.Month;
import dataManigment.Week;


public class MonthGui {
	WeekGui[] weekGuis;
	Month month;
	private JPanel monthDesplay;


	public MonthGui(Month month) {
		

		this.month = month;
		
		
		monthDesplay = new JPanel();
		monthDesplay.setLayout(new GridLayout(month.weeks.length,1));

		for (Week week : month.weeks){
			monthDesplay.add(week.getWeekGui().getThumbnailPanel());
			
		}

	}

	protected JPanel getMonthDesplay(){
		return monthDesplay;
	}

}
