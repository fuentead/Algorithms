package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a string, compute recursively a new string where all 
 * the 'x' chars have been removed.
 * 
 * noX("xaxb") → "ab"
 * noX("abc") → "abc"
 * noX("xx") → ""
 */
public class RecNoX {

   public static String recNoXHelper(String cs, StringBuilder sb, int index) {     
      if(index > cs.length()-1)
         return "";
      
      if(cs.charAt(index) != 'x')
         sb.append(cs.charAt(index));
      
      recNoXHelper(cs, sb, index+1);
      return sb.toString();
   }
   
   /*
    * No X problem
    * 
    * Time Complexity O(n)
    * Space Complexity O(n)
    */
   public static String recNoX(String s) {
      if(s.length() == 0)
         return "";
      
      StringBuilder sb = new StringBuilder();
      String res = recNoXHelper(s, sb, 0);
      
      return res;
   }
   
   public static void main(String[] args) {
      String s = recNoX("xab");
      System.out.println(s);
      
      String s2 = recNoX("abc");
      System.out.println(s2);
      
      String s3 = recNoX("xx");
      System.out.println(s3);
   }
}
