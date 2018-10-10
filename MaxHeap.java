import java.util.ArrayList;

/**
 * MaxHeap class which can store any element that
 * extends Comparable
 * @author Marcus Henke
 * @param <T>
 */
public class MaxHeap<T extends Comparable<T>> {
	
	//The maxHeap is stored in an ArrayList instance variable
	private ArrayList<T> maxHeap;

	/**
	 * Constructor creates a new, empty MaxHeap.
	 */
	public MaxHeap() {
		maxHeap = new ArrayList<T>();
	}

	/**
	 * Adds object to the bottom of the MaxHeap, then
	 * MaxHeapifies up to place the object in the correct
	 * location.
	 * @param object
	 */
	public void addObject(T object) {
		maxHeap.add(object);
		
		maxHeapifyUp(maxHeap.size() - 1);
		
	}

	/**
	 * returns the object at any given index
	 * @param index
	 * @return T
	 */
	public T getObject(int index) {
		return maxHeap.get(index);
	}

	/**
	 * removes and returns the object at 
	 * the root of the tree, and MaxHeapifies down
	 * at the new root to reorder the elements.
	 * @return T
	 */
	public T removeTopObject() {
		T startTop = maxHeap.get(0);
		T startBottom = maxHeap.get(maxHeap.size() - 1);
	
		maxHeap.set(0, startBottom);
		maxHeap.remove(maxHeap.size() - 1);
		maxHeapifyDown(0);
		
		return startTop;
	}

	/**
	 * Replaces the object at the specified index
	 * with a new object
	 * @param index
	 * @param object
	 */
	public void replace(int index, T object) {
		maxHeap.set(index, object);
	}

	/**
	 * Returns the size of the MaxHeap
	 * @return int
	 */
	public int getSize() {
		return maxHeap.size();
	}

	/**
	 * MaxHeapifies Up at the specified index
	 * @param index
	 */
	public void maxHeapifyUp(int index) {
		int parent;
		if (index == 0) {
			return;
		} 
		else {
			parent = Math.floorDiv(index-1, 2);
			if (index < 0) {
				parent = 0;
			}
		}

		if (maxHeap.get(index).compareTo(maxHeap.get(parent)) > 0) {
			T switch1 = maxHeap.get(index);
			T switch2 = maxHeap.get(parent);
			maxHeap.set(index, switch2);
			maxHeap.set(parent, switch1);
			maxHeapifyUp(parent);
		}
	}
	
	/**
	 * MaxHeapifies down at the specified index
	 * @param index
	 */
	public void maxHeapifyDown(int index) {
		int leftChild = 2 * (index) + 1;
		int rightChild = 2 * (index) + 2;

		int largest;

		if ((leftChild <= maxHeap.size() - 1) && (maxHeap.get(leftChild).compareTo(maxHeap.get(index)) == 1)) {
			largest = leftChild;
		} else
			largest = index;

		if ((rightChild <= maxHeap.size() - 1) && ((maxHeap.get(rightChild)).compareTo(maxHeap.get(largest)) == 1)) {
			largest = rightChild;
		}
		if (largest != index) {
			T indexObj = maxHeap.get(index);
			T largestObj = maxHeap.get(largest);
			
			maxHeap.set(index, largestObj);
			maxHeap.set(largest, indexObj);
			
			maxHeapifyDown(largest);
		}


	}
}
