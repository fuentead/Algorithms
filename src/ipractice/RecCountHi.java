package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a string, compute recursively (no loops) the number 
 * of times lowercase "hi" appears in the string.
 * 
 * countHi("xxhixx") → 1
 * countHi("xhixhix") → 2
 * countHi("hi") → 1
 */
public class RecCountHi {


   /**
    * CountHi problem resolved by recursion
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n)
    * @param string
    */
   public static int recCountHi(String s) {
      if(s.length() < 2)
         return 0;
      
      String letters = s.substring(s.length()-2);     
      if(letters.equals("hi")) {
         String word = s.substring(0, s.length()-2);
         return 1 + recCountHi(word);
      }
      else {
         String word = s.substring(0, s.length()-1);
         return recCountHi(word);  
      }
   }
   
   public static void main(String[] args) {
      int res = recCountHi("xxhixx");
      System.out.println(res);
      
      int res2 = recCountHi("xhixhix");
      System.out.println(res2);
      
      int res3 = recCountHi("hi");
      System.out.println(res3);
   }
}
