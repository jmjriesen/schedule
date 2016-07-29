package CalenderGui;

import javax.swing.JButton;
import javax.swing.JPanel;

import dataManigment.Day;

public class DayGui {
	private JPanel thumbnailPanel;
	private JButton thumbnailEditButton;
	private JPanel editDayPanel;
	
	public DayGui(Day day){
		//inichalis new JPanel and JButton
		thumbnailPanel = new JPanel();
		thumbnailEditButton = new JButton();
		//sets the button up and adds it to the panel
		thumbnailEditButton.setText(Integer.toString(day.getDate()));
		thumbnailPanel.add(thumbnailEditButton);
	}
	
	//get statement
	JPanel getThumbnailPanel(){
		return thumbnailPanel;
		}
	JPanel getEditDayPanel(){
	return editDayPanel;
	}
}
