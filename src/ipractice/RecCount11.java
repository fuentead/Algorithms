package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a string, compute recursively (no loops) the number of "11" 
 * substrings in the string. The "11" substrings should not overlap.
 * 
 * count11("11abc11") → 2
 * count11("abc11x11x11") → 3
 * count11("111") → 1
 */
public class RecCount11 {

   /*
    * Solving count 11 problem with recursion.
    * 
    * Time Complexity O(n)
    * Space Complexity O(n), stack used in recursion.
    */
   public static int recCount11Helper(String s, int index) {
      if(index >= s.length()-1)
         return 0;
      else {
         if(index < s.length()-1 && s.charAt(index) == '1' && s.charAt(index+1) == '1') 
            return 1 + recCount11Helper(s, index+2);
         else 
            return recCount11Helper(s, index+1);
      }
   }
   
   public static int recCount11(String s) {
      if(s.length()==0)
         return 0;
      else {
         return recCount11Helper(s, 0);
      }      
   }
   
   public static void main(String[] args) {

      int res = recCount11("11abc11");
      System.out.println(res);
      
      int res2 = recCount11("abc11x11x11");
      System.out.println(res2);
      
      int res3 = recCount11("111");
      System.out.println(res3);
   }

}
