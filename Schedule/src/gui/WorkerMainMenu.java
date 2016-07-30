package gui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;



public class WorkerMainMenu{

	// creates buttons for adding workers saving and processing on
	//to make the schedule
	JButton addWorkerButton = new JButton("Add worker");
	JButton saveButton = new JButton("save");
	JButton nextButton = new JButton("Next");
	private JPanel panel = new JPanel();

	//needed for buttons to interact with this window
	

	//link to control gui
	GuiControl guiControl;


/**
 * creats a window and populates it with worker informaion
 * @param workerGuiControl
 */
	public WorkerMainMenu(final GuiControl guiControl){
		this.guiControl = guiControl;
		//basik window mantinice
		
		//creats a gruid layout largenofe to encompus all worker information 
		//and some genaral purpus buttons
		panel.setLayout(new GridLayout(guiControl.workers.size() + 1 ,3));
		
		
		/*
		 *add three elements to the grid per worker(one Row)
		 *NameLabel worker name
		 *days they have requested off 
		 *and a button to edit the worker info
		 * 
		 */
		for(final Worker worker: guiControl.workers){
					
			
			JLabel NameLabel = new JLabel(worker.getSymbol());
			panel.add(NameLabel);
			
			JLabel DaysOff= new JLabel(worker.getRequestedOff().toString());
			panel.add(DaysOff);
			
			JButton editButton = new JButton("edit");
			panel.add(editButton);
			//assines button listener that starts the edit window
			editButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					guiControl.startWorkerEditWindow(worker);
				}
			});
			
			
		}
		
		// placing buttons not relevant to a specific worker
		panel.add(addWorkerButton);
		panel.add(saveButton);
		panel.add(nextButton);
		addButtonActions();
		
		}

/**
 * adds button action liseners and the metodes that are activated when clicked 
 * for AddWorkerButton, save Button and nextbutton
 */
	void addButtonActions(){
		//desposis of this window and starts the workerAddGui
		addWorkerButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				guiControl.startWorkerAddGui();
			}
		});
		//relays the command to save to the workerGuiControl
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				guiControl.saveStaff();
			}

		});
		// this will prosed the user to the scedual gui(not done yet)
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				saveButton.doClick();
				guiControl.startCalenderSettingsWindow();

			}
		});
	}
	JPanel getPanel(){
		return panel;
	}
}