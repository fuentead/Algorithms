/**
 * Data Structures
 */
package datastructures;

/**
 * @author adrianafuentes
 * 
 * Using System.arraycopy to extend an array.
 */
public class ExtendArrayExample {


	public int[] extendArrayWithArrayCopy(int[] values) {
		
		int[] newArray = new int[values.length + 3];
		System.arraycopy(values, 0, newArray, 0, values.length);
		
		values = newArray;
		values[5] = 8;
		values[6] = 9;
		values[7] = 10;
		
		return values;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
