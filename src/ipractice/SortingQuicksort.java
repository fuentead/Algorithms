package ipractice;

/**
 * @author adrianafuentes
 *
 */
public class SortingQuicksort {
	
	public void QuickSort(int[] arr, int istart, int iend) {	
		
		if(istart >= iend)
			return;

		int ipivot = Partition(arr, istart, iend);		

		QuickSort(arr, istart, ipivot-1);
		QuickSort(arr, ipivot, iend);
	}
	
	private int Partition(int[] arr, int istart, int iend) {
		if(istart >= iend)
			return -1;
		
		int pivotVal = arr[istart];
		int l = istart;
		int r = iend;
		
		while(l <= r) {
			while(arr[l] < pivotVal)
				l++;
			while(arr[r] > pivotVal)
				r--;
			
			if(l <= r)
				Swap(arr, l, r);
			l++;
			r--;
		}
				
		return istart +1;
	}
	
	private void Swap(int[] arr, int leftVal, int rightVal) {
		int tmp = arr[leftVal];
		
		arr[leftVal] = arr[rightVal];
		arr[rightVal] = tmp;
	}


	public static void main(String[] args) {
		
		SortingQuicksort qsort = new SortingQuicksort();
		
		int[] arr = new int[7];
		
		arr[0] = 2;
		arr[1] = 7;
		arr[2] = 8;
		arr[3] = 6;
		arr[4] = 5;
		arr[5] = 4;
		arr[6] = 1;
		
		qsort.QuickSort(arr, 0, arr.length-1);
		
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");


	}
}
