package dataManigment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Worker implements Comparable {

	private String symbol;
	private List<Integer> requestedOff = new ArrayList<Integer>();
	public List<Integer> working = new ArrayList<Integer>();
	

	/**
	 * Setts up worker's symbol
	 * @param Symbol
	 */
	public Worker(String Symbol){
		symbol = Symbol;
	}



	/**
	 * Adds day to days requested days off
	 * @param day
	 */
	public void requestOff(int day){
		if(!requestedOff.contains(day)){
			requestedOff.add(day);
			Collections.sort(requestedOff);
		}
	}



	/**
	 * adds all days in days to requested days off
	 * @param days
	 */
	void requestOff(int[] days){
		for(int day : days){
			requestedOff.add(day);
		}
	}



	void willWork(int date){
		working.add(date);
	}

	/**
	 * Get the list of days this worker is currently working
	 * @return
     */
	public List<Integer> getDaysWorking(){
		return working;
	}

	/**
	 * cheeks date against days requested off and days already working
	 * @param date
	 * @return true if available
	 */
	boolean canWork(int date){
		boolean can = true;
		for (int day : requestedOff){
			if (day == date){
				can = false;
			}
		}
		for (int day : working){
			if (day == date){
				can = false;
			}
		}
		return can;
	}



	/**
	 * Get requested days off
	 *
	 * @return days requested off
	 */
	public List<Integer> getRequestedOff(){
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
	public int compareTo(Object arg0) {
		Worker arg = (Worker) arg0;
		return this.working.size()-arg.working.size();
	}


	public void clearDaysOff() {
		requestedOff.clear();
	}
}