package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * ---
 * Given a string, find the length of the longest substring T that 
 * contains at most 2 distinct characters.
 * ---
 * 
 * For example, Given s = "eceba", T is "ece" which is length 3.
 * 
 * If there is no such substrings, then print nothing
 * If multiple substring exist, print any of them
 */
public class StringLongestSubstringwithAtMostTwoDistinctCharacters {
   
   private static int MAXCHARS = 26;

   class ResTuple {
      int maxlen;
      String maxstring;     
      ResTuple(int maxlen, String maxstring) {
         this.maxlen = maxlen;
         this.maxstring = maxstring;
      }
   }
   /* Solution maintaining a string window.
    * Time Complexity: O(n)
    * Space Complexity: O(n) 
    */
   public static int reduceLeftIndex(int[] numLetters, int ileft, String s, int unique) {
      char c = s.charAt(ileft);
      while (numLetters[c-'a'] > 0) {
         if(s.charAt(ileft) == c) {
            numLetters[c - 'a']--;
         }
         else {
            char ccur = s.charAt(ileft);
            if(numLetters[ccur - 'a'] == 1)
               unique--; 
            numLetters[ccur - 'a']--;
         }
         ileft++;
      }
      unique--;
      return ileft;
   }
   
   public static String longestSubstringTwoChars(String s, int k) {
      if(s.length() < 2)
         return "";
      
      // Check if string has more than two different chars
      int[] numLetters = new int[MAXCHARS];
      int unique = 0;
      for(int i=0; i<s.length(); i++) {
         int index = s.charAt(i)-'a';
         if(numLetters[index] == 0)
            unique++;
         else
            numLetters[index]++;
      } 
      if(unique < k)
         return "";
      System.out.println("passed first check");
      
      // Initialize numLetters array to zero
      for(int i=0; i<MAXCHARS; i++) 
         numLetters[i] = 0;
      
      // Check for all substrings within a window
      int maxwstart = 0;
      int maxwend = 0;
      int ileft = 0;
      int iright = 0;
      
      int index = s.charAt(0) - 'a';
      numLetters[index]++;
      iright++;
      unique = 1;
      while(iright < s.length()) {
         index = s.charAt(iright) - 'a';
         if(numLetters[index] == 0)
            unique++;
         else
            numLetters[index]++;
         
         if(unique > k) 
            ileft = reduceLeftIndex(numLetters, ileft, s, unique);
           
         if((iright - ileft + 1) > (maxwend - maxwstart + 1)) {
            maxwend = iright;
            maxwstart = ileft;
         } 
         iright++;
      }
      return s.substring(maxwstart, maxwend+1);
   }
   
   

   /*
    * Time Complexity: O(n^2) solution.
    * Space Complexity: O(n)
    * Generate all substrings combinations with at most 2 characters
    */
   public void longestSubstringTwoCharDiff(String s, int index, ResTuple res) {
      Set<Character> set = new HashSet<Character>();
      int istart = index;
      int iend = index;
  
      while(set.size() < 2 && iend < s.length()) {
         if(!set.contains(s.charAt(iend)))
            set.add(s.charAt(iend));
         iend++;         
      }
      
      while(iend < s.length() && set.contains(s.charAt(iend)))         
         iend++;      
      checkmaxsize(s, res, istart, iend);      
   }
   
   public void longestSubstringTwoCharDiff(String s) {
      if(s.length() == 0)
         return;

      ResTuple res = new ResTuple(0, "");      
      for(int i=0; i<s.length(); i++) 
         longestSubstringTwoCharDiff(s, i, res);       
      System.out.println("maxlen: " + res.maxlen + " maxstring: " + res.maxstring);
   }
   
   private ResTuple checkmaxsize(String s, ResTuple res, int istart, int iend) {
      int prevmaxlen = res.maxlen;
      res.maxlen = Math.max(res.maxlen, (iend-istart));
      if(prevmaxlen < res.maxlen) 
         res.maxstring = s.substring(istart, iend);      
      return res;
   }
     
   public static void main(String[] args) {
      StringLongestSubstringwithAtMostTwoDistinctCharacters ls = new StringLongestSubstringwithAtMostTwoDistinctCharacters();
      ls.longestSubstringTwoCharDiff("cbciiiiibaaaaaa"); 
      ls.longestSubstringTwoCharDiff("eceba");
      ls.longestSubstringTwoCharDiff("eciiiiiba");
      
      String res = longestSubstringTwoChars("eceba", 2);
      System.out.println(res);
   }
}
