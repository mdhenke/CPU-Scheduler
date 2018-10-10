import java.util.Random;

/**
 * Generates Processes at a specified rate
 * @author Marcus Henke
 */
public class ProcessGenerator {
	private double arrivalRate;
	private Random rand;
	
	/**
	 * Constructor creates a new ProcessGenerator. 
	 * @param arrivalRate
	 */
	public ProcessGenerator(double arrivalRate) {
		this.arrivalRate = arrivalRate;
		rand = new Random();
	}
	
	/**
	 * Creates a new Process with specified maximum priority,
	 * maximum process time and the current time in the simulation.
	 * @param currentTime
	 * @param maxProcessTime
	 * @param maxPriority
	 * @return
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriority) {
		int priorityLevel = rand.nextInt(maxPriority) + 1;
		int timeToFinish = rand.nextInt(maxProcessTime) + 1; //can't be zero
		return new Process(currentTime, timeToFinish, priorityLevel);
	}
	
	/**
	 * Queries the random generator and returns true if the
	 * value is within the arrival rate.
	 * @return boolean
	 */
	public boolean query() {
		if (rand.nextDouble() <= arrivalRate) {
			return true;
		}
		else return false;
	}
	
}
