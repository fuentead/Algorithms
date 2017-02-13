package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array of ints, is it possible to choose a group of 
 * some of the ints, such that the group sums to the given 
 * target, with this additional constraint: if there are numbers 
 * in the array that are adjacent and the identical value, they 
 * must either all be chosen, or none of them chosen. For example, 
 * with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the 
 * middle must be chosen or not, all as a group. (one loop can be 
 * used to find the extent of the identical values).
 * 
 * groupSumClump(0, [2, 4, 8], 10) → true
 * groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
 * groupSumClump(0, [2, 4, 4, 8], 14) → false
 */
public class RecGroupSumClump {
      
   public static boolean recGroupSumClumpHelper2(int start, int[] nums, int target) {
      if(start >= nums.length)
         return target == 0;
      
      int sum = nums[start];
      while(start < nums.length-2 && nums[start] == nums[start+1]) {
         start++;
         sum = nums[start+1];
      }
      return recGroupSumClumpHelper2(start + 1, nums, target - sum) || recGroupSumClumpHelper2(start + 1, nums, target);
   }
   
   public static boolean recGroupSumClump(int start, int[] nums, int target) {
      if(nums.length == 0)
         return true;
     
      return recGroupSumClumpHelper2(0, nums, target);
   }

   public static void main(String[] args) {
      int[] nums = {2,4,8};
      boolean res = recGroupSumClump(0, nums, 10);
      System.out.println(res);
      
      int[] nums2 = {1,2,4,8,1};
      boolean res2 = recGroupSumClump(0, nums2, 14);
      System.out.println(res2);
      
      int[] nums3 = {2,4,4,8};
      boolean res3 = recGroupSumClump(0, nums3, 14);
      System.out.println(res3);

   }
}
