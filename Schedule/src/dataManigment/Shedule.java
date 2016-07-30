package dataManigment;


public class Shedule {

	Day[] days = new Day[4];
	

	/**
	 * makes new day instances for each day 
	 * @param Staff well of workers
	 */
	public Shedule(){
		

		for(int i = 0; i<=4 -1; i++){
			Day day = new Day(i);
			days[i] = day;

		}
	}



	/**
	 * tells each day in 'days' to fill out the rotation
	 */
	void fillOutShedual(){
		for(Day day : days){
			day.fillOutDay();
		}
	}



	/**
	 * prints to console daynumber and worker symbols for each day
	 */
	void printShedual(){
		int dayNumber = 0;
		for(Day day : days){
			System.out.println("Day"+ dayNumber);

			for (Worker worker : day.getRotation()){
				if (worker !=null){
					System.out.print(worker.getSymbol());
				}
			}
			System.out.println("");
			dayNumber ++;
			
		}
	}

}
