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
	private String workerType;
	

	/**
	 * Sets up worker's symbol
	 * @param symbol
	 */
	public Worker(String symbol,String workerType){
		
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
		
		validDateFilter(testShift.getDate());
		if(testShift.getWorkerTyp().equals("HeadGuard") && !this.workerType.equals("HeadGuard")){
			return false;
		}


		if (requestedOff.contains(testShift.getDate())) {
			return false;
		}
		for(Shift workeringShift :this.getDaysWorking()){
			if(workeringShift.getDate() == testShift.getDate()){
				return false;
			}
		}
		return true;
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

	private double calculateHoursWorking() {
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
}