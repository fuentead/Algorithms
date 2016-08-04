package ipractice;

/**
 * @author adrianafuentes
 *
 */
public class SortingQuicksort {
	
	public void QuickSort(Integer[] data) {
		QuickSort(data, 0, data.length-1);
	}
	
	public void QuickSort(Integer[] data, int istart, int iend) {
		if(istart >= iend)
			return;
		int ipivot = Partition(data, istart, iend);	
		QuickSort(data, istart, ipivot-1);
		QuickSort(data, ipivot+1, iend);
	}
	
	private int Partition(Integer[] data, int istart, int iend) {
		if(istart >= iend)
			return -1;
		int ipivot = istart;				// pivot index
		int i = istart + 1;					// index for traversing array
		int p = istart;						// index for middle element	
		
		while(i <= iend) {
			if(data[i] < data[ipivot]) {
				p++;
				Swap(data, i, p);
			}		
			i++;
		}		
		Swap(data, ipivot, p); 				// Swap pivot with value of index p
		return p; 							// pivot at index p
	}
	
	private void Swap(Integer[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static void main(String[] args) {		
		SortingQuicksort qsort = new SortingQuicksort();		
		Integer[] data = {33, 56, 20, 12, 78};
		qsort.QuickSort(data);	
		for(int i=0; i<data.length; i++)
			System.out.print(data[i] + " ");
	}
}
