/**
 * 
 */
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
	
	public void QuicksortNutsAndBolts(String[] nuts, String[] bolts, int start, int end) {		
		if(start > end)
			return;		
		int boltPivotIndex = Partition(bolts, start, end, nuts[start]);	
		int nutsPivotIndex = Partition(nuts, start, end, bolts[boltPivotIndex]);
		
		System.out.println(bolts[boltPivotIndex] + nuts[nutsPivotIndex]);
		QuicksortNutsAndBolts(nuts, bolts, start, boltPivotIndex-1);
		QuicksortNutsAndBolts(nuts, bolts, boltPivotIndex+1, end);
	}
	
	private int Partition(String[] toolA, int start, int end, String toolBPivot) {
		int i = start + 1;
		int m = start;
		String tmpValTool;		
		if(start == end)
			return end;
		
		tmpValTool = SwapTempVal(toolA, start, toolBPivot);			
		while(i <= toolA.length-1) {
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
		String[] nuts = {"N7","N4","N2","N5","N1","N6"};
		String[] bolts = {"B4", "B1", "B6", "B7", "B5", "B2"};		
		new SortingQuicksortNutsAndBolts().SortNutsAndBolts(nuts, bolts);
	}

}
