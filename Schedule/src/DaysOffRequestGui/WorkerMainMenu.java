package DaysOffRequestGui;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import dataManigment.Worker;
import dataManigment.WorkerInfoHandaler;



public class WorkerMainMenu extends JFrame{

	// creates buttons for adding workers saving and processing on
	//to make the schedule
	JButton addWorkerButton = new JButton("Add worker");
	JButton saveButton = new JButton("save");
	JButton nextButton = new JButton("Next");

	//needed for buttons to interact with this window
	JFrame window = this;

	//link to control gui
	WorkerGuiControl workerGuiControl;


/**
 * creats a window and populates it with worker informaion
 * @param workerGuiControl
 */
	public WorkerMainMenu(final WorkerGuiControl workerGuiControl){
		this.workerGuiControl = workerGuiControl;
		//basik window mantinice
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//creats a gruid layout largenofe to encompus all worker information 
		//and some genaral purpus buttons
		setLayout(new GridLayout(workerGuiControl.workers.size() + 1 ,3));
		
		
		/*
		 *add three elements to the grid per worker(one Row)
		 *NameLabel worker name
		 *days they have requested off 
		 *and a button to edit the worker info
		 * 
		 */
		for(final Worker worker: workerGuiControl.workers){
					
			
			JLabel NameLabel = new JLabel(worker.getSymbol());
			add(NameLabel);
			
			JLabel DaysOff= new JLabel(worker.getRequestedOff().toString());
			add(DaysOff);
			
			JButton editButton = new JButton("edit");
			add(editButton);
			//assines button listener that starts the edit window
			editButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					window.dispose();
					workerGuiControl.startWorkerEditWindow(worker);
				}
			});
			
			
		}
		
		// placing buttons not relevant to a specific worker
		add(addWorkerButton);
		add(saveButton);
		add(nextButton);
		addButtonActions();
		pack(); //needed to display properly
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
				window.dispose();
				workerGuiControl.startWorkerAddGui();
			}
		});
		//relays the command to save to the workerGuiControl
		saveButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				workerGuiControl.saveStaff();
			}

		});
		// this will prosed the user to the scedual gui(not done yet)
		nextButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				saveButton.doClick();
				window.dispose();
				workerGuiControl.startCalenderGui();

			}
		});
	}
}