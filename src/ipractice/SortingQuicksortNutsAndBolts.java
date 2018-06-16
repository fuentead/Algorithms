package ipractice;

/**
 * @author Adriana Fuentes
 */
public class SortingQuicksortNutsAndBolts {

	public void SortNutsAndBolts(String[] nuts, String[] bolts) {
		if(nuts.length == 1)
			return;		
		QuicksortNutsAndBolts(nuts, bolts, 0, nuts.length-1);
	}
	
   /*
    * Quicksort method for nuts and bolts
    * 
    * Time Complexity: Quicksort complexity n log n
    * 
    * 
    * Space Complexity:
    * 
    * 
    * 1. Partition first bolts first by taking the nuts first element as the pivot.
    * 2. From the partitioning of bolts, get the middle element and use it as the pivot for nuts
    * 3. Partition nuts by taking the bolts 'm' element as the pivot.
    * 4. Use the bolts pivot to do quicksort again from the 'start' to 'boltPivotIndex'-1, to the 
    * 'boltPivotIndex'+1 to 'end'
    */
	public void QuicksortNutsAndBolts(String[] nuts, String[] bolts, int start, int end) {		
		if(start > end)
			return;		
		int boltPivotIndex = Partition(bolts, start, end, nuts[start]);	
		int nutsPivotIndex = Partition(nuts, start, end, bolts[boltPivotIndex]);
		
		System.out.println(bolts[boltPivotIndex] + nuts[nutsPivotIndex]);
		QuicksortNutsAndBolts(nuts, bolts, start, boltPivotIndex-1);
		QuicksortNutsAndBolts(nuts, bolts, boltPivotIndex+1, end);
	}
	
	/*
	 * Partition is a log n operation.
	 * 
	 * 'i' index to iterate toolA
	 * 'm' index to swap any elements less than the pivot
	 * 'toolA' is either nuts or bolts passed in. 
	 * 'start' is the index that will be started at.
	 * 'end' is the index that will be ended.
	 * 'tmpValTool' is a variable to hold the start element of toolA. ToolB pivot will go in its place.
	 * 
	 * Iterate through array A and:
	 * 1) Compare if the index 'i' at toolA is less than the pivot
	 *      If value at 'i' is less than pivot, increase 'm' and swap with 'i', then increase 'i'
	 * 2) Compare if value at 'i' is equal to the pivot
	 *      If value is equal, then swap element at 'i' with value from toolA stored at tmpValTool
	 * 3) Otherwise, increase i
	 * 
	 * After completing iteration in toolA, swap value at start index with 'm'
	 * Also, swap 'm' with 'tmpValTool'
	 */
	private int Partition(String[] toolA, int start, int end, String toolBPivot) {
		int i = start + 1; // index to iterate in array
		int m = start;     // index to swap with any element that is less
		String tmpValTool;		
		if(start == end)
			return end;
		
		tmpValTool = SwapTempVal(toolA, start, toolBPivot);			
		while(i < toolA.length) {
			if((int) toolA[i].charAt(1) < (int) toolBPivot.charAt(1)) {// Value is less than pivot
				m++;
				Swap(toolA, i, m);	
				i++;
			}
			else if((int) toolA[i].charAt(1) == (int) toolBPivot.charAt(1)) {// Value is same as pivot
				 tmpValTool = SwapTempVal(toolA, i, tmpValTool);				 
			}
			else {
				i++;				
			}
		}	
		Swap(toolA, start, m);
		SwapTempVal(toolA, m, tmpValTool);
		return m;
	}
	
	private String SwapTempVal(String[] toolA, int index, String val) {
		String tmp = toolA[index];
		toolA[index] = val;
		return tmp;
	}
	
	private void Swap(String[] tool, int i, int m) {
		if(i==m)
			return;
		String tmp = tool[i];
		tool[i] = tool[m];
		tool[m] = tmp;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] nuts = {"N3","N4","N2","N5","N1","N6"};
		String[] bolts = {"B4", "B1", "B6", "B3", "B5", "B2"};		
		new SortingQuicksortNutsAndBolts().SortNutsAndBolts(nuts, bolts);		
	}

}
