package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Write a function that checks if the given 
 * input string has matching opening and closing
 * parenthesis. Valid parentheses are: '(',')','{','}','[',']'
 */
public class LinkedListMatchingParenthesis {

   public static boolean checkMatchingParenthesis(char[] p) {
      if(p.length == 0)
         return true;
      
      Stack<Character> s = new Stack<Character>();
      
      for(int i=0; i<p.length; i++) {
         if(p[i] == '(' || p[i] == '{' || p[i] == '[')
            s.add(p[i]);
         else {
            char c = s.pop();
            if(c != '(' && p[i] == ')')               
               return false;
            else if(c != '{' && p[i] == '}')
               return false;
            else if(c != '[' && p[i] == ']')
               return false;
         }            
      }
      
      if(s.isEmpty())
         return true;
      else
         return false;
   }
   
   public static void main(String[] args) {
      char[] p = {'(','{','{','}','[',']'};
      
      boolean pMatch = checkMatchingParenthesis(p);
      System.out.println("Parenthesis match: " + pMatch);
   }
}
