package dataManigment;

public class Shift {
	private String workerType;
	private Worker[] slots;
	private double duration;
	
	public void Shift(String workerType, int numberOfWorkers,double duration){
		this.workerType = workerType;
		this.slots= new Worker[numberOfWorkers];
		this.duration = duration;
	}
	

}
