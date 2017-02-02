package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given base and n that are both 1 or more, compute recursively 
 * (no loops) the value of base to the n power, so powerN(3, 2) 
 * is 9 (3 squared).
 * 
 * powerN(3, 1) → 3
 * powerN(3, 2) → 9
 * powerN(3, 3) → 27
 */
public class RecPowerN {

	/*
	 * Power n solved with recursion
	 * 
	 * Time Complexity: O(n)
	 * Space Complextity: O(n), recursive calls
	 */
	public static int RecPowerN(int base, int n) {
		if(n == 0)
			return 1;
		
		return base * RecPowerN(base, n-1);
	}
	
	public static void main(String[] args) {
		int res = RecPowerN(3, 2);
		System.out.println(res);
	}
}
