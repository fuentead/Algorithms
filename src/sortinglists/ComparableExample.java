/**
 * 
 */
package sortinglists;

import java.util.Arrays;

/**
 * Comparable example to show how it is used for natural ordering.
 * 
 * @author fuentead
 */
public class ComparableExample {
	
	/**
	 * Sort integers with natural ordering with Comparable
	 */
	public void sortInts(int[] numbers) {
		Arrays.sort(numbers);
	}
	
	/**
	 * Sort objects with natural ordering. Example is string.
	 * String implements comparable interface.
	 * If object sorted does not implement comparable, throws exception. 
	 */
	public void sortObjects(Object[] object) {
		
		try {
			Arrays.sort(object);
		}
		catch(ClassCastException e) {
			System.out.println("Object does not implement comparable");
		}
	}
	
	

}
