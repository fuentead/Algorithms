package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * We'll say that a "pair" in a string is two instances 
 * of a char separated by a char. So "AxA" the A's make 
 * a pair. Pair's can overlap, so "AxAxA" contains 3 pairs 
 * -- 2 for A and 1 for x. Recursively compute the number 
 * of pairs in the given string.
 * 
 * countPairs("axa") → 1
 * countPairs("axax") → 2
 * countPairs("axbx") → 1
 */
public class RecCountPairs {

   /*
    * Count pairs problem solved recursively.
    * 
    * input: "axa", index: 0 -> 'a', compare index:2 -> 'a'
    * output: 1, a == a
    * 
    * input: "axa", index: 1-> 'x', return index > s.length()-2
    * output: 0
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n)
    * 
   */

   public static int recCountPairsHelper(String s, int index) {  
      if(index > s.length()-2) {
         return 0;
      }
      else if(index < s.length()-2) {
         if(s.charAt(index) == s.charAt(index + 2)) {
            return 1 + recCountPairsHelper(s, index+1);            
         }
         else
            return recCountPairsHelper(s, index+1);
      }
      else 
         return recCountPairsHelper(s, index+1);
   }
   
   public static int recCountPairs(String s) {
      if(s.length() == 0)
         return 0;
         
      return recCountPairsHelper(s, 0);     
   }
   
   public static void main(String[] args) {
      int npairs = recCountPairs("axa");
      System.out.println(npairs);
      
      int npairs2 = recCountPairs("axax");
      System.out.println(npairs2);
      
      int npairs3 = recCountPairs("axbx");
      System.out.println(npairs3);
   }
}
