
/**
 * @author Marcus Henke
 * Simulates a Process object. Each Process holds a 
 * priority, time needed to finish, time not processed,
 * and arrival time
 */
public class Process implements Comparable<Process>{

	private int priority; 
	private int arrivalTime;
	private int timeToFinish;
	private int timeNotProcessed;
	
	/**
	 * Constructor creates a new Process object and assigns
	 * specified priority, arrival time, and time needed to finish.
	 * @param arrivalTime
	 * @param processTime
	 * @param priority
	 */
	public Process(int arrivalTime, int processTime, int priority) {
		this.priority = priority;
		this.timeToFinish = processTime;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}
	
	/**
	 * Returns the time remaining for the process to finish
	 * @return int 
	 */
	public int getTimeRemaining() {
		return this.timeToFinish;
	}
	
	/**
	 * Returns the Process' priority
	 * @return int
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * Returns the Process' arrival time
	 * @return int
	 */
	public int getArrivalTime() {
		return this.arrivalTime;
	}
	
	/**
	 * Sets the Process' time not processed to zero
	 */
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	
	/**
	 * Decrements the Process' time remaining by one
	 */
	public void reduceTimeRemaining() {
		this.timeToFinish--;
	}
	
	/**
	 * Updates the time not processed and priority if necessary.
	 * Returns true if the priority has changed
	 * @param timeToIncrement
	 * @return boolean
	 */
	public boolean update(int timeToIncrement, int maxPriority) {
		timeNotProcessed++;
		if (timeNotProcessed >= timeToIncrement) {
			timeNotProcessed = 0;
			if ((priority < maxPriority)) {
				priority++;
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Process p) {
		// TODO Auto-generated method stub
		if (this.priority > p.priority) {
			return 1;
		}
		else if (this.priority < p.priority) {
			return -1;
		}
		else {
			if (this.arrivalTime > p.arrivalTime) {
				return -1;
			}
			else return 1;
		}
	}

	/**
	 * Returns whether the Process needs more time to finish
	 * @return boolean
	 */
	public boolean finish() {
		if (timeToFinish > 0) {
			return false;
		}
		else return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + priority; //implemented for personal testing of MaxHeapify() methods
	}

}
