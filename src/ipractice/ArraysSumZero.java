package ipractice;

import java.util.*;


/**
 * @author Adriana Fuentes
 * 
 * ---
 * Given a set of integers, find a contiguous subset
 * whose sum is zero. There can be duplicate numbers
 * in the input.
 * --
 * 
 * Input: Integer array e.g. 5,1,2,3,7,-4
 * Output: A subset that sums to zero.
 * e.g. 1,2,-3, or -3,7,-4
 * 
 * - If there are no such subsets, then print nothing.
 * - If there are multiple such subsets, then print any one.
 * - If a matching subset is a subset of a larger matching subset,
 * then print either one.
 * - If there is a number '0' in the array, then it counts as a 
 * valid answer subarray.
 * 
 * What would be the complexity of the solution, if we were to 
 * print all subsets that sum to zero (instead of just one)?
 */
public class ArraysSumZero {
   
   public static void sumZero(int[] data) {
      if(data.length <= 1)
         return;
      
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      int currSum = 0;
      for(int i=0; i<data.length; i++) {
         currSum = currSum + data[i];
         if(map.containsKey(currSum)) {
            int j = map.get(currSum);
            printSubset(data, i, j);
         }
         else 
            map.put(currSum, i);
      }
   }
   
   private static void printSubset(int[] data, int i, int j) {
      int istart;
      int iend;
      if(i < j) {
         istart = i;
         iend = j;
      }
      else {
         istart = j;
         iend = i;
      }
      
      System.out.println("Sln: i: " + i + " j: " + j);
      for(int k=istart+1; k<=iend; k++)
            System.out.print(data[k] + " ");
      System.out.print("\n");
   }
   
   public static void printSubArray(int[] data, int istart, int iend) {
      System.out.println("Sum zero subarray index start: " + istart + " index end: " + iend);
      for(int i=istart; i<=iend; i++) 
         System.out.print(data[i] + " ");     
   }

   // Iterative solution
   // Time Complexity: O(n^2)
   // Space Complexity O(1)
   public static void sumZeroIterative(int[] data) {
      if(data.length == 0)
         return;
      
      for(int i=0; i<data.length; i++) {
         int sum = 0;
         for(int j=i; j<data.length; j++) {
            sum = sum + data[j];
            if(sum == 0) {
               for(int l=i; l<=j; l++) {
                  System.out.print(data[l] + " ");
               }
               System.out.print("\n");
            }
         }
      }
   }
   
   public static void main(String[] args) {
      System.out.println("Solution O(n)");
      int[] data = {5,1,2,-3,7,-4};
      sumZero(data);
      
      System.out.println("Iterative Solution O(n^2)");
      sumZeroIterative(data);
   }
}
