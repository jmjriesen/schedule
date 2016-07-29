package CalenderGui;

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

		//JPanal required for nesting GridLayouts
		thumbnailPanel.setLayout(thumbnailGridLayout);
		// making a button evenchaly will lead to week wide edit window
		thumbnailEditButton = new JButton("Week");
		thumbnailPanel.add(thumbnailEditButton);
		// adds DayGuis to the panel		
		for(Day day: week.getDays()){
			if(day==null){
				thumbnailPanel.add(new JLabel());
			}else{
				thumbnailPanel.add(day.getDayGui().getThumbnailPanel());

			}
		}
	}
	JPanel getThumbnailPanel(){
		return thumbnailPanel;
	}


}
