package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import dataManigment.Day;
import dataManigment.Shift;

public class DayGui {
	private JPanel thumbnailPanel = new JPanel();
	private JButton thumbnailEditButton;
	
	private JPanel editDayPanel = new JPanel();
	private JButton returnButton = new JButton("return");
	
	public DayGui(Day day){
		//inichalis new JPanel and JButton
		
		thumbnailEditButton = new JButton();
		//sets the button up and adds it to the panel
		thumbnailEditButton.setText(Integer.toString(day.getDate()));
		thumbnailPanel.add(thumbnailEditButton);
		thumbnailEditButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiControl.getInstence().startDayEditWindow(DayGui.this);
				
				
			}
			
		});
		for(Shift shift :day.getShifts()){
			editDayPanel.add(new ShiftGui(shift).getPanel()); 
		}
	editDayPanel.add(returnButton);
	returnButton.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			GuiControl.getInstence().startCalenderMainMenu();
			
		}
		
	});
	
	
	
	
	
	
	
	
	
	
	}
	
	//get statement
	JPanel getThumbnailPanel(){
		return thumbnailPanel;
		}
	JPanel getEditDayPanel(){
	return editDayPanel;
	}
}
