package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array with sorted numbers. The array
 * has been rotated an unknown number of times.
 * 
 * We need to figure out the minimum number in 
 * such an array. What would be a fast method that
 * uses only constant space?
 * 
 * Examples: 
 * Input: {5,6,1,2,3,4}
 * Output: 1
 */
public class ArraysRotatedSortedFindMinimum {

   /*
    * Traverse entire array and find minimum
    * Time Complexity - O(n)
    * Space Complexity - O(1)
    */
   public static int findMinimum(int[] data) {
      if(data.length == 0)
         return 0;
      
      int min = Integer.MAX_VALUE;
      for(int i=0; i<data.length; i++) {
         if(data[i] < min)
            min = data[i];
      }
      return min;
   }
   
   public static int findMinBinarySearch(int[] data, int ilow, int ihigh) {
      int imid = (ilow + ihigh)/2;
      
      if((ilow < imid) && (data[imid] < data[imid-1])) 
         return data[imid];
      
      if((ihigh > imid) && (data[imid] > data[imid+1]))
            return data[imid+1];
      
      if(data[ihigh] > data[imid])
         return findMinBinarySearch(data, ilow, imid-1);
      else 
         return findMinBinarySearch(data, imid+1, ihigh);
   }
   
   public static int findMinimumBinarySearch(int[] data) {
      if(data.length ==0)
         return 0;
      
      int ifirst = 0;
      int iend = data.length-1;
      int min = findMinBinarySearch(data, ifirst, iend);
      return min;
   }
   
   public static void main(String[] args) {
      int[] data = {3,4,5,6,1,2};
      
      int min = findMinimum(data);
      System.out.println("Soln 1: " + min);
      
      int min2 = findMinimumBinarySearch(data);
      System.out.println("Soln 2 - Binary Search: " + min2);
   }
}
