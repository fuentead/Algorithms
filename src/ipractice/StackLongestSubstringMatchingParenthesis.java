package ipractice;
import java.util.*;

public class StackLongestSubstringMatchingParenthesis {

   public static void longestSubstringMatchingParenthesis(String p) {
      if(p.length() < 2) 
         return;
      
      Stack<Integer> s = new Stack<Integer>(); 
      int istart = -1;
      int cmax = Integer.MIN_VALUE;
      int maxlen = Integer.MIN_VALUE;
      
      for(int i=0; i<p.length(); i++) {
         if(p.charAt(i) == '(') 
            s.push(i);         
         else if(p.charAt(i) == ')') {
            if(s.isEmpty() || s.peek() == -1) {
               s.push(-1);
               istart = -1;
            }
            else { 
               if(istart == -1)
                  istart = s.peek();
               else if (istart > s.peek())
                  istart = s.peek();
               s.pop();
               cmax = i - istart + 1;
               if(maxlen < cmax)
                  maxlen = cmax;
            }
         }
      }
      System.out.println(maxlen);
   }

   public static void main(String[] args) {
      
      String s = "))(()())(())((";
      longestSubstringMatchingParenthesis(s);
   }
}
