/**
 * 
 */
package sortinglists;

import java.util.*;

/**
 * @author adrianafuentes
 *
 * Mergesort Algorithm - Divide and Conquer algorithm.
 * 
 * Algorithm
 * ---------
 * Split list into two. Sort each sublist and merge two lists together.
 * 
 * Main code merges two sorted lists efficiently. Code holds a pointer
 * to each sublist, adds lowest value pointed to and increments pointer.
 * When pointer has reached end of list, then elements from other list
 * can be added.
 * 
 * Performance Analysis:
 * --------------------
 * O(n log n) performance. Each merge operation is O(n)
 */
public class MergeSort {

	public List<Integer> mergesortList(final List<Integer> numbers) {
		
		// Base Case - Already sorted
		if(numbers.size() == 0 || numbers.size() ==1) { 
			return numbers;
		}
		
		final List<Integer> leftList = numbers.subList(0, numbers.size()/2);
		final List<Integer> rightList = numbers.subList(numbers.size()/2, numbers.size());
		
		return merge(mergesortList(leftList), mergesortList(rightList));
	}

	private static List<Integer> merge(final List<Integer> leftList, final List<Integer> rightList) {
		int leftPtr = 0;
		int rightPtr = 0;
		
		final List<Integer> mergedList = new ArrayList<Integer>(leftList.size()+ rightList.size());
		
		while (leftPtr < leftList.size() && rightPtr < rightList.size()) {
			if(leftList.get(leftPtr) < rightList.get(rightPtr)) {
				mergedList.add(leftList.get(leftPtr));
				leftPtr++;
			}
			else {
				mergedList.add(rightList.get(rightPtr));
				rightPtr++;
			}
		}
		
		while (leftPtr < leftList.size()) {
			mergedList.add(leftList.get(leftPtr));
			leftPtr++;
		}
		
		while (rightPtr < rightList.size()) {
			mergedList.add(rightList.get(rightPtr));
			rightPtr++;
		}
		
		return mergedList;
	}
}
