package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Input 10?
 * Output 101, 100
 * 
 * ie ? behaves like a wild-card. There are two possibilties for 10?, when that ? is replaced with either 0 or 1.
 * 
 * Write a program that takes given strings as input and produces suggested output.
 */
public class RecursionWildcard {
   
   public static void wildcardHelper(char[] cw, int index) {
      if(index >= cw.length) {
         System.out.println(String.valueOf(cw));
         return;
      }
      
      if(cw[index] == '?') {
         cw[index] = '1';
         wildcardHelper(cw, index+1);
         cw[index] = '0';
         wildcardHelper(cw, index+1);
        cw[index] = '?';
      }
      else 
         wildcardHelper(cw, index+1);         
   }

   public static void wildcard(String sw) {
      if(sw.length() == 0)
         return;
      
      wildcardHelper(sw.toCharArray(), 0);
   }
   
   public static void main(String[] args) {
      System.out.println("Test 1 - 10?");
      String sw = "10?";
      wildcard(sw);
      
      System.out.println("Test 2 - 1?0?");
      String sw2 = "1?0?";
      wildcard(sw2);
   }
}
