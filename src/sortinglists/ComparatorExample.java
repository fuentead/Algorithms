package sortinglists;

import java.util.Comparator;

/**
 * Comparator example.
 * 
 * If objects do not implement comparable interface, then a
 * comparator needs to be implemented.
 * 
 * Implement the Comparator interface to the sort method.
 * 
 * @author adrianafuentes
 */
class ComparatorExampleReverseOrder implements Comparator<Integer> {

	/*
	 * Compare method to use when object does not implement 
	 * the comparable interface.
	 * 
	 * Returns positive if v2 should be sorted after v1
	 * Returns negative if v1 should be sorted after v2
	 * Returns 0 if they are equal.
	 */
	@Override
	public int compare(Integer v1, Integer v2) {
		return v2 - v1;
	}
}

