package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Bunnies standing in line, numbered 1, 2, 3 ...
 * Even bunnies have 2 ears and odd bunnies have 3
 * Count the total number of ears for the bunnies.
 */
public class RecBunnyEars {

	/*
	 * Counting numbers of bunnies ears with recursion.
	 * 
	 * Time Complexity: O(n).
	 * Space Complexity: O(n) since using the stack space
	 * for recursive calls.
	 */
	public static int recursionBunnyEars(int n) {
		  int res =0;
		  
		  if(n == 0)
		    return 0;
		  if(n % 2 == 0)
		    res = 3;
		  if(n % 2 != 0)
		    res = 2;
		  
		  return res + recursionBunnyEars(n-1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int res = recursionBunnyEars(4);
		System.out.println(res);
	}
}
