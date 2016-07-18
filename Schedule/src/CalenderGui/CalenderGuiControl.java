package CalenderGui;

public class CalenderGuiControl {
	public CalenderGuiControl(){
		startCalenderSettingsWindow();
		
		
	}

	protected void startCalenderMainMenu(int daysInMonth,int monthStartsOn) {
		CalenderMainMenu calenderMainMenu = new CalenderMainMenu(daysInMonth, monthStartsOn);
		
		
	}

	private void startCalenderSettingsWindow() {
		CalenderSettingsWindow calenderSettingsWindow = new CalenderSettingsWindow(this);
		
	}
}
