package DaysOffRequestGui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dataManigment.Worker;



public class WorkerEditWindow extends JFrame{
	// worker being edited
	Worker worker;
	//labels to desplay worker information
	JLabel workerName = new JLabel();
	JLabel daysOff = new JLabel();
	//text feald to entter dayoff requests into
	final JTextField daysOffInput = new JTextField();
	// button to add day request to worker list
	JButton addButton = new JButton();
	// button to clear dayoff request list
	JButton clearAllDays = new JButton();
	// button to deleat worker
	JButton DELEATEButton = new JButton();
	// button to return user to a new instance of the WorkerMainGui
	JButton returnButton = new JButton();
	
	//self reforenchal terms needed for the buttons to locat informarion
	JFrame window = this;
	private WorkerGuiControl workerGuiControl;
	/**
	 * Creates a window that Edits a susific worker information
	 * @param worker
	 * @param workerGuiControl
	 */
	WorkerEditWindow(final Worker worker, WorkerGuiControl workerGuiControl){
		this.worker = worker;
		this.workerGuiControl = workerGuiControl;
		//stander window setup 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,200);
		setLayout(new GridLayout(7,1));
		setSize(200,200);
		setVisible(true);
		
		addElements();
		updateElements();
		addButtonActions();
	}

	void updateElements(){
		workerName.setText(worker.getSymbol());
		daysOff.setText(worker.getRequestedOff().toString());	
		addButton.setText("add dates");
		clearAllDays.setText("clear days");
		DELEATEButton.setText("DELEATE");
		returnButton.setText("return");
	}
	/**
	 * Adds labels, and buttons to the screen
	 */
	void addElements(){
		add(workerName);
		add(daysOff);
		add(daysOffInput);
		add(addButton);
		add(clearAllDays);
		add(DELEATEButton);
		add(returnButton);

	}
	/**
	 *  Regesters action lisseners for 
	 *  addButton
	 *  clearAllDays
	 *  Deleatutton
	 *  ReturnButton
	 */
	void addButtonActions(){
		// prosese and adds days off from text feild
		addButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String userInput = daysOffInput.getText();
				String [] splitArray = userInput.split(",");
				for(String date : splitArray){
					Integer tempInt = Integer.valueOf(date);	

					worker.requestOff(tempInt);
					updateElements();
				}
			}
		});
		//clears all daysoff the worker has requested
		clearAllDays.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				worker.clearDaysOff();
				updateElements();

			}

		});
		// returns to the main menu
		returnButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
				workerGuiControl.startWorkerMainMenu();



			}

		});
		// permently deleats the worker from the worker list
		DELEATEButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				workerGuiControl.workers.remove(worker);
				returnButton.doClick();
			}
			
		});
		}
	}

