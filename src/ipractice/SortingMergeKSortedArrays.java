package ipractice;

import java.util.PriorityQueue;
import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given K sorted arrays of size N each, merge them and 
 * print the sorted output. Assume N is very large
 * compared to K. N may not even be known. i.e. the arrays
 * could be just sorted streams, e.g. timestamp streams.
 * 
 * Input: K=3, N=4
 * arr[][] = {{1,3,5,7},{2,4,6,8},{0,9,10,11}}
 * 
 * First parameter: How many arrays. 
 * Second parameter: Length of each array.
 * 
 * Output: 0 1 2 3 4 5 6 7 8 9 10 11
 * Repeats are allowed.
 * Negative numbers and zeros are allowed.
 * Assume all arrays are sorted in the same order.
 *
 *	Use a heap to merge the sorted arrays.
 */
public class SortingMergeKSortedArrays {
	
	static List<Integer> resArr;
	PriorityQueue<Integer> minHeap;
	
	private void Init(int k, int n) {
		resArr = new ArrayList<Integer>();
		minHeap = new PriorityQueue<Integer>();
	}

	public void MergeSortedArrays(int [][] data, int k, int n) {
		Init(k,n);
		
		// indexes in arrays
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				minHeap.add(data[j][i]);
				if(minHeap.size() == k){
					resArr.add(minHeap.poll());
				}					
			}			
		}
		
		for(int j=0; j<k-1; j++) {
			resArr.add(minHeap.poll());
		}
		
		System.out.println(resArr);
	}
	

	public static void main(String[] args) {
		SortingMergeKSortedArrays mka = new SortingMergeKSortedArrays();
		
		int [][] data = {{1,3,5,7}, {2,4,6,8}, {5,9,13,16}};
		mka.MergeSortedArrays(data, 3, 4);		
		
		int[][] data2 = {{-1,-3,-5,-7},{-2,-6,-8,-10}};
		mka.MergeSortedArrays(data2, 2, 4);
	}
}
