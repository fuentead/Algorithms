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
	IsomorphicString is;

	public StringArrayDriver() {
		ra = new RotateArray();
		is = new IsomorphicString();
	}
	
	@Test
	public void testrotateArrayKSteps() {
		final int[] numbers = new int[]{1,2,3,4,5,6,7};
		final int[] expected = new int[]{5,6,7,1,2,3,4};
		
		int k = 3;
		ra.rotateArrayKSteps(numbers, k); 
		
		System.out.println("rotateArrayKSteps with k: " + k);
		System.out.println(Arrays.toString(numbers));
		
		assertEquals(Arrays.toString(numbers), Arrays.toString(expected));
	}

	@Test
	public void testIsomorphicString() {
		String s = "mimi";
		String t = "lulu";		
		boolean result = is.checkIfStringIsomorphic(s, t);		
		System.out.println("Test 1 Isomorphic Strings " + result);
		assertEquals(true, result);
		
		String k = "miiisoo";
		String v = "luuucya";
		boolean result2 = is.checkIfStringIsomorphic(k, v);	
		System.out.println("Test 1 Isomorphic Strings " + result2);		
		assertEquals(false, result2);
		
		String m = "miiisoo";
		String p = "luuucyya";
		boolean result3 = is.checkIfStringIsomorphic(m, p);	
		System.out.println("Test 1 Isomorphic Strings " + result2);		
		assertEquals(false, result3);
		
	}
}
