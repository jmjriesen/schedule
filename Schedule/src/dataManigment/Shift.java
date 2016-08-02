package dataManigment;

import java.util.PriorityQueue;

public class Shift implements Comparable{
	// the day the shifts Belong to 
	private Day day;
	// Worker type is used in setting priority during worker assignment
	private String workerType;
	//number of workers to be employed during this shift
	private Worker[] slots;
	// used in determining shift priority and will be used to determine how many hours someone has worked
	private double duration;

	public Shift (String workerType, int numberOfWorkers,double duration,Day day){
		// inputs from the constructor are transcribed to class variables
		this.workerType = workerType;
		this.slots= new Worker[numberOfWorkers];
		this.duration = duration;
		this.day = day;
	}
/**
 * Schedules workers to work during this shift
 */
	public void schedule() {
		//priority queue setup
		PriorityQueue<Worker> heap = new PriorityQueue<Worker>(Worker.getWorkers().size(), Worker.getDaysComparater());
		heap.addAll(Worker.getWorkers());

		// Iterates throw all slots
		for(int slotIndex = 0; slotIndex< slots.length; slotIndex++){
			fillSlot(slotIndex,heap);
		}

	}
/**
 * pulls worker from heap and assines it if it can work. If the worker can not work call recursively
 * @param slotIndex the slot to be worked on
 * @param heap the heap that workers are pulled from worker with least hours/days working first
 */
	void fillSlot(int slotIndex, PriorityQueue<Worker> heap) {
		// trying this worker
		Worker tempWorker = heap.poll();

		// heap returns null worker if it is empty
		if (tempWorker != null) {
			
			//Checks if worker can work this shift
			if (tempWorker.canWork(this)) {
				// if so assine the worker
				slots[slotIndex] = tempWorker;
				// tells the worker they will be working this shift
				tempWorker.willWork(this);

			} else {
				//recursive call if the worker can't work
				fillSlot(slotIndex, heap);
			}
			heap.add(tempWorker);
		} else {
			// if no worker can work set slot to null
			slots[slotIndex] = null;
		}
	}
	@Override
	public int compareTo(Object arg0) {
		//cast object to Shift, Shifts should only ever need to be compared to other shifts
		Shift otherShift = (Shift) arg0;
		// if Other worker is for HeadGuards and this is not give OtherWorker priority
		if (otherShift.workerType.equals("HeadGuard")&& !this.workerType.equals("HeadGuard")){
			return 1;
		}else if(!otherShift.workerType.equals("HeadGuard")&& this.workerType.equals("HeadGuard")){
			// if this is HeadGuard and the Other Worker is not give this priority
			return-1;
		}
		//if there are no HeadGuards give priority to the longer shift
		return (int)(otherShift.duration - this.duration);
	}
	public int getDate(){
		return day.getDate();
	}
	public double getDuration() {
		
		return this.duration;
	}


}
