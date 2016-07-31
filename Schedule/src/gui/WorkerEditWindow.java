package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dataManigment.Worker;



public class WorkerEditWindow{
	private JPanel panel = new JPanel();
	// worker being edited
	private Worker worker;
	//labels to desplay worker information
	private JLabel workerName = new JLabel();
	private JLabel daysOff = new JLabel();
	//text feald to entter dayoff requests into
	private  final JTextField daysOffInput = new JTextField();
	// button to add day request to worker list
	private JButton addButton = new JButton();
	// button to clear dayoff request list
	private JButton clearAllDays = new JButton();
	// button to deleat worker
	private JButton DELEATEButton = new JButton();
	// button to return user to a new instance of the WorkerMainGui
	private JButton returnButton = new JButton();
	
	//self reforenchal terms needed for the buttons to locat informarion
	
	
	/**
	 * Creates a window that Edits a susific worker information
	 * @param worker
	 * @param workerGuiControl
	 */
	WorkerEditWindow(final Worker worker){
		this.worker = worker;
		
		
		
		panel.setLayout(new GridLayout(7,1));
		
		
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
		panel.add(workerName);
		panel.add(daysOff);
		panel.add(daysOffInput);
		panel.add(addButton);
		panel.add(clearAllDays);
		panel.add(DELEATEButton);
		panel.add(returnButton);

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
				
				GuiControl.getInstence().startWorkerMainMenu();



			}

		});
		// permently deleats the worker from the worker list
		DELEATEButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				worker.remove();
				returnButton.doClick();
			}
			
		});
		}
	JPanel getPanel(){
		return panel;
	}
	}

