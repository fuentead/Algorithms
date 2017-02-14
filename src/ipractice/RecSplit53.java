package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array of ints, is it possible to divide the 
 * ints into two groups, so that the sum of the two groups 
 * is the same, with these constraints: all the values that 
 * are multiple of 5 must be in one group, and all the values 
 * that are a multiple of 3 (and not a multiple of 5) must 
 * be in the other. (No loops needed.)
 * 
 * split53([1, 1]) → true
 * split53([1, 1, 1]) → false
 * split53([2, 4, 2]) → true
 */
public class RecSplit53 {
   
   public static boolean recSplit53Helper(int[] nums, int index, int sum1, int sum2) {
      if(index >=nums.length)
         return (sum1 == sum2);
      
      if(nums[index] % 5 == 0)
         return recSplit53Helper(nums, index+1, sum1+nums[index], sum2);
      else if(nums[index] % 3 == 0)
         return recSplit53Helper(nums, index+1, sum1, sum2+nums[index]);
      else 
         return recSplit53Helper(nums, index+1, sum1+nums[index], sum2) || recSplit53Helper(nums, index+1, sum1, sum2+nums[index]);
   }

   public static boolean recSplit53(int[] nums) {
      if(nums.length  == 0)
         return true;
      
      return recSplit53Helper(nums, 0, 0, 0);
   }
   
   public static void main(String[] args) {
      int[] nums = {1,1};
      boolean res = recSplit53(nums);
      System.out.println(res);
      
      int[] nums2 = {1,1,1};
      boolean res2 = recSplit53(nums2);
      System.out.println(res2);
      
      int[] nums3 = {2,4,2};
      boolean res3 = recSplit53(nums3);
      System.out.println(res3);
      
   }
}
