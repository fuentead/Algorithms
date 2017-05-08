package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a string S and a string T, find the minimum window in S
 * which will contain all the characters in T.
 * 
 * e.g.
 * S = "AYZABOBECODXBANC"
 * T = "ABC"
 * 
 * Minimum window is "BANC", which contains all letters - A B and C
 * 
 * - If no such window exists, then return an empty string
 * - If there are multiple minimum windows of the same length, then return any one
 * - Characters might be repeated
 */
public class MinimumWindowSubstring {

   public static String minimumWindowSubstring(String s, String t) {
      List<String> windows = new ArrayList<String>(); // Storage for different windows found.
      Map<Character, Boolean> target = new HashMap<Character, Boolean>(); // Target letters found.
      
      for(int i=0; i<t.length(); i++) 
         target.put(t.charAt(i), false);
      
      int istart = 0;
      int iend = 0;
      int tcount = 0;
      for(int j=0; j<s.length(); j++) {
         if(target.containsKey(s.charAt(j)) && !target.get(s.charAt(j))) {            
            target.put(s.charAt(j), true);   
            tcount++;
            iend = j;
         }
         // Repeated character found in s, start search from this character.
         else if(target.containsKey(s.charAt(j)) && target.get(s.charAt(j))) { 
            Iterator it = target.entrySet().iterator();
            while(it.hasNext()) {
               Map.Entry pair = (Map.Entry) it.next();
               target.put((Character)pair.getKey(), false);
            }            
            target.put(s.charAt(j), true);
            tcount = 1;
            istart = j;
            iend = j;
         }
         // Current character at s is not in the target, current char is end of window
         else {
            iend = j;
         }
         // window has been found
         if(tcount == t.length()) {
            windows.add(s.substring(istart, iend+1));
            istart = iend+1;
            tcount = 0;
         }
      }
      
      int minWinSize = Integer.MAX_VALUE;
      String minWinString = "";
      for(int j=0; j<windows.size(); j++) {
        if(windows.get(j).length() < minWinSize) {
           minWinSize = windows.get(j).length();
           minWinString = windows.get(j);
        }
      }      
      return minWinString;
   }
   
   public static void main(String[] args) {
      String strMinWin = minimumWindowSubstring("AYZABOBECODXBANC", "ABC");
      System.out.println(strMinWin);
   }
}
