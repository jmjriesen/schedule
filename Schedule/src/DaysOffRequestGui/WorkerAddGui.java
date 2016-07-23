package DaysOffRequestGui;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import dataManigment.Worker;

public class WorkerAddGui extends JFrame{
	JFrame window = this;

	private JTextField name = new JTextField("name");
	private JTextField requestDaysOff = new JTextField("Days off");
	private JButton doneButton = new JButton("done");
	private JButton cancelButton = new JButton("cancel");
	private WorkerGuiControl workerGuiControl;

	WorkerAddGui(WorkerGuiControl workerGuiControl){
		this.workerGuiControl = workerGuiControl;
		setSize(400,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		setLayout(new GridLayout(4,1));

		add(name);
		add(requestDaysOff);
		add(doneButton);
		add(cancelButton);

		addButtonActions();


	}
	void addButtonActions(){
		doneButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//the .equals has to be used because it doesn't like the == apparently
				if (!(name.getText().equals("name")) ){
					
					Worker worker = new Worker(name.getText());
					workerGuiControl.workers.add(worker);
					
					String userInput = requestDaysOff.getText();
					String [] splitArray = userInput.split(",");
					for(String date : splitArray){
						try{
							Integer tempInt = Integer.valueOf(date);	
							worker.requestOff(tempInt);
						}catch(NumberFormatException nfe){

						}
					}

					window.dispose();
					workerGuiControl.startWorkerMainMenu();					

				}
			}
		});
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
				workerGuiControl.startWorkerMainMenu();

			}
		});

	}
}