package ipractice;

import java.util.Arrays;

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
    * Space Complexity: O(128) ~> constant time.
    */
   public static void sortAllChars(String s) {
      if(s.length() == 0)
         return;
      
      int[] bucket = new int[128];
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
   
   /*
    * Solve algorithm using built-in quicksort method
    * Time Complexity: O(nlogn)
    * Space Complexity: O(logn)
    */
   public static void sortAllChars_(String s) {
      char[] schar = s.toCharArray();
      Arrays.sort(schar);
      String ssorted = new String(schar);
      System.out.println(ssorted);
   }
   
   /*
    * Solve algorithm using quicksort
    * Time Complexity: O(nlogn)
    * Space Complexity: O(logn)
    */
   public static void sortALlCharsQuicksort(String s) {
      char[] schar = s.toCharArray();
      //Arrays.sort(schar);
      
      quicksort(schar, 0, schar.length);
      System.out.println(new String(schar));
   }
   
   private static void quicksort(char[] data, int start, int end) {  
      if(start >= end)
         return;
      int pivot =  partition(data, start, end);
      quicksort(data, start, pivot-1);
      quicksort(data, pivot+1, end);
   }
  
   private static int partition(char[] data, int istart, int iend) {
      int pivot = istart;
      int p = istart;
      int i = istart+1;
      
      while(i<iend) {
         if((int)data[i] < (int)data[pivot]) {
            p++;
            swap(data, i, p);
         }
         i++;
      }
      swap(data, pivot, p);
      return p;
   }
   
   private static void swap(char[] data, int i, int j) {
      char tmp = data[i];
      data[i] = data[j];
      data[j] = tmp;
   }
   
   public static void main(String[] args) {
      int n = (int)('A');
      System.out.println(n);
      System.out.println((char)n);
      
      System.out.println("Test 1: 'this is easy'");
      sortAllChars("this is easy");
      
      System.out.println("\n\nTest 2: 'arturo'");
      sortAllChars("arturo");
      
      System.out.println("\n\nTest 3: 'nirmal'");
      sortAllChars("nirmal");
      
      System.out.println("\n\nTest 4: 'ale'");
      sortALlCharsQuicksort("ale");
   }
}
