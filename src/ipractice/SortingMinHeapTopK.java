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
	
	public void buildHeap(int[] data) {
		for(int i=0; i<data.length; i++) {
			if(minHeap.size() < k) {
				insert(data[i]);
			}
			else {
				if(data[i] > minHeap.peek()) {
					extractMin();
					insert(data[i]);
				}
			}
		}
	}
	
	public void insert(int data) {
		if(minHeap.size() < k) 
			minHeap.offer(data);
		else {
			if( data > minHeap.peek()) {
				extractMin();
				insert(data);
			}
		}
	}
	
	public int peek() {
		return minHeap.peek();
	}
	
	public int extractMin() {
		return minHeap.poll();
	}
	
	public int getSize() {
		return minHeap.size();
	}
	
	public void showHeap() {
		System.out.print(minHeap);
	}

	public static void main(String[] args) {
		int[] data = {3,4,5,7,1};
		SortingMinHeapTopK mh = new SortingMinHeapTopK(3);
		mh.buildHeap(data);	
		mh.insert(9);
		mh.insert(15);
		mh.showHeap();
	}
}
