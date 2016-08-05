package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dataManigment.Shift;
import dataManigment.Worker;

public class ShiftGui {
	Shift shift;
	JPanel panel = new JPanel();
	public ShiftGui(Shift shift){
		this.shift = shift;
		
		
		panel.add(new JLabel(shift.getWorkerTyp()));
		panel.add(new JLabel(Double.toString(shift.getDuration())));
		panel.setLayout(new GridLayout(shift.getSlots().length +2,1));
		for(Worker worker:shift.getSlots()){
			if (worker == null){
				panel.add(new JLabel("null"));

			}else{
		panel.add(new JLabel(worker.getSymbol()));
		}
	}
		}
	public JPanel getPanel(){
		return panel;
	}
}
