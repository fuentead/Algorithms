package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of ints, compute recursively if the array 
 * contains somewhere a value followed in the array by that 
 * value times 10. We'll use the convention of considering 
 * only the part of the array that begins at the given index. 
 * In this way, a recursive call can pass index+1 to move down 
 * the array. The initial call will pass in index as 0.
 * 
 * array220([1, 2, 20], 0) → true
 * array220([3, 30], 0) → true
 * array220([3], 0) → false
 */
public class RecArray220 {

   public static boolean recArray220(int[] nums, int index) {
      if(index > nums.length-2)
         return false;
      
      if(nums[index]*10 == nums[index+1])
         return true;
      else
         return recArray220(nums, index+1);
   }
   
   public static void main(String[] args) {
      
      int[] nums = {1,2,20};
      boolean res = recArray220(nums, 0);
      System.out.println(res);
      
      int[] nums2 = {3,30};
      boolean res2 = recArray220(nums2, 0);
      System.out.println(res2);

      int[] nums3 = {3};
      boolean res3 = recArray220(nums3, 0);
      System.out.println(res3);
   }
}
