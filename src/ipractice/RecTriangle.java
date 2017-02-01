package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * A triangle made of blocks the following way:
 * 		triangle(0) = 0
 * 		triangle(1) = 1
 * 		triangle(2) = 3
 * Find out the total number of blocks given the 
 * number of rows.
 */
public class RecTriangle {

	/*
	 * Triangle problem solved with recursion.
	 * 
	 * Time Complexity: O(n).
	 * Space Complextity: O(n), stack usage during recursive calls.
	 */
	public static int triangle(int rows) {
		if(rows==0)
			return 0;
		if(rows==1)
			return 1;
		return rows + triangle(rows-1);
	}

	public static void main(String[] args) {
		int res = triangle(7);
		System.out.println(res);
	}
}
