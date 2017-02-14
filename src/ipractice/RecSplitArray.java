package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array of ints, is it possible to divide the ints 
 * into two groups, so that the sums of the two groups are the 
 * same. Every int must be in one group or the other. Write a 
 * recursive helper method that takes whatever arguments you 
 * like, and make the initial call to your recursive helper 
 * from splitArray(). (No loops needed.)
 * 
 * splitArray([2, 2]) → true
 * splitArray([2, 3]) → false
 * splitArray([5, 2, 3]) → true
 */
public class RecSplitArray {
   
   /*
    * Split array problem solved with recursion.
    * 
    * Time Complexity O(2^n) since there are two choices.
    * Space Complexity, 2xn with recursive stack usage.
    */
   public static boolean recSplitArrayHelper(int[] nums, int index, int sum1, int sum2) {
      if(index >= nums.length)
         return sum1 == sum2;
      
      return recSplitArrayHelper(nums, index+1, sum1 + nums[index], sum2) || recSplitArrayHelper(nums, index+1, sum1, sum2 + nums[index]); 
   }

   public static boolean recSplitArray(int[] nums) {
      if(nums.length == 0)
         return true;
      
      return recSplitArrayHelper(nums, 0, 0, 0);         
   }
   
   public static void main(String[] args) {
      int[] nums = {2,2};
      boolean res = recSplitArray(nums);
      System.out.println(res);
      
      int[] nums2 = {2,3};
      boolean res2 = recSplitArray(nums2);
      System.out.println(res2);
      
      int[] nums3 = {5,2,3};
      boolean res3 = recSplitArray(nums3);
      System.out.println(res3);
   }
}
