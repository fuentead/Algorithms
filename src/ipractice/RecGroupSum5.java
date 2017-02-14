package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of ints, is it possible to choose a group of 
 * some of the ints, such that the group sums to the given target 
 * with these additional constraints: all multiples of 5 in the 
 * array must be included in the group. If the value immediately 
 * following a multiple of 5 is 1, it must not be chosen. 
 * (No loops needed.)
 * 
 * groupSum5(0, [2, 5, 10, 4], 19) → true
 * groupSum5(0, [2, 5, 10, 4], 17) → true
 * groupSum5(0, [2, 5, 10, 4], 12) → false
 */
public class RecGroupSum5 {

   public static boolean recGroupSum5Helper2(int start, int[] nums, int target, boolean isMult5, boolean prevIncluded) {
      if(target == 0)
         return true;
      else if(start >= nums.length && target != 0)
         return false;
      else if(nums[start] % 5 == 0) {
         if(prevIncluded)
            return recGroupSum5Helper2(start+1, nums, target - nums[start] + nums[start-1], true, true);
         else
            return recGroupSum5Helper2(start+1, nums, target - nums[start], true, true);
      }
      else if(nums[start] == 1 && isMult5)
         return recGroupSum5Helper2(start+1, nums, target, false, false);
      else
         return recGroupSum5Helper2(start+1, nums, target - nums[start], false, true) || recGroupSum5Helper2(start+1, nums, target, false, false);        
   }
   
   public static boolean recGroupSum5Helper(int start, int[] nums, int target, boolean isMult5) {
      if(target == 0)
         return true;
      else if(start >= nums.length && target != 0)
         return false;
      else if(nums[start] % 5 == 0)
            return recGroupSum5Helper(start+1, nums, target - nums[start], true);
      else if(nums[start] == 1 && isMult5)
         return recGroupSum5Helper(start+1, nums, target, false);
      else
         return recGroupSum5Helper(start+1, nums, target - nums[start], false) || recGroupSum5Helper(start+1, nums, target, false);        
   }
   
   public static boolean recGroupSum5(int start, int[] nums, int target) {
      if(nums.length == 0)
         return true;
      else
         return recGroupSum5Helper(0, nums, target, false);
   }
   
   public static void main(String[] args) {
      int[] nums = {2, 5, 10, 4};
      boolean res = recGroupSum5(0, nums, 19);
      System.out.println(res);
      
      boolean res2 = recGroupSum5(0, nums, 17);
      System.out.println(res2);
      
      boolean res3 = recGroupSum5(0, nums, 12);
      System.out.println(res3);
      
      boolean res4 = recGroupSum5(0, nums, 7);
      System.out.println(res4);
   }
}
