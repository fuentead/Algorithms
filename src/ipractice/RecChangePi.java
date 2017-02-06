package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a string, compute recursively (no loops) a new string 
 * where all appearances of "pi" have been replaced by "3.14".
 * 
 * changePi("xpix") → "x3.14x"
 * changePi("pipi") → "3.143.14"
 * changePi("pip") → "3.14p"
 */
public class RecChangePi {
   
   public static String recChangePiHelper(char[] sc, StringBuilder news, int index) {
      if(index >sc.length-1)
         return "";

      if(sc[index] == 'p' && index+1 != sc.length) {
         if(sc[index+1] == 'i') {
            news.append("3.14");
            index++;
         }
      }
      else
         news.append(sc[index]);
      
      recChangePiHelper(sc, news, index+1);
      return news.toString();
   }

   /*
    * Change Pi problem with recursion
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n), stack used in recursion
    */
   public static String recChangePi(String s) {
      if(s.length() == 0)
         return s;
      
      StringBuilder sb = new StringBuilder();
      char[] cs = s.toCharArray();
      return recChangePiHelper(cs, sb, 0);
   }
   
   public static void main(String[] args) {
      String ns = recChangePi("xpix");
      System.out.println(ns);
      
      String ns2 = recChangePi("pipi");
      System.out.println(ns2);
      
      String ns3 = recChangePi("pip");
      System.out.println(ns3);
      
   }
}
