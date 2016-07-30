package gui;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataManigment.Worker;

public class WorkerAddGui{
	private JPanel panel = new JPanel();
	
	private JTextField name = new JTextField("name");
	private JTextField requestDaysOff = new JTextField("Days off");
	private JButton doneButton = new JButton("done");
	private JButton cancelButton = new JButton("cancel");
	private GuiControl guiControl;

	WorkerAddGui(GuiControl guiControl){
		this.guiControl = guiControl;
		
		panel.setLayout(new GridLayout(4,1));

		panel.add(name);
		panel.add(requestDaysOff);
		panel.add(doneButton);
		panel.add(cancelButton);

		addButtonActions();


	}
	void addButtonActions(){
		doneButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//the .equals has to be used because it doesn't like the == apparently
				if (!(name.getText().equals("name")) ){
					
					Worker worker = new Worker(name.getText());
					
					
					String userInput = requestDaysOff.getText();
					String [] splitArray = userInput.split(",");
					for(String date : splitArray){
						try{
							Integer tempInt = Integer.valueOf(date);	
							worker.requestOff(tempInt);
						}catch(NumberFormatException nfe){

						}
					}

					guiControl.startWorkerMainMenu();					

				}
			}
		});
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guiControl.startWorkerMainMenu();

			}
		});

	}
	JPanel getPanel(){
		return panel;
	}
}