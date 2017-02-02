package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Count8 problem
 * 
 * Given a non-negative int n, compute recursively (no loops) 
 * the count of the occurrences of 8 as a digit, except that an 8 
 * with another 8 immediately to its left counts double, so 8818 
 * yields 4. Note that mod (%) by 10 yields the rightmost digit 
 * (126 % 10 is 6), while divide (/) by 10 removes the rightmost 
 * digit (126 / 10 is 12).
 */
public class RecCount8 {
	
	/*
	 * Count 8 problem solved with recursion
	 * 
	 * Time Complexity: O(n)
	 * Space Complexity: O(n), recursive stack usage
	 */
	public static int recCount8Helper(int n, boolean is8) {
		if(n == 0)
			return 0;
		
		int digit = n % 10;
		int num = n / 10;
		
		if(digit == 8 && is8)
			return 2 + recCount8Helper(num, true);
		else if(digit == 8)
			return 1 + recCount8Helper(num, true);
		else
			return recCount8Helper(num, false);
	}
	
	public static int recCount8(int n) {
		if(n == 0)
			return 0;
		
		int digit = n % 10;
		int num = n / 10;
		
		if(digit == 8)
			return 1 + recCount8Helper(num, true);
		else 
			return recCount8Helper(num, false);
	}

	public static void main(String[] args) {
		int res = recCount8(58898988);
		System.out.println(res);
	}

}
