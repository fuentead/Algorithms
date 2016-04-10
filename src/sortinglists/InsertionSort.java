/**
 * Sorting Problems
 */
package sortinglists;

import java.util.*;

/**
 * @author adrianafuentes
 *
 */
public class InsertionSort {

	/**
	 * Insert Sort Implementation
	 * 
	 * Method returns a new linked list instance. 
	 * This is the choice of implementation.
	 * LinkedList is good choice for adding elements in the 
	 * middle of the list. 
	 * 
	 * Worst Case performance is O(n^2). If trying to sort an already
	 * sorted list, need to iterate to end of new list with element to insert.
	 * If trying to sort a reverse-order list, you will be adding each 
	 * element to the head of new list - this is O(n).
	 */

	public List<Integer> insertionSortAlgorithm(final List<Integer> numbers) {
		final List<Integer> finalSortedList = new LinkedList<>();
			
		begList: for(Integer number: numbers) {
			for(int i=0; i<finalSortedList.size(); i++) {
				if(number < finalSortedList.get(i)) {
					finalSortedList.add(i, number);
					continue begList;
				}
			}
			finalSortedList.add(finalSortedList.size(), number);
		}
		return finalSortedList;
	}
}
