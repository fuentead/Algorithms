package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of ints, is it possible to divide the ints 
 * into two groups, so that the sum of one group is a multiple 
 * of 10, and the sum of the other group is odd. Every int must 
 * be in one group or the other. Write a recursive helper method 
 * that takes whatever arguments you like, and make the initial 
 * call to your recursive helper from splitOdd10(). (No loops needed.)
 * 
 * splitOdd10([5, 5, 5]) → true
 * splitOdd10([5, 5, 6]) → false
 * splitOdd10([5, 5, 6, 1]) → true
 */
public class RecSplitOdd10 {
   
   /*
    * Split Odd 10 problem solved with recursion.
    * 
    * Time Complexity: O(2^n) 2 recursive calls of n times.
    * Space Complexity: O(2n) stack used recursively twice.
    */
   public static boolean recSplitOdd10Helper(int[] nums, int index, int sum1, int sum2) {
      if(index >= nums.length)
         return (sum1 % 10 == 0) && (sum2 % 2 !=0);
      
      return recSplitOdd10Helper(nums, index+1, sum1 + nums[index], sum2) || recSplitOdd10Helper(nums, index+1, sum1, sum2 + nums[index]);      
   }

   public static boolean recSplitOdd10(int[] nums) {
     if(nums.length == 0)
        return true;
     
     return recSplitOdd10Helper(nums, 0, 0, 0);
   }
  
   public static void main(String[] args) {
      int[] nums = {5, 5, 5};
      boolean res = recSplitOdd10(nums);
      System.out.println(res);
      
      int[] nums2 = {5, 5, 6};
      boolean res2 = recSplitOdd10(nums2);
      System.out.println(res2);
      
      int[] nums3 = {5, 5, 5};
      boolean res3 = recSplitOdd10(nums3);
      System.out.println(res3);
   }
}
