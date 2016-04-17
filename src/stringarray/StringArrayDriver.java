/**
 * String/Array Problems
 */
package stringarray;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

/**
 * @author adrianafuentes
 *
 */
public class StringArrayDriver {
	
	RotateArray ra;

	public StringArrayDriver() {
		ra = new RotateArray();
	}
	
	@Test
	public void rotateArrayKSteps() {
		final int[] numbers = new int[]{1,2,3,4,5,6,7};
		final int[] expected = new int[]{5,6,7,1,2,3,4};
		
		int k = 3;
		ra.rotateArrayKSteps(numbers, k); 
		
		System.out.println("rotateArrayKSteps with k: " + k);
		System.out.println(Arrays.toString(numbers));
		
		assertEquals(Arrays.toString(numbers), Arrays.toString(expected));
	}

}
