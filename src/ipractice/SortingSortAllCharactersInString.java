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
 * additional space. Extended ASCII is 256 characters, 
 * that is bound to a range for input.
 */
public class SortingSortAllCharactersInString {

   /*
    * Solve sorting characters in string problem by using 
    * bucket sort. Bucket sort to achieve linear time and 
    * constant space. 
    * 
    * Lowercase letters ins ASCII are from 97-122. 26 letters.
    * ASCII character are from 0-127
    * ASCII extended characters are from 0-256
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(26) ~> constant time.
    */
   public static void sortAllChars(String s) {
      if(s.length() == 0)
         return;
      
      int[] bucket = new int[127];
      for(int j=0; j<s.length(); j++) {        
         int cnum = (int) s.charAt(j);
         bucket[cnum]++;
      }

      for(int k= 0; k<bucket.length; k++) {
         if(bucket[k] > 0)
            for(int l=0; l<bucket[k]; l++)
               System.out.print((char)k);
      }     
   }
   public static void main(String[] args) {
      int n = (int)('A');
      System.out.println(n);
      System.out.println((char)n);
      
      System.out.println("Test 1: 'this is easy'");
      sortAllChars("this is easy");
      
      System.out.println("\n\nTest 2: 'arturo'");
      sortAllChars("arturo");
   }
}
