/**
 * 
 */
package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of ints, compute recursively if the array 
 * contains a 6. We'll use the convention of considering only 
 * the part of the array that begins at the given index. In this 
 * way, a recursive call can pass index+1 to move down the array. 
 * The initial call will pass in index as 0.
 * 
 * array6([1, 6, 4], 0) → true
 * array6([1, 4], 0) → false
 * array6([6], 0) → true
 */
public class RecArray6 {

   /*
    * Array 6 problem solved with recursion.
    * 
    * Time Complexity O(n)
    * Space Complexity O(n)
    */
   public static boolean recArray6(int[] nums, int index) {
      if(index > nums.length-1)
         return false;
       
       if(nums[index]==6)
         return true;
       else
         return recArray6(nums, index+1);
   }
   
   public static void main(String[] args) {
      int[] nums = {1,6,4};
      boolean res = recArray6(nums, 0);
      System.out.println(res);
   }
}
