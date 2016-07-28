package CalenderGui;

import javax.swing.JButton;
import javax.swing.JPanel;

import dataManigment.Day;

public class DayGui {
	JPanel panel;
	JButton editButton;
	public DayGui(Day day){
		panel = new JPanel();
		editButton = new JButton();
		System.out.println(day.getDate());
		editButton.setText(Integer.toString(day.getDate()));
		panel.add(editButton);
	}

}
