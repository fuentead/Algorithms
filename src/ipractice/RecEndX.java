/**
 * 
 */
package ipractice;

/**
 * @author adrianafuentes
 * 
 * Given a string, compute recursively a new string where 
 * all the lowercase 'x' chars have been moved to the end 
 * of the string.
 * 
 * endX("xxre") → "rexx"
 * endX("xxhixx") → "hixxxx"
 * endX("xhixhix") → "hihixxx"
 */

class Tuplex {
   StringBuilder sb;
   int cnt;
   
   public Tuplex(int cnt) {
      this.sb = new StringBuilder(0);
      this.cnt = cnt;
   }
}

public class RecEndX {
   
   /*
    * End X problem solved with recursion.
    * 
    * Time Complexity O(2n) loop and n recursions
    * Space Complexity O(n) recursive solution
    */
   public static Tuplex recEndXHelper(String s, Tuplex t, int index) {      
      if(index > s.length()-1)
         return t;      
      else if(s.charAt(index) == 'x') {
         t.cnt++;
      }
      else {
         t.sb.append(s.charAt(index));
      }
      recEndXHelper(s, t, index+1);
      return t;
   }

   public static String recEndX(String s) {
      if(s.length()==0)
         return "";
      else {
         Tuplex t = new Tuplex(0);
         recEndXHelper(s, t, 0);
      
         for(int i=0; i<t.cnt; i++)
            t.sb.append('x');
         
         return t.sb.toString();
      }
   }
   
   public static void main(String[] args) {
      String res = recEndX("xxre");
      System.out.println(res);
   }
}
