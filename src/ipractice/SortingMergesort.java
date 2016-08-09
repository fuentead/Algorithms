package ipractice;

/**
 * @author Adriana Fuentes
 *
 */
public class SortingMergesort {
	
	int[] data;
	int[] aux;
	int size;
	
	public SortingMergesort(int[] data) {
		this.data = data;
		this.size = data.length;
		this.aux = new int[size];
	}
	
	public int[] Mergesort() {
		if(size < 1)
			return data;
		
		Sort(0, size-1);		
		return data;		
	}
	
	private void Sort(int low, int high) {
		if(low < high) {
			int mid = low + ((high-low))/2;

			Sort(low, mid);
			Sort(mid+1, high);
			Merge(low, mid, high);
		}
	}
	
	private void Merge(int low, int mid, int high) {
		
		// Copy data to auxiliary array
		for(int i=low; i<=high; i++)
			aux[i] = data[i];
		
		int i = low; // low index for aux
		int j = mid + 1; // high index for aux
		int k = low; // index for data array
		
		while(i <= mid && j <= high) {
			// Compare low & mid from aux to decide 
			// the smallest value that can be 
			// put first in data array
			if(aux[i] <= aux[j]) {
				data[k] = aux[i];
				i++;
			}
			else {
				data[k] = aux[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid) {
			data[k] = aux[i];
			i++;
			k++;
		}		
	}

	public void ShowData() {
		for(int i=0; i< data.length; i++)
			System.out.print(" " + data[i]);
	}
	
	public static void main(String[] args) {
		int [] data = {3, 5, 1, 8, 2, 9, 0};
		
		SortingMergesort ms = new SortingMergesort(data);
		ms.Mergesort();
		ms.ShowData();		
	}
}
