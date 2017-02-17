package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given an array of numbers, positive integers only, 
 * group them in-place into evens and odds.
 * 
 * Input: Integer array, positive integers only, repeats possible.
 * Output: The same integer array, with evens on left side and odds
 * on right side. No need to preserve order within odds or evens.
 * 
 * Grouping is a special case of sorting. It's less complex and can 
 * be done with easier methods not labeled as sorting but special 
 * case.
 */
public class SortingGroupTheNumbers {
   
   public static void swap(int[] nums, int istart, int iend) {
      int temp = nums[istart];
      nums[istart] = nums[iend];
      nums[iend] = temp;
   }
   
   public static int[] sortGroupNumbers(int[] nums) {
      if(nums.length == 0)
         return nums;
      
      int istart = 0;
      int iend = nums.length-1;
      
      while(istart < iend || istart != iend) {
         if(nums[istart] % 2 == 0)
            istart++;
         else {
            swap(nums, istart, iend);
            iend--;
         }
      } 
      return nums;
   }
   
   public static void main(String[] args) {
      System.out.print("Test #1: ");
      int[] nums = {2,3,5,6,10};
      sortGroupNumbers(nums); 
      for(int i=0; i<nums.length; i++)
         System.out.print(nums[i] + " ");
      
      System.out.print("\nTest #2: ");
      int[] nums2 = {4,1,2,3,4};
      sortGroupNumbers(nums2); 
      for(int i=0; i<nums2.length; i++)
         System.out.print(nums2[i] + " ");
   }
}
