package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalenderSettingsWindow{
	GuiControl guiControl;
	
	JLabel numberOfDaysLabel = new JLabel("NumberOfDaysInMonth");
	JTextField numberOfDaysTextField = new JTextField();
	JComboBox comboBox = new JComboBox();
	JButton nextButton = new JButton("next");
	private JPanel panel = new JPanel();
	
	protected CalenderSettingsWindow(final GuiControl guiControl) {
		this.guiControl = guiControl;
		
		panel.setLayout(new GridLayout(2,1));
		
		
		comboBox.addItem("Sunday");
		comboBox.addItem("Monday");
		comboBox.addItem("Tuesday");
		comboBox.addItem("Wednesday");
		comboBox.addItem("Thursday");
		comboBox.addItem("Friday");
		comboBox.addItem("Saturday");
		
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					
				
				int monthStartsOn = 0 ;
				switch((String) comboBox.getSelectedItem()){
				case "Sunday": monthStartsOn = 0;
				break;
				
				case "Monday": monthStartsOn = 1;
				break;
				
				case "Tuesday": monthStartsOn = 2;
				break;
				
				case "Wednesday": monthStartsOn = 3;
				break;
				
				case "Thursday": monthStartsOn = 4;
				break;
				
				case "Friday": monthStartsOn = 5;
				break;
				
				case "Saturday": monthStartsOn = 6;
				break;

				}
				try{
					Integer daysInMonth = Integer.valueOf(numberOfDaysTextField.getText());
					guiControl.startCalenderMainMenu(daysInMonth, monthStartsOn);
				}
				catch(NumberFormatException nfe){

				}
			}

		});
		panel.add(numberOfDaysLabel);
		panel.add(numberOfDaysTextField);
		panel.add(comboBox);
		panel.add(nextButton);
		
		
	}
	JPanel getPanel(){
		return panel;
	}

}
