package dataManigment;



import java.util.*;


public class Worker {

	private static Set<Worker> workers = new HashSet<Worker>();
	
	/**
	 * @return the workers
	 */
	public static Set<Worker> getWorkers() {
		return workers;
	}


	private String symbol;
	private Set<Integer> requestedOff = new TreeSet<Integer>();
	private Set<Shift> working = new HashSet<Shift>();
	
	public static int HeadGuard = 0;
	public static int LifeGuard = 1;
	public static String workerTypeTranslater(int workerType){
		switch ((int)workerType){
		case 0: return "HeadGuard";
		case 1: return "LifeGuard";
		}
		return "Unsuported Type";
	}

	private int workerType;
	

	/**
	 * Sets up worker's symbol
	 * @param symbol
	 */
	public Worker(String symbol,int workerType){
		
		if (symbol == null) {
            throw new NullPointerException("Worker symbol cannot be null");
        }
        else if(symbol.equals("")){
            throw new NullPointerException("Empty String (Not really null, but close enough)");
        }

		this.symbol = symbol;
		this.workerType = workerType;
		workers.add(this);
		
	}



	/**
	 * Adds day to days requested days off
	 * @param day
	 */
	public void requestOff(int day){
        validDateFilter(day);

		requestedOff.add(day);
	}



	/**
	 * adds all days in days to requested days off
	 * @param days
	 */
	public void requestOff(int[] days){
		for(int day : days){
			requestedOff.add(day);
		}
	}



	public void willWork(Shift shift){
        validDateFilter(shift.getDate());
		working.add(shift);
	}



	/**
	 * Get the list of days this worker is currently working
	 * @return
     */
	public Set<Shift> getDaysWorking(){
		return working;
	}



	/**
	 * cheeks date against days requested off and days already working
	 * @param date
	 * @return true if available
	 */
	public boolean canWork(Shift testShift){
		
		boolean canwork = true;
		validDateFilter(testShift.getDate());
		//Shift is for head Guards
		if(testShift.getWorkerTyp()== Worker.HeadGuard){
			if (this.workerType != Worker.HeadGuard){
				canwork = false;
			}
		}
		
		//Shift is for LifeGuards this includes Head Guards
		if(testShift.getWorkerTyp()==Worker.LifeGuard){
			//LifeGuard or HeadGuard
			if(this.workerType != Worker.HeadGuard && this.workerType != Worker.LifeGuard)
				canwork = false;
		}


		if (requestedOff.contains(testShift.getDate())) {
			canwork = false;
		}
		
		for(Shift workeringShift :this.getDaysWorking()){
			if(workeringShift.getDate() == testShift.getDate()){
				canwork  = false;
			}
		}
		return canwork;
	}



	/**
	 * Get requested days off
	 *
	 * @return days requested off
	 */
	public Set<Integer> getRequestedOff(){
		return requestedOff;
	}



	/**
	 * Get the symbol assigned to this worker
	 *
	 * @return the symbol assigned to this worker
	 */
	public String getSymbol() {
		return symbol;
	}


	/**
	 * Get comparator for comparing workers with respect to the number of
	 * days each worker has woerked
	 *
	 * @return comparator for comparing workers with repect to days worked
     */
	static public Comparator<Worker> getDaysComparater(){
		return new Comparator<Worker>() {

			/**
			 * Compare workers with respect to the days worked
			 *
			 * @param wrk1 first worker to compare
			 * @param wrk2 second worker to compare
             * @return positive if worker 1 has worked more days, negative if worker 2 has worked more days
             */
			@Override
			public int compare(Worker wrk1, Worker wrk2) {
				return (int)(wrk1.calculateHoursWorking() - wrk2.calculateHoursWorking());
			}
		};
	}

	public double calculateHoursWorking() {
		double hours = 0;
		for (Shift shift : working){
			hours +=shift.getDuration();
		}
		return hours;
	}



	public void clearDaysOff() {
		requestedOff.clear();
	}

	private void validDateFilter(int date){
	    if (date < 1 || date > 31)
	        throw new IndexOutOfBoundsException();
	    
    }
	public void remove(){
		workers.remove(this);
	}



	public int getType() {
		
		return this.workerType;
		
	}



	public void setType(int workerType) {
		this.workerType = workerType;
		
	}
}