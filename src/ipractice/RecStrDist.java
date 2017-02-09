package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a string and a non-empty substring sub, compute recursively 
 * the largest substring which starts and ends with sub and return 
 * its length.
 * 
 * strDist("catcowcat", "cat") → 9
 * strDist("catcowcat", "cow") → 3
 * strDist("cccatcowcatxx", "cat") → 9
 */
public class RecStrDist {
 
   /*
    * String Distribution problem solved recursively 
    * using substring method.
    * 
    * Time Complexity: O(n)
    * Space Complexity: O(n), recursive stack
    */
   public static int recStrDist(String s, String sub) {
      if(s.length() == 0)
         return 0;
      else if(!s.startsWith(sub)) {
         return recStrDist(s.substring(1), sub);        
      }
      else if(!s.endsWith(sub))
         return recStrDist(s.substring(0, s.length()-1), sub);
      else 
         return s.length();
   }
   
   /* 
    * Solution for the string distribution problem solved
    * recursively finding index of first and last occurrence.
    * 
    * Time Complexity: O(n)
    * Space Complexity O(n), recursive stack
    */
   public static int indexOf(String s, String sub, int istart, int direction) {
      if(istart < 0 || istart > s.length() - sub.length())
         return -1;
      else if(s.substring(istart, istart + sub.length()).equals(sub))
         return istart;
      else
         return indexOf(s, sub, istart+direction, direction);
   }
   
   public static int recStrDist2(String s, String sub) {
      if(s.length() == 0)
         return 0;
      else {
         int ifirst = indexOf(s, sub, 0, 1);
         if(ifirst == -1)
            return 0;
         else {
            int ilast = indexOf(s, sub, s.length()-sub.length(), -1);
            return ilast - ifirst + sub.length();
         }
      }
   }
   
   public static void main(String[] args) {
      int resLen = recStrDist("catcowcat", "cat");
      System.out.println("Res Sol1: " + resLen);
      
      int resLen2 = recStrDist("catcowcat", "cow");
      System.out.println("Res Sol1: " + resLen2);
      
      int resLen3 = recStrDist("cccatcowcatxx", "cat");
      System.out.println("Res Sol1: " + resLen3);
      
      int res2Len = recStrDist("catcowcat", "cat");
      System.out.println("Res Sol2: " + res2Len);
      
      int res2Len2 = recStrDist("catcowcat", "cow");
      System.out.println("Res Sol2: " + res2Len2);
      
      int res2Len3 = recStrDist("cccatcowcatxx", "cat");
      System.out.println("Res Sol2: " + res2Len3);
      
   }
}
