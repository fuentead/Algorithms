package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Input: A string of characters, like a full English 
 * sentence, delimited by a new line or NULL. 
 * Duplicates are okay.
 * 
 * Output: A string of characters, in sorted order of their
 * ASCII values. You can overwrite the existing array.
 * 
 * Solution Complexity: Aim for linear time and constant
 * additional space.
 * ASCII is limited to 256, that is bound to a range for input.
 */
public class SortingSortAllCharactersInString {

   /*
    * Solve sorting characters in string problem by using 
    * bucket sort. Bucket sort to achieve linear time and 
    * constant space. 
    * 
    * Letters ins ASCII are from 97-122
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(256) ~> constant time.
    * 
    */
   public static void sortAllChars(String s) {
      if(s.length() == 0)
         return;
      
      int[] bucket = new int[26];
      for(int i=0; i<bucket.length; i++)
         bucket[i] = 0;         
      
      for(int j=0; j<s.length(); j++) {
         int cnum = s.charAt(j) - 'a';
         bucket[cnum]++;
      }

      for(int k= 0; k<bucket.length; k++) {
         if(bucket[k] > 0)
            for(int l=0; l<bucket[k]; l++)
               System.out.print((char)(k+'a') + " ");
      }     
   }
   public static void main(String[] args) {
      System.out.println("Test 1: 'adriana'");
      sortAllChars("adriana");
      
      System.out.println("\n\nTest 2: 'arturo'");
      sortAllChars("arturo");
   }
}
