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
   
   private Set<Character> set;
  
   class ResTuple {
      int maxlen;
      String maxstring;
      
      ResTuple(int maxlen, String maxstring) {
         this.maxlen = maxlen;
         this.maxstring = maxstring;
      }
   }
   
   StringLongestSubstringwithAtMostTwoDistinctCharacters() {
      this.set = new HashSet<Character>();
   }

   public void longestSubstringTwoCharDiff(String s) {
      if(s.length() == 0)
         return;
      
      ResTuple res = new ResTuple(0, "");
      int istart = 0;
      int iend = 1;
      set.add(s.charAt(istart));
      
      while(set.size() < 2) {
         if(!set.contains(s.charAt(iend)))
            set.add(s.charAt(iend));
         iend++;         
      }
      
      while(iend < set.size()) {
         if(set.contains(s.charAt(iend))) 
            iend++;
         else {
            //Get new maxlen and maxstring
            checkmaxsize(s, res, istart, iend);

            // Move istart to check for next string
            // and update set with new char
            istart = iend-1;
            char charRef = s.charAt(istart);
            while(s.charAt(istart) == charRef)
               istart--;
            set.remove(s.charAt(istart));
            istart++;
            set.add(s.charAt(iend));            
         }
      }
      checkmaxsize(s, res, istart, iend);
      System.out.println("maxlen: " + res.maxlen + " maxstring: " + res.maxstring);
   }
   
   private ResTuple checkmaxsize(String s, ResTuple res, int istart, int iend) {
      int prevmaxlen = res.maxlen;
      res.maxlen = Math.max(res.maxlen, (iend-istart)+1);
      if(prevmaxlen != res.maxlen) 
         res.maxstring = s.substring(istart, iend+1);      
      return res;
   }
     
   public static void main(String[] args) {
      StringLongestSubstringwithAtMostTwoDistinctCharacters ls = new StringLongestSubstringwithAtMostTwoDistinctCharacters();
      ls.longestSubstringTwoCharDiff("eceba"); 
   }
}
