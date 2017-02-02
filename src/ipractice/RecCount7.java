package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a non-negative int n, return the count of the occurrences of 7 
 * as a digit, so for example 717 yields 2. (no loops). Note that mod (%) 
 * by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 
 * removes the rightmost digit (126 / 10 is 12).
 */
public class RecCount7 {

	/*
	 * Count 7 solved recursively.
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n), recursive stack usage.
	 */
	public static int recCount7(int n) {
		if(n==0)
			return 0;
		
		int digit = n % 10;
		int num = n / 10;
		
		if(digit == 7)
			return 1 + recCount7(num);
		else
			return recCount7(num);	
	}

	public static void main(String[] args) {
		int res = recCount7(4787787);
		System.out.println("Count 7: " + res);
	}
}
