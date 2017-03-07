package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Find a duplicated number in a loose permutation of 
 * numbers. A permutation is an array that is size N, 
 * also has positive numbers from 1 through N. A loose
 * permutation is a permutation where some numbers are
 * missing and some are duplicated, but the total number
 * is still N.
 * 
 *  - We want to find any one duplicated number; not 
 *    necessarily the first or the least.
 *  - It can occur anywhere in the input array, and we 
 *    don't care how many times it is duplicated.
 *  - Input array may nor may not be sorted.
 *  - You can only use constant extra memory.
 *  - There is no limit/constraint on N i.e. it is a normal 
 *    4-byte integer 
 *    
 *    e.g.
 *    Input: 1,7,4,3,2,7,4: This array has 7 numbers from 1 thru 7,
 *    with some missing (5 and 6) and some duplicated (4 and 7).
 *    Albeit unsorted, but sorting is irrelevant to a permutation.
 *    Output: 4 or 7
 *    
 *    Input: 3, 1, 2: This has nothing missing
 *    Output: -1
 */
public class SortingDuplicateInLoosePermutation {
   
   /*
    * Using a modified bucket sort to find the 
    * duplicate number.
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    */
   public static int findDuplicateLoosePermutation(int[] data) {
      if(data.length == 0)
         return -1;
      
      int index = 0;
      while(index < data.length) {
         if(data[index] == index+1)
            index++;
         else if(data[index] == data[data[index]-1])
            return data[index];
         else {
            int n = data[index];
            data[index] = data[n-1];
            data[n-1] = n;            
         }            
      }
      return -1;
   }
   
   public static void main(String[] args) {
      int[] data = {1,7,4,3,2,7,4};
      
      int n = findDuplicateLoosePermutation(data);
      System.out.println(n);
   }
}
