package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 */
class Data {
	int x;
	int y;
	int dist;
	
	Data (int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	public void setDistance(int dist) {
		this.dist = dist;
	}
	
	public int getDistance() {
		return dist;
	}
}

public class SortingFindNearestNeighbor {
	
	int k;	
	public SortingFindNearestNeighbor(int k) {		
		this.k = k;
	}
	
	PriorityQueue<Data> maxHeap = new PriorityQueue<Data>(1, new Comparator<Data>() {
		public int compare(Data x, Data y) {
			return x.dist - y.dist;
		}
	});
	
	public void findNearestNeighbor(Data[] data, Data p) {
		// Find Euclidean difference between the points
		for(int i=0; i<data.length; i++) {
			Double addsquares = Math.pow((p.x - data[i].x), 2) + Math.pow((p.y - data[i].y), 2);		
			int euclideanResult = (int) Math.sqrt(addsquares);
			data[i].dist = euclideanResult;
		}
		
		// Use heap to find to k. 
		// O(k) space and O(n log k) time solution
		BuildHeap(data);
		
		// Use modified quicksort to find k. 
		// Split data by two and choose the one where kth index is located
		// O(1) space and O(n log n) solution
		int ipivot = Partition(data, 0, data.length-1);
		if(ipivot < k)
			for(int i=0;i<k;i++)
				System.out.print("{" + data[i].x + "," + data[i].y + "} ");
		else
			for(int i=ipivot;i<k;i++)
				System.out.print("{" + data[i].x + "," + data[i].y + "} ");
	}
	
	public void BuildHeap(Data[] data) {
		for(int i=0; i<data.length; i++) {
			if(maxHeap.size() < k) {
				Insert(data[i]);
			}
			else {
				if(data[i].dist < maxHeap.peek().dist) {
					ExtractMin();
					Insert(data[i]);
				}
			}
		}
	}
	
	public void Insert(Data data) {
		if(maxHeap.size() < k) 
			maxHeap.offer(data);
		else {
			if( data.dist > maxHeap.peek().dist) {
				ExtractMin();
				Insert(data);
			}
		}
	}
	
	public Data Peek() {
		return maxHeap.peek();
	}
	
	public Data ExtractMin() {
		return maxHeap.poll();
	}
	
	public int GetSize() {
		return maxHeap.size();
	}
	
	public void ShowHeap() {
		System.out.println("\nHeap Result: ");
		for(Data d : maxHeap) {			
			System.out.println("{" + d.x + "," + d.y + "} with distance: " + d.dist);		
		}
	}
	
	private int Partition(Data[] data, int istart, int iend) {
		int ipivot = istart; // pivot index
		int i = istart + 1; // index for traversing array
		int p = istart; // index for elements greater and smaller than pivot

		while (i <= iend) {
			if (data[i].dist < data[ipivot].dist) {
				p++;
				Swap(data, i, p);
			}
			i++;
		}
		Swap(data, ipivot, p); // Swap pivot with value of index p
		return p; // pivot at index p
	}

	private void Swap(Data[] data, int i, int j) {
		Data tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static void main(String[] args) {
		int k=3;
		Data[] data = {new Data(7,2), new Data(3,6), new Data(4,5), new Data(19,3), new Data(8,10), new Data(17,20), new Data(30, 49)};

		SortingFindNearestNeighbor sfn = new SortingFindNearestNeighbor(k);
		sfn.findNearestNeighbor(data, new Data(5,6));
		sfn.ShowHeap();	
	}
}
