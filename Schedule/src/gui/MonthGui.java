package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dataManigment.Month;
import dataManigment.Week;


public class MonthGui {
	protected Month month;
	private WeekGui[] weekGuis;


	private JPanel monthDesplay;


	public MonthGui(final Month month) {

		//month that is to be despladed
		this.month = month;

		//creating Weekguis for each week in month
		weekGuis = new WeekGui[month.getWeeks().length];
		for (int index = 0; index<month.getWeeks().length; index++){
			if (month.getWeeks()[index] != null){
				weekGuis[index] = new WeekGui(month.getWeeks()[index]); 
			}
		}



		monthDesplay = new JPanel();
		//the plus two is for the top and bottom labels
		monthDesplay.setLayout(new GridLayout(weekGuis.length + 2 ,1));
		addFirstRow();








		for (WeekGui weekgui : weekGuis){
			monthDesplay.add(weekgui.getThumbnailPanel());

		}
		JButton sheduleButton = new JButton("Shedule");
		
		monthDesplay.add(sheduleButton);
		
		
		
		sheduleButton.addActionListener(new ActionListener(){
			
			
			@Override
			public  void actionPerformed(ActionEvent arg0) {
				
				month.schedule();
				
				
			}
			
		});
		

	}

	private void addFirstRow() {
		JPanel firstRow = new JPanel();
		firstRow.setLayout(new GridLayout(1,8));
		JButton editMonthButton = new JButton("Edit");
		editMonthButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GuiControl.getInstence().startCalenderSettingsWindow();				
			}

		});
		firstRow.add(editMonthButton);
		firstRow.add(new JLabel("Sunday"));
		firstRow.add(new JLabel("Monday"));
		firstRow.add(new JLabel("Tusday"));
		firstRow.add(new JLabel("Wendnesday"));
		firstRow.add(new JLabel("Thrusday"));
		firstRow.add(new JLabel("Friday"));
		firstRow.add(new JLabel("Saterday"));

		this.monthDesplay.add(firstRow);





	}

	protected JPanel getMonthDesplay(){
		return monthDesplay;
	}

}
