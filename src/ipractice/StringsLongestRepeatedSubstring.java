package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a string, find the longest repeated
 * substring in it.
 * 
 * Repeated is occurring more than once. It 
 * doesn't matter how many times it occurs 
 * beyond 2 times.
 * 
 * Examples:
 * --------
 * ABABABA => ABABA
 * ATCGATCGA => ATCGA
 * banana => ana
 */
public class StringsLongestRepeatedSubstring {

   public static void longestRepeatedSubstringHelper(String s, int istart, Map<String, Boolean> map) {
      if(s.length() == 0)
         return;
      
      // Add all substring to the map and mark if repeated
      StringBuffer res = new StringBuffer();
      for(int i=istart; i<s.length(); i++) {
         String sres = res.append(s.charAt(i)).toString();
         if(map.containsKey(sres) && (map.get(sres) == false)) 
            map.put(sres, true);
         else
            map.put(sres, false);           
      }
   }

   /*
    * Time Complexity: O(n^2)
    * Space Complexity: O(n)
    * 
    */
   public static String longestRepeatedSubstring(String s) {
      if(s.length() == 0)
         return "";
      
      int maxLen = 0;
      String maxSubstring = "";
      Map<String, Boolean> map = new HashMap<String, Boolean>();
           
      for(int i=0; i<s.length(); i++) 
         longestRepeatedSubstringHelper(s, i, map);

      // Choose longest repeated substring in the map
      for(String keySubstring : map.keySet()) {
         boolean valueRepeated = map.get(keySubstring);
         
         if(valueRepeated) {
            if(keySubstring.length() > maxLen) {
               maxLen = keySubstring.length();
               maxSubstring = keySubstring;
            }
         }
      }
      
      return maxSubstring;
   }
   
   public static void main(String[] args) {

      String res = longestRepeatedSubstring("ABABABA");
      System.out.println(res);
      
      String res2 = longestRepeatedSubstring("ATCGATCGA");
      System.out.println(res2);
      
      String res3 = longestRepeatedSubstring("banana");
      System.out.println(res3);
   }
}
