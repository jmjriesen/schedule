package CalenderGui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DayGui {
	JPanel panel;
	JButton editButton;
	public DayGui(int day){
		panel = new JPanel();
		editButton = new JButton();
		editButton.setText(Integer.toString(day));
		panel.add(editButton);
	}

}
