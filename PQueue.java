
/**
 * Priority Queue that uses a MaxHeap to determine
 * the order of elements
 * @author Marcus Henke
 */
public class PQueue {
	
	private MaxHeap<Process> maxHeap;
	
	/**
	 * Constructor creates a new MaxHeap object. 
	 */
	public PQueue() {
		maxHeap = new MaxHeap<Process>();
	}
	
	/**
	 * Places the specified element in the Queue
	 * @param p
	 */
	public void enPQueue(Process p) {
		maxHeap.addObject(p);
	}
	
	/**
	 * Removes the element at the top of the Queue
	 * @return Process
	 */
	public Process dePQueue() {
		Process p1 = maxHeap.removeTopObject();
		p1.resetTimeNotProcessed();
		return p1;
	}
	
	/**
	 * Updates all elements inside the Queue
	 * @param timeToIncrement
	 * @param maxPriority
	 */
	public void update(int timeToIncrement, int maxPriority) {
		int size = maxHeap.getSize();
		for (int i = 0; i < size; i++) {
			Process p = maxHeap.getObject(i);
			if (p.update(timeToIncrement, maxPriority)) {
				maxHeap.replace(i, p);
				maxHeap.maxHeapifyUp(i);
			}
			else {
				maxHeap.replace(i, p);
			}
		}
		
	}
	
	/**
	 * Returns whether the Queue is empty
	 * @return boolean
	 */
	public boolean isEmpty() {
		int size = maxHeap.getSize();
		
		if (size == 0) {
			return true;
		}
		else return false;
	}
}
