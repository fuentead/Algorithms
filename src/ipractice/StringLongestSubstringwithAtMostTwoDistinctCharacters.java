package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Given a string, find the length of the longest substring T that 
 * contains at most 2 distinct characters.
 * 
 * For example, Given s = "eceba", T is "ece" which is length 3.
 * 
 * If there is no such substrings, then print nothing
 * If multiple substring exist, print any of them
 */
public class StringLongestSubstringwithAtMostTwoDistinctCharacters {

   class ResTuple {
      int maxlen;
      String maxstring;     
      ResTuple(int maxlen, String maxstring) {
         this.maxlen = maxlen;
         this.maxstring = maxstring;
      }
   }

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
   }
}
