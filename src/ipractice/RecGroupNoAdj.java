package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given an array of ints, is it possible to choose a group of some of 
 * the ints, such that the group sums to the given target with this 
 * additional constraint: If a value in the array is chosen to be in 
 * the group, the value immediately following it in the array must not 
 * be chosen. (No loops needed.)
 * 
 * groupNoAdj(0, [2, 5, 10, 4], 12) → true
 * groupNoAdj(0, [2, 5, 10, 4], 14) → false
 * groupNoAdj(0, [2, 5, 10, 4], 7) → false
 */
public class RecGroupNoAdj {

   public static boolean recGroupNoAdj(int start, int[] nums, int target) {
      if(start >= nums.length && target == 0)
         return true;        
      else if(start >= nums.length && target != 0)
         return false;
      else   
         return (recGroupNoAdj(start+2, nums, target - nums[start]) || recGroupNoAdj(start+1, nums, target)); 
   }

   public static void main(String[] args) {
      int[] nums = {2, 5, 10, 4};
      boolean res = recGroupNoAdj(0, nums, 12);
      System.out.println(res);

      boolean res2 = recGroupNoAdj(0, nums, 14);
      System.out.println(res2);
      
      boolean res3 = recGroupNoAdj(0, nums, 7);
      System.out.println(res3);      
   }
}
