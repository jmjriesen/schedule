package dataManigment;
import gui.DayGui;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;



/**
 * Represents an individual work day. Every day has rotations that must have
 * workers assigned to them.
 */
public class Day {
	private DayGui dayGui;
	private int date;
	private Set<Shift> shifts = new HashSet<Shift>();
	private Worker[] rotation = new Worker[3];


	/**
	 * Create Day object with the calender day equal to the
	 * value provided
	 *
	 * @param date the calender day requested
     */
	public Day(int date){
		this.date = date;
		
		dayGui  = new DayGui(this);
		this.shifts.add(new Shift("HeadGuard",2,6.5,this));
		this.shifts.add(new Shift("lifeGuard",14,7.5,this));
		this.shifts.add(new Shift("lifeGuard",2,5.5,this));
		
		
	}
	
	
	
	/**
	 * Takes fills out the rotation with workers passed to it(currently takes in order)
	 * @param potentialWorkers well of potential worker to shedual.
	 */
	
	void schedule(){
		
		//Passing command to the shift
		//order chosen by heap
		PriorityQueue<Shift> shiftHeap = new PriorityQueue<Shift>(shifts);
		Shift tempShift = shiftHeap.poll();
		
		while (tempShift != null){
			
			tempShift.schedule();
			tempShift = shiftHeap.poll();
		}
	}
	
		/*PriorityQueue<Worker> heap = new PriorityQueue<>(Worker.getWorkers().size(), Worker.getDaysComparater());
		heap.addAll(Worker.getWorkers());

		
		for(int slotIndex = 0; slotIndex< rotation.length; slotIndex++){
			fillSlot(slotIndex,heap);
		}
	}*/


	/**
	 * Select and assign a worker to work for a given rotation. A worker will be chosen
	 * to work based on if they requested a day off and on if they have already worked
	 * more hours than other workers.
	 *
	 * @param slotIndex index of the rotation to fill
	 * @param heap the heap from which to select workers
     */
	/*void fillSlot(int slotIndex, PriorityQueue<Worker> heap) {
		Worker tempWorker = heap.poll();

		if (tempWorker != null) {

			if (tempWorker.canWork(date)) {
				rotation[slotIndex] = tempWorker;
				tempWorker.willWork(date);

			} else {
				fillSlot(slotIndex, heap);
			}
			heap.add(tempWorker);
		} else {
			rotation[slotIndex] = null;
		}
	}
*/

	/**
	 * Get this days shifts
	 *
	 * @return the days shifts
     */
	public Set<Shift> getShifts() {
		return shifts;
	}
	public int getDate(){
		return date;
	}
	public DayGui getDayGui(){
		return dayGui;
	}
}
