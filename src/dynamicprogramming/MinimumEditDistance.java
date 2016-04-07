/**
 * Dynamic Programming Problems
 */
package dynamicprogramming;

/**
 * @author adrianafuentes
 * 
 * Minimum Edit Distance
 * 
 * Problem
 * -------
 * Given two strings, str1 and str2, and the following operations
 * insert, remove, replace, find the minimum number of operations
 * edits required to convert str1 to str2.
 * 
 * Algorithm
 * ---------
 * Check if str1 or stri2 are empty. If str1 is empty, copy all
 * values from str2 to str1. If str2 is empty, remove all values 
 * from str1.
 * 
 * If characters compared are same, take previous result (diagonal)
 * 
 * If characters compared are different, take the minimum of the 
 * most recent calculated values and add one.
 * 
 * Problem is resolved in a bottom up manner.
 * 
 * References: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 *
 */
public class MinimumEditDistance {

	public int findMinimumEditDistance(String str1, String str2) {
		
		// Create table to store subproblems
		int[][] T = new int[str1.length()+1][str2.length()+1];
		
		for(int i=0; i<=str1.length(); i++) {
			System.out.print("[");
			for(int j=0; j<=str2.length(); j++) {
				
				if(i==0) { // First string empty. Copy all values from str2 to str1
					T[i][j] = j;
				}
				else if(j==0) { // Second string empty. Remove all values from str1.
					T[i][j] = i;
				}
				else if(str1.charAt(i-1) == str2.charAt(j-1)) {
					T[i][j] = T[i-1][j-1]; // replace
				}
				else {
					int tmp_min = Math.min(T[i-1][j-1], // replace
										T[i-1][j]); // remove
					T[i][j] = 1 + Math.min(T[i][j-1], // insert
									tmp_min);
					
				}
				System.out.print(" " + T[i][j]);
			}
			System.out.print("]");
		}
		return T[str1.length()][str2.length()];
	}

}
