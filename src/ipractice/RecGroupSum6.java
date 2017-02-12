package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array of ints, is it possible to choose a group 
 * of some of the ints, beginning at the start index, such 
 * that the group sums to the given target? However, with the 
 * additional constraint that all 6's must be chosen. 
 * (No loops needed.)
 * 
 * groupSum6(0, [5, 6, 2], 8) → true
 * groupSum6(0, [5, 6, 2], 9) → false
 * groupSum6(0, [5, 6, 2], 7) → false
 */
public class RecGroupSum6 {
   
   /*
    * Group Sum 6 problem solved with recursion.
    * 
    * Time Complexity: 2^n, number of recursive calls.
    * Space Complexity: O(n), recursive stack.
    * 
    */
   public static boolean groupSum6(int start, int[] nums, int target) {
      if(start >= nums.length)
         return target == 0;
 
      if(nums[start] == 6)
         return groupSum6(start+1, nums, target - nums[start]); 
      else
         return (groupSum6(start+1, nums, target - nums[start]) || groupSum6(start+1, nums, target));      
   }

   public static void main(String[] args) {
      int[] nums = {5, 6, 2};
      boolean res = groupSum6(0, nums, 8);
      System.out.println(res);
      
      boolean res2 = groupSum6(0, nums, 9);
      System.out.println(res2);
      
      boolean res3 = groupSum6(0, nums, 7);
      System.out.println(res3);
   }
}
