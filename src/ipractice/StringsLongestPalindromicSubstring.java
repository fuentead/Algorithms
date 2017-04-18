package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given some text, find the longest palindromic substring.
 * 
 * Example:
 * "cmadamd", longest palindromic substring: "cmadamd"
 * 
 */
public class StringsLongestPalindromicSubstring {

   /*   
   * i (row), j (column)
   *   c m a d a m d
   * c 1 0 0 0 0 0 0
   * m - 1 0 0 0 1 0
   * a - - 1 0 1 0 0
   * d - - - 1 0 0 0
   * a - - - - 1 0 0
   * m - - - - - 1 0
   * d - - - - - - 1
   * 
   * In the matrix,  vertical is the starting index for
   * the string and horizontal is the ending index 
   * for the string. In order to know if a string is a 
   * palindrome, all characters inside the string must be
   * a palindrome as well and characters for beginning and 
   * ending index must be the same as well.
   */
   public String longestPalindromicSubstring(String s) {
      if(s.length() == 0)
         return "";
      
      int[][] matrix = new int[s.length()][s.length()];
      String longPalindrome = Character.toString(s.charAt(0));

      // traverse column by column
      for(int j=0; j<s.length(); j++) {
         for(int i=0; i<s.length(); i++) {
            if(j < i) 
               matrix[i][j] = 0;
            else if(i == j)
               matrix[i][j] = 1;
            // length of string is two, check if letters are equal
            else if((j-i)==1) {
               if(s.charAt(i) == s.charAt(j)) {
                  matrix[i][j] = 1;
                  if((j-i+1) > longPalindrome.length())
                     longPalindrome = s.substring(i, j+1);
               } 
               else
                  matrix[i][j] = 0;
            }
            else {
               if((matrix[i+1][j-1] == 1) && (s.charAt(i) == s.charAt(j))) {
                  matrix[i][j] = 1;
                  if((j-i+1) > longPalindrome.length())
                     longPalindrome = s.substring(i, j+1);
               }
               else 
                  matrix[i][j] = 0;
            }
         }
      }
      
      // Print built matrix
      for(int i=0; i<s.length(); i++) {
         System.out.print("\n");
         for(int j=0; j<s.length(); j++) {
            System.out.print(matrix[i][j] + " ");
         }
      }
      return longPalindrome;
   }
   
   public static void main(String[] args) {
      StringsLongestPalindromicSubstring lps = new StringsLongestPalindromicSubstring();
      String longestPal = lps.longestPalindromicSubstring("cmadamd"); 
      System.out.println("\n" + longestPal);
   }
}
