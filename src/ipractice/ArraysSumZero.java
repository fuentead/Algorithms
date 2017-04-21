package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Given a set of integers, find a contiguous subset
 * whose sum is zero. There can be duplicate numbers
 * in the input.
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
   
   static class Result {
      boolean isZero;
      int iend;
      Result(boolean isZero, int index) {
         this.isZero = isZero;
         this.iend = index;
      }
   }
   
   // Recursive solution
   // Time Complexity: O(n)
   // Space Complexity: O(1)
   public static void sumZero(int[] data) {
      if(data.length == 0)
         return;

      for(int i=0; i<data.length; i++) {
         Result res = sumZeroHelper(data, i, data[i]);
         
         if((res.iend < data.length) && res.isZero) {
            for(int j=i; j<=res.iend; j++) 
               System.out.print(data[j] + " ");            
            System.out.print("\n");
         }
      }
   }
   
   public static Result sumZeroHelper(int[] data, int index, int sum) {
      if(sum == 0) 
         return new Result(true, index);
      
      if(index == data.length-1)
         return new Result(false, index);
      
      return sumZeroHelper(data, index+1, sum + data[index+1]);
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
      System.out.println("Recursive Solution");
      int[] data = {5,1,2,-3,7,-4};
      sumZero(data);
      
      System.out.println("Iterative Solution");
      sumZeroIterative(data);
   }
}
