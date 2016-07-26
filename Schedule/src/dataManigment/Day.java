package dataManigment;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;



public class Day {


	private int date;
	private Worker[] rotation = new Worker[3];


	public Day(int date){
		this.date = date;
	}
	
	
	
	/**
	 * Takes fills out the rotation with workers passed to it(currently takes in order)
	 * @param potentialWorkers well of potential worker to shedual.
	 */
	void fillOutDay(java.util.List<Worker> potentialWorkers){
		//Collections.shuffle(potentialWorkers);
		PriorityQueue<Worker> heap = new PriorityQueue<Worker>(potentialWorkers);
		
		for(int slotIndex = 0; slotIndex< rotation.length; slotIndex++){
			fillSlot(slotIndex,heap);
		}
	}



	void fillSlot(int slotIndex, PriorityQueue<Worker> heap) {
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

}
