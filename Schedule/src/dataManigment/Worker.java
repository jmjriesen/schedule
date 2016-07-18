package dataManigment;

import java.util.ArrayList;
import java.util.Collections;



public class Worker implements Comparable {
	private String symbol;
	private java.util.List<Integer> requestedOff = new ArrayList<Integer>();
	public java.util.List<Integer> working = new ArrayList<Integer>();
	

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
	 * cheeks date agenst days requested off and days allredy working
	 * @param date
	 * @return true if avalible
	 */
	boolean canWork(int date){
		boolean can = true;
		for(int day:requestedOff){
			if (day == date){
				can = false;
			}
		}
		for(int day:working){
			if (day == date){
				can = false;
			}
		}
		return can;
	}
	/**
	 * basc get statement
	 * @return 
	 */
	public java.util.List getRequestedOff(){
		return requestedOff;
	}
	/**
	 * basic get statement
	 * @return
	 */
	public String getSymbol(){
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