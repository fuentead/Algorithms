package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 */
public class StringsLongestSubstringWithAtMostKCharacters {

   public static String longestSubstringK(String s, int k) throws Exception {
      if(s == null) 
         throw new Exception("Null Argument");
      else if (s.length() == 0) 
         return "";
      else if (s.length() == 1)
         return s;

      int istart = 0;
      int iend = 1;
      int maxistart = 0;
      int maxiend = 1;
    
      Map<Character, Integer> refCount = new HashMap<Character, Integer >();
      refCount.put(s.charAt(istart),1);
      while(iend < s.length()) {
         if(refCount.containsKey(s.charAt(iend))) {
            int val = refCount.get(s.charAt(iend));
            refCount.put(s.charAt(iend), val+1);
         }
         else {
            refCount.put(s.charAt(iend), 1);
            while(refCount.size() > k) {
               int count = refCount.get(s.charAt(istart)) - 1;
               if(count == 0)
                  refCount.remove(s.charAt(istart));
               else
                  refCount.put(s.charAt(istart), count);
               istart++;
            }  
         }
     
         if((iend-istart) > (maxiend-maxistart)) {
            maxiend = iend;
            maxistart = istart;
         }
         iend++;
      }
      return s.substring(maxistart, maxiend+1);
    }
   
   public static void main(String[] args) {
      try {
         String s = longestSubstringK("ACBDSABAB", 2);
         System.out.println(s);
      
         String s2 = longestSubstringK("ABCDEBABA", 4);
         System.out.println(s2);
         
         String s4 = longestSubstringK("ABACB", 2);
         System.out.println(s4);
         
         String s5 = longestSubstringK("ACAAMMM", 2);
         System.out.println(s5);
         
         String s3 = longestSubstringK(null, 4);
         System.out.println(s3);
    
      }
      catch (Exception e){
         System.out.println(e);
      }
   }
}
