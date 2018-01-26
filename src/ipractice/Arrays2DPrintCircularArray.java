package ipractice;

/*
 * @author Adriana Fuentes
 * 
 * ---
 * Print 2 dimensional array in circular way.
 * ---
 * 1  2  3  4 
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 */

public class Arrays2DPrintCircularArray {

   public static void printCircularArray(int[][] data) {
      if(data.length == 0)
         return;
      
      int n = data.length;
      int ilow = 0;
      int ihigh = n-1;
      int jlow = 0;
      int jhigh = n-1;
      int k;
      
      while (ilow<ihigh && jlow<jhigh) {
         
         for(k=jlow; k<=jhigh; k++) {
            System.out.print(data[ilow][k] + " ");
         }
         
         if(ilow+1 < ihigh-1) 
            for(k=ilow+1; k<=ihigh-1; k++) {
               System.out.print(data[k][jhigh] + " ");
            }
         
         for(k=jhigh; k>=jlow; k--) {
            System.out.print(data[ihigh][k] + " ");
         }
         
         if(ihigh-1 > ilow)
            for(k=ihigh-1; k>=ilow+1; k--) {
               System.out.print(data[k][jlow] + " ");
            }
         
         ilow  = ilow + 1;
         ihigh = ihigh -1;
         jlow  = jlow +1;
         jhigh = jhigh - 1;
      }
   }

   public static void main(String[] args) {
      int[][] data = {{1,2,3,4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10,9,8,7}};
      
      printCircularArray(data);
   }
}
