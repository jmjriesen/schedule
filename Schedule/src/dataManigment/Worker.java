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
	private Set<Integer> working = new TreeSet<Integer>();

	

	/**
	 * Sets up worker's symbol
	 * @param symbol
	 */
	public Worker(String symbol){
		
		if (symbol == null) {
            throw new NullPointerException("Worker symbol cannot be null");
        }
        else if(symbol.equals("")){
            throw new NullPointerException("Empty String (Not really null, but close enough)");
        }

		this.symbol = symbol;
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



	public void willWork(int date){
        validDateFilter(date);
		working.add(date);
	}



	/**
	 * Get the list of days this worker is currently working
	 * @return
     */
	public Set<Integer> getDaysWorking(){
		return working;
	}



	/**
	 * cheeks date against days requested off and days already working
	 * @param date
	 * @return true if available
	 */
	public boolean canWork(int date){
        validDateFilter(date);

        if (requestedOff.contains(date) || working.contains(date)) {
            return false;
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
				return wrk1.getDaysWorking().size() - wrk2.getDaysWorking().size();
			}
		};
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