/**
 * Dynamic Programming Problems
 */
package dynamicprogramming;

/**
 * @author Adriana Fuentes
 * 
 * Longest Increasing Subsequence Problem
 * 
 * Algorithm: Iterate sequence with 2 variables (i,j).
 * Variable i starts at position 1 and continues.
 * Variable j starts at position 0 and continues. It 
 * resets to 0 once i has been set to a new value.
 * 
 * Comparisson on iterations is done such that if value
 * at val[i] < val[j] and res[i] < res[i]+1, then res[i]
 * is updated with res[i]+1. Otherwise, continue.
 * 
 * At the end, the result will be the largest number at res[]
 * representing the longest increasing subsequence.
 *
 */
public class LongestIncreasingSubsequence {
	
	public int findLongestIncresingSubsequence(int[] val, int n, int[] res){
		
		int result = 0;
		
		for(int i=1; i<val.length; i++){
			for(int j=0; j<i; j++) {
				if(val[i] < val[j] && res[i] < res[j]+1)
					res[i] = res[j]+1;
			}
		}
		
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		
		int[] val = new int[]{3,4,-1,0,6,2,3};
		int[] res = new int[val.length];
		
		lis.findLongestIncresingSubsequence(val, val.length, res);

	}

}
