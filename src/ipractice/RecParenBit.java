package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a string that contains a single pair of parenthesis, 
 * compute recursively a new string made of only of the parenthesis 
 * and their contents, so "xyz(abc)123" yields "(abc)".
 * 
 * parenBit("xyz(abc)123") → "(abc)"
 * parenBit("x(hello)") → "(hello)"
 * parenBit("(xy)1") → "(xy)"
 */
public class RecParenBit {
   
   /*
    * Create string with content inside parenthesis.
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n) recursive stack.
    */
   public static String recParenBitHelper(String s, int index, StringBuilder sb, boolean cseen) {
      if(index > s.length()-1)
         return "";
      else {
         if(s.charAt(index) == '(') {
            if(sb.length() > 0 && cseen == true)
               sb.delete(0, sb.length());
            sb.append(s.charAt(index));      
            recParenBitHelper(s, index+1, sb, true);
         }
         else if(s.charAt(index) == ')') {
            sb.append(s.charAt(index));
            cseen = false;
            return sb.toString();
         } 
         else if(cseen == true) {
            sb.append(s.charAt(index));
            recParenBitHelper(s, index+1, sb, true);
         } 
         else
            recParenBitHelper(s, index+1, sb, false);
      } 
      return sb.toString();
   }

   public static String recParenBit(String s) {
      if(s.length() == 0)
         return "";
      else {
         StringBuilder sb = new StringBuilder();
         return recParenBitHelper(s, 0, sb, false);  
      }
   }
   
   public static void main(String[] args) {
      String s = recParenBit("xyz(abc)123");
      System.out.println(s);
      
      String s2 = recParenBit("x(hello)");
      System.out.println(s2);
      
      String s3 = recParenBit("(xy)1");
      System.out.println(s3);
   }
}
