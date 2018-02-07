package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Given two strings, find the smallest substring in s containing all characters of pattern.
 * --
 */
public class StringsMinimumWindowSubstring {
   
   private static int NUMCHARS = 256;
   
   public static String minimumWindowSubstring(String s, String pattern) {
      if(s.length() < pattern.length())
         return "";
                 
      int[] hash_str = new int[NUMCHARS];
      int[] hash_pattern = new int[NUMCHARS];
      
      int start_i = 0;
      int startwindow_i = -1;
      int minlen = Integer.MAX_VALUE;      
      int count = 0;
      int plen = pattern.length();
      
      // Fill character count for pattern
      for(int i=0; i<pattern.length(); i++) 
         hash_pattern[pattern.charAt(i)]++;      
      
      // Count character for string and find min window
      start_i=0;
      for(int i=0; i<s.length(); i++) {
         hash_str[s.charAt(i)]++; 
         
         if(hash_pattern[s.charAt(i)] != 0 && hash_str[s.charAt(i)] <= hash_pattern[s.charAt(i)]) 
            count++;
         
         if(count == plen) {// reduce window
            while(hash_str[s.charAt(start_i)] > hash_pattern[s.charAt(start_i)] || hash_pattern[s.charAt(start_i)] == 0) {
               if(hash_str[s.charAt(start_i)] > hash_pattern[s.charAt(start_i)]) 
                  hash_str[s.charAt(start_i)]--;
               start_i++;               
            }
            
            //update minlen 
            System.out.println("-- startwindow_i: " + startwindow_i + ", minlen: " + minlen + ", start_i: " + start_i);
            if(minlen > i - start_i + 1) {
               minlen = i - start_i + 1;
               startwindow_i = start_i;
            }
         }
      }
      
      if(startwindow_i == -1) {
         System.out.println("No window found");
         return "";
      }
      System.out.println("startwindow_i: " + startwindow_i + ", minlen: " + minlen);
      return s.substring(startwindow_i, startwindow_i + minlen);         
   }

   public static void main(String[] args) {
      String res = minimumWindowSubstring("this is my dog toby", "ydm");
      System.out.println(res);
   }
}
