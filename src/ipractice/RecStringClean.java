package ipractice;

/**
 * @author adrianafuentes
 * 
 * Given a string, return recursively a "cleaned" string where 
 * adjacent chars that are the same have been reduced to a single 
 * char. So "yyzzza" yields "yza".
 * 
 * stringClean("yyzzza") → "yza"
 * stringClean("abbbcdd") → "abcd"
 * stringClean("Hello") → "Helo"
 */
public class RecStringClean {

   /* 
    * String clean problem solved with recursion.
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n) stack in recursion.
    */
   public static String recStringCleanHelper(String s, StringBuilder sb, int index, char prev) {
      if(index > s.length()-1)
         return "";
      else {
         if(s.charAt(index) == prev)
            recStringCleanHelper(s, sb, index+1, prev);
         else {
            sb.append(s.charAt(index));
            prev = s.charAt(index);
            recStringCleanHelper(s, sb, index+1, prev);
         }
      }
      return sb.toString();
   }

   public static String recStringClean(String s) {
      if(s.length()==0)
         return "";
      else {
         StringBuilder sb = new StringBuilder();
         return recStringCleanHelper(s, sb, 0, '*');
      }
   }
   
   public static void main(String[] args) {
      String res = recStringClean("yyzzza");
      System.out.println(res);
      
      String res2 = recStringClean("abbbcdd");
      System.out.println(res2);
      
      String res3 = recStringClean("Hello");
      System.out.println(res3);
   }
}
