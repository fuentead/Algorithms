package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Given a string, find the longest repeated
 * substring in it.
 * 
 * Repeated is occurring more than once. It 
 * doesn't matter how many times it occurs 
 * beyond 2 times.
 * --
 * 
 * Examples:
 * 
 * ABABABA => ABABA
 * ATCGATCGA => ATCGA
 * banana => ana
 * 
 * Once a O(n^2) answer has been given, the interviewer would like to 
 * know if you know suffix trees. It doesn't have to be implemented.
 */
public class StringsLongestRepeatedSubstring {
   
   /**
    * Using a Suffix Tree to get solution
    * 
    * Time Complexity O(n)
    * Space Complexity O(n)
    */
   static class Tuple {
      String s;
      int n;
      int numRep;
      
      Tuple(String s, int n) {
         this.s = s;
         this.n = n;
         this.numRep = 0;
      }
   }
   
   public static String longestRepeatedSubstringSuffixTree(String s) {
      if(s.length() <=1)
         return "";
      
      Map<String, List<Tuple>> map = new HashMap<String, List<Tuple>>();
      
      for(int i=s.length()-1; i>=0; i--) {         
         if(!map.containsKey(String.valueOf(s.charAt(i)))) {         // If map doesn't contain first letter, add it with a Tuple of letter and index.
            System.out.println("not contain: " + s.charAt(i));
            Tuple t = new Tuple(s.substring(i), i);
            List<Tuple> l = new ArrayList<Tuple>();
            l.add(t);
            map.put(String.valueOf(s.charAt(i)), l);
         }
         else {                                                      // Search list for matching strings until it no longer matches and needs to be added.
            List<Tuple> l = map.get(String.valueOf(s.charAt(i)));
            System.out.println("contains: " + s.charAt(i) + " with l size: " + l.size());
            int index = i;
            for(Tuple t : l) {
               System.out.println("tuple comparisson: " + s.substring(index, index+ t.s.length()) + " with: " + t.s + " & index: " + index);
               if(t.s.equals(s.substring(index, index+ t.s.length()))){
                  System.out.println("equal");
                  index = index + t.s.length();
                  t.numRep = t.numRep + 1;
               }
               else 
                  continue;
            }
            System.out.println("rest: " + s.substring(index));
            Tuple t = new Tuple(s.substring(index), i);
            l.add(t);
         }
      }
      printSuffixTree(map);
      
      return findLongestRepeated(map);
   }
   
   public static void printSuffixTree(Map<String, List<Tuple>> map) {
      Iterator<String> it = map.keySet().iterator();
      while(it.hasNext()) {
         String key = it.next();
         System.out.print("key: " + key + ", ");
         List<Tuple> l = map.get(key);
         for(Tuple t : l) {
            System.out.print(t.s + ": " + t.n + ", ");
         }
         System.out.println("\n---");
      }
   }
   
   private static String findLongestRepeated(Map<String, List<Tuple>> map) {
      if(map.size() == 0)
         return null;
      
      String keyLongest = "";
      int maxSize = 0;
      Iterator<String> it = map.keySet().iterator();
      while(it.hasNext()) {
         String key = it.next();
         List<Tuple> l = map.get(key);
         if(l.size() > maxSize) {
            maxSize = l.size();
            keyLongest = key;
         }      
      }     
      return buildLongestRepeatedSubstring(map, keyLongest);
   }
   
   private static String buildLongestRepeatedSubstring(Map<String, List<Tuple>> map, String key) {
      StringBuffer res = new StringBuffer();
      
      List<Tuple> l = map.get(key);
      for(int i=0; i<l.size()-1; i++) {
         res.append(l.get(i).s);
      }
      return res.toString(); 
   }
   

   /**
    * Time Complexity: O(n^2)
    * Space Complexity: O(n)
    */
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
         boolean isRepeated = map.get(keySubstring);
         
         if(isRepeated) {
            if(keySubstring.length() > maxLen) {
               maxLen = keySubstring.length();
               maxSubstring = keySubstring;
            }
         }
      }
      return maxSubstring;
   }
   
   public static void longestRepeatedSubstringDP(String s) {
      if(s.length() == 0)
         return;
      
      int size = s.length();
      int[][] table = new int[size+1][size+1];
      
      int reslen = 0;
      int index = 0;
      for(int i=1; i<=size; i++) {
         for(int j=i+1; j<=size; j++) {
            if(s.charAt(i-1) == s.charAt(j-1) && table[i-1][j-1] < (j-i)) {
               table[i][j] = table[i-1][j-1] + 1;
            }
            else 
               table[i][j] = 0;
            index = Math.max(index, i);
            reslen = Math.max(reslen, table[i][j]);
         }        
      }
      if(reslen > 0)
         for(int i=index-reslen+1; i<=size; i++) {
            System.out.print(s.charAt(i - 1));
         }
   }
   
   public static void main(String[] args) {
      String res = longestRepeatedSubstring("ABABABA");
      System.out.println(res);
      
      String res2 = longestRepeatedSubstring("ATCGATCGA");
      System.out.println(res2);
      
      String res3 = longestRepeatedSubstring("banana");
      System.out.println(res3);
      
      String resST = longestRepeatedSubstringSuffixTree("ABABABA");
      System.out.println(resST);
      
      String resST2 = longestRepeatedSubstringSuffixTree("ATCGATCGA");
      System.out.println(resST2);
      
      longestRepeatedSubstringDP("ATCGATCGA");     
   }
}
