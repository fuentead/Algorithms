/**
 * 
 */
package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of ints, compute recursively the number 
 * of times that the value 11 appears in the array. We'll 
 * use the convention of considering only the part of the 
 * array that begins at the given index. In this way, a 
 * recursive call can pass index+1 to move down the array. 
 * The initial call will pass in index as 0.
 * 
 * array11([1, 2, 11], 0) → 1
 * array11([11, 11], 0) → 2
 * array11([1, 2, 3, 4], 0) → 0
 */
public class RecArray11 {
   
   /*
    * Array 11 problem solved with recursion.
    * 
    * Time Complexity O(n)
    * Space Complexity O(n)
    */
   public static int recArray11(int[] nums, int index) {
      if(index > nums.length-1)
         return 0;
      
      if(nums[index]==11)
         return 1 + recArray11(nums, index+1);
      else
         return recArray11(nums, index+1);
   }

   public static void main(String[] args) {
      int[] nums_1 = {1,2,11};
      int[] nums_2 = {11,11};
      int[] nums_3 = {1,2,3,4};
      
      int res1 = recArray11(nums_1, 0);
      System.out.println(res1);

      int res2 = recArray11(nums_2, 0);
      System.out.println(res2);
      
      int res3 = recArray11(nums_3, 0);
      System.out.println(res3);
   }
}
