/**
 * Search Algorithms
 */
package search;

import java.util.Arrays;
import java.util.List;

/**
 * @author adrianafuentes
 *
 * Binary Search
 * -------------
 * 
 * When searching, if the list is not sorted, you need to look
 * through all the values. However, binary search is very efficient
 * if you sort the list or the list is already sorted.
 * 
 * If the list is sorted, binary search throws away many elements 
 * without examining.
 * 
 * Algorithm:
 * ----------
 * Pick the middle number in the sorted list. Check if the searched 
 * value is the same as the middle number.
 * 
 * Check if value is less than middle number. If it is, recurse in 
 * lower half of list.
 * Check if value is greater than middle number. If it is, recurse in 
 * higher half of list.
 * 
 * Performance Analysis:
 * --------------------
 * Algorithm has performance of O(n).
 * 
 */
public class BinarySearch {
	
	public static boolean binarySearch(final List<Integer> numList, final Integer val) {
		
		if(numList == null || numList.isEmpty()) {
			return false;
		}
		
		final Integer midElem = numList.get(numList.size()/2);
		
		if(midElem.equals(val)) {
			return true;
		}
		
		else if(val < midElem) {
			return binarySearch(numList.subList(0, numList.size()/2), val);
		}
		else {
			return binarySearch(numList.subList(numList.size()/2 + 1, numList.size()), val);
		}		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final List<Integer> numbers = Arrays.asList(2,3,5,7,9,10,11);
		
		boolean result = binarySearch(numbers, 2);
		System.out.println("Value found: " + result);
		
		boolean result2 = binarySearch(numbers, 0);
		System.out.println("Value found: " + result2);
		
	}
}
