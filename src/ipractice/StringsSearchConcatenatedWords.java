package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Search concatenated words
 * 
 * Given two things:
 * 
 * 1. Some text, say T
 * 2. An array A of N Strings, all with the same length, say K
 * 
 * Find all the starting points (indices) in T, which has a concatenation of N strings
 * --
 * e.g.
 * T = "dogthecatcatthedog"
 * A = {"the", "cat"} N=2, K=3
 * 
 * Answer = {3,9}
 * 
 * At Index 3, we have the phrase "thecat" and at index 9, we have "catthe". They are concatenations
 * of two words in A. 
 * 
 * Print empty string if no combination exists.
 *
 */
public class StringsSearchConcatenatedWords {

   /*
    * Time Complexity: O(n*a)
    * Space Complexity O(1)
    */
   public List<Integer> indexConcatWordsIterative(String t, String[] a) {
      List<Integer> res = new ArrayList<Integer>();
      if(t.length() == 0)
         return null;
      else if(a.length == 0)
         return null;
      else {         
         int n = a.length;
         int k = a[0].length();
         int numwordsfound=0;
         int index=0;         
         for(int i=0; i<t.length(); i=i+k) {
            boolean found = false;
            for(int j=0; j<a.length; j++) {               
               if(t.substring(i,i+k).compareTo(a[j]) == 0) {
                  if(index == 0)
                     index = i;
                  numwordsfound++;
                  found = true;              
                  break;
               }   
            }
            if(numwordsfound == n) {
               res.add(index);
               index = 0;
               numwordsfound=0;
            }
            else if (found != true) {
               index = 0;
               numwordsfound=0;
            }
         }
      } 
      return res;
   }
   
   /*
    * Time Complexity: O(n - k) * k
    * n = length of string
    * k = num chars in dictionary
    * 
    * Space Complexity: (m)
    * m = size of dictionary
    */
   public List<Integer> indexConcatWords(String s, String[] dict) {
      int wcount = dict.length;
      int wlength = dict[0].length();
      int snumchar = s.length();
      int dnumchar = wcount * wlength;
      
      if(snumchar < dnumchar)
         return null;
      
      List<Integer> results = new ArrayList<Integer>();
      Map<String, Integer> map = new HashMap<String, Integer>();
      for(int i=0; i<dict.length; i++)
         map.put(dict[i], 1);
      
      for(int i=0; i<s.length() - dnumchar; i++) {
         int k=i;
         int wordsFound = 0;
         while(k-i< dnumchar && k+wlength < s.length()) {
            String stemp = s.substring(k, k+wlength);
            if(map.containsKey(stemp)) {
               wordsFound++;
               k = k + wlength;
            }
            else
               break; 
         }
         if(wordsFound == wcount)
            results.add(i);        
      }
      return results;
   }
   
   public static void main(String[] args) {
      
      StringsSearchConcatenatedWords cw = new StringsSearchConcatenatedWords();
      String s = "dogthecatrescattheturdog";
      String[] words = {"the", "cat"};
      List<Integer> res = cw.indexConcatWordsIterative(s, words);
      System.out.println("Results 1:");
      for(Integer i : res)
         System.out.print(i + " ");
      
      List<Integer> res2 = cw.indexConcatWords(s, words);
      System.out.println("\nResults 2:");
      for(Integer i : res2)
         System.out.print(i + " ");      
   }
}
