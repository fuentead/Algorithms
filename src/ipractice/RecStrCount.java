package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a string and a non-empty substring sub, compute recursively 
 * the number of times that sub appears in the string, without the 
 * sub strings overlapping.
 * 
 * strCount("catcowcat", "cat") → 2
 * strCount("catcowcat", "cow") → 1
 * strCount("catcowcat", "dog") → 0
 */
public class RecStrCount {

   public static int recStrCountHelper(String s, String sub, int index) {
      if(index > s.length()-sub.length())
         return 0;
      else if(s.substring(index, index + sub.length()).equals(sub)) {
         return 1 + recStrCountHelper(s, sub, index + sub.length());
      }
      else 
         return recStrCountHelper(s, sub, index + 1);
   }
   
   public static int recStrCount(String s, String sub) {
      if(s.length() == 0)
         return 0;
      else {
         return recStrCountHelper(s, sub, 0);
      }
   }
   
   public static void main(String[] args) {
      int cnt = recStrCount("catcowcat", "cat");
      System.out.println(cnt);
      
      int cnt2 = recStrCount("catcowcat", "cow");
      System.out.println(cnt2);
      
      int cnt3 = recStrCount("catcowcat", "dog");
      System.out.println(cnt3);
   }
}
