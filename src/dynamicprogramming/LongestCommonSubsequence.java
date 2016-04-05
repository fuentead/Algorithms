/**
 * Dynamic Programming Problems
 */
package dynamicprogramming;

/**
 * @author Adriana Fuentes
 *
 * Longest Common Subsequence Problem
 * 
 * Problem
 * ------- 
 * Given two sequences, find the longest
 * common subsequence in both of them.
 * 
 * Algorithm
 * ---------
 * Problem will be solved with tabulation 
 * in a bottom up fashion.
 * 
 * Two sequences, Seq1 and Seq2, will be 
 * compared from first element to last element
 * and in the process a table will be created
 * where the last element will be our answer.
 * 
 * For example, if we have Seq1 = {a, b, c, d, a, f} 
 * and Seq2 = {a, c, b, c, f}, we will create
 * the following table with the following results.
 * Start with Seq2 moving element by element and 
 * comparing with all elements of Seq1 if they are 
 * equal, increase the value of the max found before.
 * 
 *     a b c d a f
 *     0 0 0 0 0 0
 * a 0 1 1 1 1 1 1 
 * c 0 1 1 2 2 2 2
 * b 0 1 2 2 2 2 2
 * c 0 1 2 3 3 3 3 
 * f 0 1 2 3 3 3 4
 * 
 * Result is 4. To find the resulting Sequence, start
 * at 4 and find the previous element upward. If in that
 * step, the letter was found equal and an increase number
 * was achieved, that is the element is included.
 * 
 * For this example, the result of the longest common
 * subsequence is a,b,c,f
 * 
 * The equation for this problem is:
 * if(Seq1[i]==Seq2[j])
 * 		T[i][j] = T[i-1][j-1] + 1;
 * else
 * 		T[i][j] = max(T[i-1][j], T[i][j-1]);
 */
public class LongestCommonSubsequence {

	public int findLongestCommonSubsequence(char[] Seq1, char[] Seq2) {
		int[][] T = new int[Seq1.length+1][Seq2.length+1];
		int max = 0;
		
		for(int i=1; i<T.length; i++) {
			for(int j=1; j<T[i].length; j++){
				if(Seq1[i-1] == Seq2[j-1])
					T[i][j] = T[i-1][j-1] + 1;
				else
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				
				if(T[i][j] > max){
					max = T[i][j];
				}
			}
		}		
		return max;
	}
}
