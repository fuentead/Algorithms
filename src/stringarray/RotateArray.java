/**
 * String/Array Problems
 */
package stringarray;

/**
 * @author adrianafuentes
 * 
 * Problem: Rotate an array to the right by k steps.
 * 
 * Example: k=3 => [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
 * 
 * Algorithm: 
 * - Divide array into two parts {1,2,3,4} and {5,6,7}
 * - Swap both individual arrays [4,3,2,1,7,6,5]
 * - Reverse whole array [5,6,7,1,2,3,4]
 */
public class RotateArray {

	public void rotateArrayKSteps(final int[] numbers, int k) {
		int size = numbers.length;
		
		// First half of array swap, from 0 to size-k
		for(int i=0; i<(size-k)/2; i++) {
			int tmp = numbers[i];
			numbers[i] = numbers[size-k-i-1];
			numbers[size-k-i-1] = tmp;
		}
		
		// Second half of array swap, from size-k to size-1
		for(int i=size-k; i<(size-Math.ceil((double)k/2)); i++) {
			int tmp = numbers[i];
			numbers[i] = numbers[size-1];
			numbers[size-1] = tmp;
		}
		
		// Swap entire array
		for(int i=0; i<size/2; i++){
			int tmp = numbers[i];
			numbers[i] = numbers[size-1-i];
			numbers[size-1-i] = tmp;
		}
	}

}
