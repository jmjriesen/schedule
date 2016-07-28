package dataManigment;


import java.util.*;


public class Worker implements Comparable<Worker> {

	private String symbol;
	private Set<Integer> requestedOff = new TreeSet<Integer>();
	private Set<Integer> working = new TreeSet<Integer>();


	/**
	 * Setts up worker's symbol
	 * @param Symbol
	 */
	public Worker(String symbol){
	    if (symbol == null) {
            throw new NullPointerException("Worker symbol cannot be null");
        }
        else if(symbol.equals("")){
            throw new NullPointerException("Empty String (Not really null, but close enough)");
        }

		this.symbol = symbol;
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



	@Override
	public int compareTo(Worker arg0) {
		return this.working.size()-arg0.working.size();
	}


	public void clearDaysOff() {
		requestedOff.clear();
	}

	private void validDateFilter(int date){
	    if (date < 1 || date > 31)
	        throw new IndexOutOfBoundsException();
    }
}