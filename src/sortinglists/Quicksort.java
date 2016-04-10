/**
 * Sorting Problems
 */
package sortinglists;

import java.util.*;

/**
 * @author adrianafuentes
 * 
 * Quicksort algorithm example
 *
 * Base Case: 
 * ---------
 * List contains 0 or 1 element, already sorted.
 * 
 * Algorithm:
 * ---------
 * Choose a pivot element. Remaining element are 
 * separated into two: those lower than pivot and those 
 * higher than pivot. Method is called recursively in 
 * both lists until reaches the base case.
 * 
 * Performance Analysis:
 * --------------------
 * Average Performance: Separation of elements into two list is O(n).
 * Each recursive call for each side of the list is O(n log n).
 * 
 * Worst Case Performance: It is O(n^2). Choice of pivot can make a 
 * difference.
 * 
 * Each recursive call is independent of any other sorting necessary,
 * and could be performed in parallel.
 */
public class Quicksort {

	public List<Integer> quicksort(List<Integer> numbers) {
		
		// Base Case : List already sorted
		if(numbers.size() == 0 || numbers.size()==1) {
			return numbers;
		}
		
		// Algorithm
		int pivotIndex = numbers.size()/2;
		final Integer pivot = numbers.get(pivotIndex);
		final List<Integer> lowList = new ArrayList<>();
		final List<Integer> highList = new ArrayList<>();
		
		for(int i=0; i < numbers.size(); i++){
			if(i==pivotIndex)
				continue;
			if(numbers.get(i) < pivot) {
				lowList.add(numbers.get(i));
			}
			else {
				highList.add(numbers.get(i));
			}
		}
		
		final List<Integer> sortedList = quicksort(lowList);
		
		sortedList.add(pivot);
		sortedList.addAll(quicksort(highList));
		
		return sortedList;
	}
	
}
