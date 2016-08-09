package ipractice;

import java.util.PriorityQueue;

/**
 * @author Adriana Fuentes
 *
 */
public class SortingMinHeapTopK {

	PriorityQueue<Integer> minHeap;
	int k;
	
	public SortingMinHeapTopK(int k) {
		minHeap = new PriorityQueue<Integer>();
		this.k = k;
	}
	
	public void BuildHeap(int[] data) {
		for(int i=0; i<data.length; i++) {
			if(minHeap.size() < k) {
				Insert(data[i]);
			}
			else {
				if(data[i] > minHeap.peek()) {
					ExtractMin();
					Insert(data[i]);
				}
			}
		}
	}
	
	public void Insert(int data) {
		if(minHeap.size() < k) 
			minHeap.offer(data);
		else {
			if( data > minHeap.peek()) {
				ExtractMin();
				Insert(data);
			}
		}
	}
	
	public int Peek() {
		return minHeap.peek();
	}
	
	public int ExtractMin() {
		return minHeap.poll();
	}
	
	public int GetSize() {
		return minHeap.size();
	}
	
	public void ShowHeap() {
		System.out.print(minHeap);
	}

	public static void main(String[] args) {
		int[] data = {3,4,5,7,1};
		SortingMinHeapTopK mh = new SortingMinHeapTopK(3);
		mh.BuildHeap(data);	
		mh.Insert(9);
		mh.Insert(15);
		mh.ShowHeap();
	}
}
