package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Given some text, find the longest palindromic substring.
 * ---
 * 
 * Example:
 * "cmadamd", longest palindromic substring: "cmadamd"
 * 
 */
public class StringsLongestPalindromicSubstring {

   public static String longestPalindromicSubstring(String s) {
      if(s.length() == 0)
         return "";
      
      int len = s.length();
      boolean[][] matrix = new boolean[len+1][len+1]; 
      
      // Single letters are all palindromes 
      int maxlen = 1;
      int istart= 0;    
      for(int i=0; i<len; i++) 
         matrix[i][i] = true;
      
      // Check for palindromes of size 2
      for(int i=0; i<len-1; i++) {
         if(s.charAt(i) == s.charAt(i+1)) {
            matrix[i][i+1] = true;
            if(maxlen < 2) {
               maxlen = 2;
               istart = i;
            }
         }
      }
      
      // Check for all palindromes of size >= 3
      for(int k=3; k<=len; k++) {
         for(int i=0; i<len-k+1; i++) {
            int j = i+k-1;           
            if(matrix[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
               matrix[i][j] = true; 
               if(maxlen < k) {
                  maxlen = k;
                  istart = i;
               }
            }
         }           
      }
      return s.substring(istart, istart + maxlen);
   }
   
   public static void main(String[] args) {
      String longestPal = longestPalindromicSubstring("cmadamd"); 
      System.out.println("\n" + longestPal);
      
      String longestPal2 = longestPalindromicSubstring("casac"); 
      System.out.println("\n" + longestPal2);
   }
}
