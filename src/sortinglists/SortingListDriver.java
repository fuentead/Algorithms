package sortinglists;

/**
 * Tests for Sorting List algorithms
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class SortingListDriver {
	
	ComparableExample compEx;
	
	public SortingListDriver() {
		compEx = new ComparableExample();
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
}
