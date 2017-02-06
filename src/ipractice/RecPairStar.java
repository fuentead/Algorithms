package ipractice;

/**
 * @author adrianafuentes
 * 
 * Given a string, compute recursively a new string where 
 * identical chars that are adjacent in the original string 
 * are separated from each other by a "*".
 * 
 * pairStar("hello") → "hel*lo"
 * pairStar("xxyy") → "x*xy*y"
 * pairStar("aaaa") → "a*a*a*a"
 */
public class RecPairStar {

   public static String recPairStarHelper(String s, StringBuilder sb, int index) {
      if(index > s.length()-1)
         return "";
      else if(index < s.length()-1) {
         if(s.charAt(index) == s.charAt(index+1)) {
            sb.append(s.charAt(index));
            sb.append("*");
         }
         else 
            sb.append(s.charAt(index));
      }
      else
         sb.append(s.charAt(index));
      
      recPairStarHelper(s, sb, index+1);          
      return sb.toString();
   }
   
   /*
    * Recursive solution for pair star problem.
    * 
    * Time Complexity O(n)
    * Space Complexity O(n) recursive function
    */
   public static String recPairStar(String s) {
      if(s.length() == 0)
         return "";
      else {
         StringBuilder sb = new StringBuilder();
         return recPairStarHelper(s, sb, 0);
      }
   }
   
   public static void main(String[] args) {
      String res1 = recPairStar("hello");
      System.out.println(res1);
      
      String res2 = recPairStar("xxyy");
      System.out.println(res2);
      
      String res3 = recPairStar("aaaa");
      System.out.println(res3);
   }
}
