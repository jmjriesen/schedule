package gui;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataManigment.Day;
import dataManigment.Week;

public class WeekGui {
	Week week;
	//all days in this week week
	public DayGui[] daysGui = new DayGui[7];
	
	private JPanel thumbnailPanel = new JPanel();
	private GridLayout thumbnailGridLayout = new GridLayout(1,8);
	private JButton thumbnailEditButton;
	
	
	
	public WeekGui(Week week) {
		this.week = week;
		
		for (int index = 0; index<7; index++){
			if (week.getDays()[index] != null){
				daysGui[index] = new DayGui(week.getDays()[index]); 
			}
		}
		
		

		//JPanal required for nesting GridLayouts
		thumbnailPanel.setLayout(thumbnailGridLayout);
		// making a button evenchaly will lead to week wide edit window
		thumbnailEditButton = new JButton("Week");
		thumbnailPanel.add(thumbnailEditButton);
		// adds DayGuis to the panel		
		for(DayGui dayGui: daysGui){
			if(dayGui==null){
				thumbnailPanel.add(new JLabel());
			}else{
				thumbnailPanel.add(dayGui.getThumbnailPanel());

			}
		}
	}
	JPanel getThumbnailPanel(){
		return thumbnailPanel;
	}


}
