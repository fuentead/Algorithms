package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a string, compute recursively (no loops) a new string 
 * where all the lowercase 'x' chars have been changed to 'y' chars.
 * 
 * changeXY("codex") → "codey"
 * changeXY("xxhixx") → "yyhiyy"
 * changeXY("xhixhix") → "yhiyhiy"
 */
public class RecChangeXY {
   
   public static String recChangeXYHelper(char[] s, int index) {
      if(index < 0)
         return "";
      
      if(s[index] == 'x')
         s[index] = 'y';

      recChangeXYHelper(s, index-1);
      
      return String.valueOf(s);
   }
   
   /*
    * Change XY problem with recursion
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n) due to recursion.
    */
   public static String recChangeXY(String s) {
      if(s.length() == 0)
         return "";
      
      char[] cs = s.toCharArray();
      return recChangeXYHelper(cs, s.length()-1);
   }

   public static void main(String[] args) {
      String s = recChangeXY("xxiixr");
      System.out.println(s);
   }
}
