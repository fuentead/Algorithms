package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a string, return true if it is a nesting of zero or 
 * more pairs of parenthesis, like "(())" or "((()))". Suggestion: 
 * check the first and last chars, and then recur on what's inside them.
 * 
 * nestParen("(())") → true
 * nestParen("((()))") → true
 * nestParen("(((x))") → false
 */
public class RecNestParen {
   
   public static boolean recNestParenHelper(String s, int istart, int iend, boolean isNested) {
      if((istart == iend) || (istart > iend)) {
         if(((s.charAt(istart) ==')') && (s.charAt(iend) == ')')) || ((s.charAt(istart) == '(') && (s.charAt(iend) == '(')))
            return false;
         else 
            return isNested;
      }
      else {
         if(s.charAt(istart) == '(' && s.charAt(iend) == ')')
            return recNestParenHelper(s, istart+1, iend-1, true);
         else if(isNested) {
            return false;
         }
         else
            return recNestParenHelper(s, istart+1, iend-1, false);
      } 
   }

   public static boolean recNestParen(String s) {
      if(s.length() == 0)
         return true;
      else 
         return recNestParenHelper(s, 0, s.length()-1, false);     
   }
   
   public static void main(String[] args) {
      boolean p = recNestParen("(())");
      System.out.println(p);
      
      boolean p2 = recNestParen("((()))");
      System.out.println(p2);
      
      boolean p3 = recNestParen("(((x))");
      System.out.println(p3);
      
      boolean p4 = recNestParen("((())");
      System.out.println(p4);
      
      boolean p5 = recNestParen("((()()");
      System.out.println(p5);
      
      boolean p6 = recNestParen("");
      System.out.println(p6);     
   }
}
