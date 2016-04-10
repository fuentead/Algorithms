package sortinglists;

/**
 * Tests for Sorting List algorithms
 */

import static org.junit.Assert.*;

import java.util.*;
import java.util.Collections;

import org.junit.Test;

public class SortingListDriver {
	
	ComparableExample compEx;
	InsertionSort insertSort;
	Quicksort qsort;
	
	public SortingListDriver() {
		compEx = new ComparableExample();
		insertSort = new InsertionSort();
		qsort = new Quicksort();
	}

	@Test
	public void testComparableSortIntExample() {
		
		final int[] numbers = {9,4,2,-3,0,5};
		final int[] sortedExpected = {-3,0,2,4,5,9};
		
		compEx.sortInts(numbers);
		assertArrayEquals(sortedExpected, numbers);
	}
	
	@Test
	public void testComparableSortObjectExample() {
		
		final String[] strings = {"z","a","m","c","e","d"};
		final String[] sortedExpected = {"a","c","d","e","m","z"};
		
		compEx.sortObjects(strings);
		assertArrayEquals(sortedExpected, strings);
	}
	
	@Test
	public void testCustomObjectSort() {
		
		final List<Integer> numbers = Arrays.asList(3,4,8,5,2,7);
		final List<Integer> sortExpected = Arrays.asList(8,7,5,4,3,2);
		
		Collections.sort(numbers, new ComparatorExampleReverseOrder());
		assertEquals(numbers, sortExpected);
	}
	
	@Test
	public void testInsertionSortAlgorithm() {
		
		final List<Integer> numbers = Arrays.asList(3,4,8,5,2,7);
		final List<Integer> sortExpected = Arrays.asList(2,3,4,5,7,8);
		
		List<Integer> sortedList = insertSort.insertionSortAlgorithm(numbers);
		System.out.println(sortedList.toString());
		
		assertEquals(sortedList, sortExpected);
	}
	
	@Test
	public void testQuicksort() {
		final List<Integer> numbers = Arrays.asList(3,4,8,5,2,7);
		final List<Integer> sortExpected = Arrays.asList(2,3,4,5,7,8);
		
		List<Integer> sortedList = qsort.quicksort(numbers);
		System.out.println("Quicksort " + sortedList.toString());
		
		assertEquals(sortedList, sortExpected);
		
	}
}
