/**
 * 
 */
package ipractice;

/**
 * @author Adriana Fuentes
 *
 */
public class SortingMinHeap {
	
	public int size;
	public int[] minHeap;
	public int pos;

	public SortingMinHeap(int size) {
		this.size = size;
		minHeap = new int[size+1];
		pos = 0;
	}
	
	public void buildHeap(int[] data) {
		if(data.length == 0)
			return;
		else {
			for(int i=0; i<data.length; i++) {
				insertHeap(data[i]);
			}
		}
	}
	
	public void insertHeap(int dataVal) {
		if(pos == 0) {
			minHeap[pos+1] = dataVal;
			pos=2;
		}
		else {
			minHeap[pos++] = dataVal;
			bubbleUpHeap();
		}
	}
	
	public void bubbleUpHeap() {
		int posTmp = pos-1;
		while(posTmp > 0 && minHeap[posTmp/2] > minHeap[posTmp]) {
			int tmp = minHeap[posTmp];
			minHeap[posTmp] = minHeap[posTmp/2];
			minHeap[posTmp/2] = tmp;
		}
	}
	
	public int extractMinHeap() {
		int minVal = minHeap[1];
		minHeap[1] = minHeap[pos-1];
		minHeap[pos-1]=0;
		pos--;
		bubbleDownHeap(1);
		return minVal;
	}
	
	public void bubbleDownHeap(int i) {
		int small = i;
		
		if (2*i < pos && minHeap[small] > minHeap[2*i]) {
			small = 2*i;
		}
		else if (2*i+1 < pos && minHeap[small] > minHeap[2*i+1]) {
			small = 2*i+1;
		}
		
		if(small != i) {
			swap(i, small);
			bubbleDownHeap(small);
		}		
	}
	
	public void swap(int a, int b) {
		int temp = minHeap[a];
		minHeap[a] = minHeap[b];
		minHeap[b] = temp;		
	}
	
	public void showHeap() {
		for(int i=0; i<minHeap.length; i++)
			System.out.print(minHeap[i] + " ");
	}

	public static void main(String[] args) {
		int[] data = {3, 8, 1, 4, 7, 2};

		SortingMinHeap mh = new SortingMinHeap(data.length);
		mh.buildHeap(data);
		mh.showHeap();	
	}

}
