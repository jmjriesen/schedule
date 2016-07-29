package CalenderGui;

import javax.swing.JFrame;

public class CalenderGuiControl extends JFrame{
	public CalenderGuiControl(){
		setSize(600,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		
		startCalenderSettingsWindow();
		
		
	}

	protected void startCalenderMainMenu(int daysInMonth,int monthStartsOn) {
		MonthGui monthGui = new MonthGui(daysInMonth, monthStartsOn);
		this.add(monthGui.getMonthDesplay());
		
	}

	private void startCalenderSettingsWindow() {
		CalenderSettingsWindow calenderSettingsWindow = new CalenderSettingsWindow(this);
		
	}
}
