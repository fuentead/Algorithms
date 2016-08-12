package ipractice;

import java.util.PriorityQueue;
import java.util.*;

/**
 * @author Adriana Fuentes
 *
 *	Use a heap to merge the sorted arrays
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
	}
}
