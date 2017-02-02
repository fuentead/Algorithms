package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a non-negative int n, return the sum of its digits recursively (no loops). 
 * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) 
 * by 10 removes the rightmost digit (126 / 10 is 12).
 * 
 * sumDigits(126) → 9
 * sumDigits(49) → 13
 * sumDigits(12) → 3
 */
public class RecSumDigits {

	/*
	 * Sum of digits solved iteratively.
	 * 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n)
	 */
	public static int sumDigitsIterative(int n) {
		int sum = 0;
		int len = String.valueOf(n).length();
			
		for(int i = 0; i<len; i++) {
			int digit = n % 10;
			n =  n/ 10;		
			sum = digit + sum;
		}
		return sum;
	}
	
	/*
	 * Sum of digits solved recursively.
	 * 
	 * Time Complexity: O(n) 
	 * Space Complexity: O(n), recursive stack usage. 
	 */
	public static int sumDigitsRec(int n) {		
		if(n==0)
			return 0;
		
		int digit = n % 10;
		int num = n / 10;
		  
		return digit + sumDigitsRec(num);
	}
	
	public static void main(String[] args) {
		int sumRec = sumDigitsRec(445);
		System.out.println("Recursive Sum: " + sumRec);
		
		int sumIter = sumDigitsIterative(445);
		System.out.println("Iterative Sum: " + sumIter);
	}

}
