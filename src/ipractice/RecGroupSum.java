package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of ints, is it possible to choose a group 
 * of some of the ints, such that the group sums to the given 
 * target? This is a classic backtracking recursion problem. 
 * Once you understand the recursive backtracking strategy in 
 * this problem, you can use the same pattern for many problems 
 * to search a space of choices. Rather than looking at the whole 
 * array, our convention is to consider the part of the array 
 * starting at index start and continuing to the end of the array. 
 * The caller can specify the whole array simply by passing start 
 * as 0. No loops are needed -- the recursive calls progress down 
 * the array.
 * 
 * groupSum(0, [2, 4, 8], 10) → true
 * groupSum(0, [2, 4, 8], 14) → true
 * groupSum(0, [2, 4, 8], 9) → false
 */
public class RecGroupSum {
   
   /* 
    * Solving group sum problem with recursion.
    * 
    * Time Complexity: O(2^n), 2 recursive calls of n each
    * Space Complexity: O(n) due to recursive stack
    */
   public static boolean groupSum(int start, int[] nums, int target) {
      if(target == 0)
         return true;        
      else if(start >= nums.length && target != 0) 
         return false;
      else      
         return (groupSum(start+1, nums, target - nums[start]) || groupSum(start+1, nums, target));              
   }
   
   public static void main(String[] args) {
      int[] nums = {2,4,8};
      boolean res = groupSum(0, nums, 10);
      System.out.println(res);
      
      int[] nums1 = {2,4,8};
      boolean res1 = groupSum(0, nums1, 14);
      System.out.println(res1);
      
      int[] nums2 = {2,4,8};
      boolean res2 = groupSum(0, nums2, 9);
      System.out.println(res2);
   }
}
