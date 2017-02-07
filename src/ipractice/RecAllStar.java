package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a string, compute recursively a new string where 
 * all the adjacent chars are now separated by a "*".
 * 
 * allStar("hello") → "h*e*l*l*o"
 * allStar("abc") → "a*b*c"
 * allStar("ab") → "a*b"
 */
public class RecAllStar {
   
   public static String recAllStarHelper(String s, StringBuilder ns, int index) {
      if(index == s.length()-1) {
         ns.append(s.charAt(index));
         return ns.toString();
      }
      else {
         ns.append(s.charAt(index));
         ns.append('*');
         return recAllStarHelper(s,ns,index+1);
      }      
   }

   public static String recAllStar(String s) {
      if(s.length()==0)
         return s;
      else {
         StringBuilder sb = new StringBuilder();
         return recAllStarHelper(s,sb, 0);
      }
   }
   
   public static void main(String[] args) {
      String res1 = recAllStar("hello");
      System.out.println(res1);
      
      String res2 = recAllStar("abc");
      System.out.println(res2);
      
      String res3 = recAllStar("ab");
      System.out.println(res3);
   }
}
