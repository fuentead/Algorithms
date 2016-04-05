/**
 * Dynamic Programming Problems
 */
package dynamicprogramming;

import java.util.Arrays;

/**
 * @author Adriana Fuentes
 * 
 * Longest Increasing Subsequence Problem
 * 
 * Algorithm: Iterate sequence with 2 variables (i,j).
 * Variable i starts at position 1 and continues.
 * Variable j starts at position 0 and continues. j 
 * resets to 0 once j reaches i and i has been set to 
 * a new value.
 * 
 * Comparison on iterations is done such that if value
 * at val[i] < val[j] and res[i] < res[i]+1, then res[i]
 * is updated with res[i]+1. Otherwise, continue.
 * 
 * At the end, the result will be the largest number at res[]
 * representing the longest increasing subsequence.
 * 
 * Sample:
 * ------ 
 * Val Array: [3, 4, -1, 0, 6, 2, 4]
 * Res Array: [1, 2, 1, 2, 3, 3, 4]
 * Test#1 - Longest Increasing Subsequence is x: 4
 */
public class LongestIncreasingSubsequence {
	
	public int findLongestIncreasingSubsequence(int[] val, int n, int[] res){
		
		int MaxSubsequenceNum = 0;
		
		for(int i=0; i<n; i++)
			res[i]=1;
		
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++) {
				if(val[j] < val[i] && res[i] < res[j]+1)
					res[i] = res[j]+1;
			}
		}
		
		for(int i=0; i<n; i++){
			if(MaxSubsequenceNum < res[i])
				MaxSubsequenceNum = res[i];
		}
		
		System.out.println("Res Array: " + Arrays.toString(res));
		return MaxSubsequenceNum;
	}
}
