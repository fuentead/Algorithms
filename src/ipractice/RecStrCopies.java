package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a string and a non-empty substring sub, compute recursively 
 * if at least n copies of sub appear in the string somewhere, possibly 
 * with overlapping. N will be non-negative.
 * 
 * strCopies("catcowcat", "cat", 2) → true
 * strCopies("catcowcat", "cow", 2) → false
 * strCopies("catcowcat", "cow", 1) → true
 */
public class RecStrCopies {

   public static boolean recStrCopiesHelper(String s, String sub, int index, int n) {
      if(n == 0)
         return true;
      else if(index > s.length() - sub.length())
         return false;     
      else if(s.substring(index, index + sub.length()).equals(sub)) {         
         return recStrCopiesHelper(s, sub, index + 1, n-1);
      }
      else 
         return recStrCopiesHelper(s, sub, index + 1, n);
   }
   
   public static boolean recStrCopies(String s, String sub, int n) {
      if(s.length() == 0)
         return false;
      else {
         return recStrCopiesHelper(s, sub, 0, n);
      }
   }

   public static void main(String[] args) {
      boolean res = recStrCopies("catcowcat", "cat", 2);
      System.out.println(res);
      
      boolean res2 = recStrCopies("catcowcat", "cow", 2);
      System.out.println(res2);
      
      boolean res3 = recStrCopies("catcowcat", "cow", 1);
      System.out.println(res3);

   }
}
