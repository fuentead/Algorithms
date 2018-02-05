package ipractice;

/**
 * @author Adriana Fuentes
 *
 * ---
 * Regex matcher: Determine if regex pattern is equal to a string. '?' matches any character. '*' matches sequence of characters.
 * ---
 */
public class StringsRegexMatcher {
   
   public static boolean regexMatcher(String s, String pattern) {
      if(pattern.length() == 0)
         return s.length() == 0;
      
      int slen = s.length();
      int plen = pattern.length();
      boolean[][] dptable = new boolean[slen+1][plen+1];
      
      // Empty pattern could match empty string
      dptable[0][0] = true;
      
      // Pattern '*' could match with empty string
      for(int j=1; j<slen; j++) {
         if(pattern.charAt(j-1) == '*')
            dptable[0][j] = dptable[0][j-1];
      }  
      
      for(int i=1; i<=slen; i++) {
         for(int j=1; j<=plen; j++) {
            
            // Pattern '*'
            // Option 1: Ignore '*' pattern and move to the next character in pattern.
            // Option 2: char '*' matches with ith character in input.
            if(pattern.charAt(j-1) == '*') {
              dptable[i][j] = dptable[i][j-1] || dptable[i-1][j];
            }
            // Pattern '?' or characters match
            else if(pattern.charAt(j-1) == '?' || s.charAt(i-1) == pattern.charAt(j-1)) {
               dptable[i][j] = dptable[i-1][j-1];
            }
            // Characters don't match
            else {
               dptable[i][j] = false;
            }
         }
      }
      return dptable[slen][plen];
   }

   public static void main(String[] args) {
      boolean res = regexMatcher("baaacab", "*****ba*****ab");
      System.out.println(res);
   }
}
