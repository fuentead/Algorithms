package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Find the length of the longest substring 
 * (contiguous) that has matching opening and 
 * closing parentheses. We only need length, not
 * the substring itself. You may assume valid 
 * input for the purpose of this exercise i.e.
 * Input string can only have parentheses and 
 * nothing else.
 * 
 * e.g.
 * 1. Input: "((((())(((()", Output: 4
 * 2. Input: "((((", Output: 0
 * 3. Input: "()()()", Output: 6
 * 4. Input: "", Output: 0
 */
public class LinkedListLongestSubstringMatchingParenthesis {
   
   
   public static int findLongestMatchingParenthesis(String s) {
      if(s.length() ==0)
         return 0;
      
      Stack<Integer> stack = new Stack<Integer>();
      
      int maxLen = 0;
      int start = 0;
      int maxStart = 0; 
      int prevStart = 0;
      int size = 0;
      for(int i=0; i<s.length(); i++) {
         if(s.charAt(i) == '(')
            stack.push(i);
         else {
            // Move to the next character
            if(stack.isEmpty()) 
               prevStart = i+1;
            else {
               stack.pop();
               if(stack.isEmpty())
                  start = prevStart - 1;
               else
                  start = stack.peek();
               size = i - start;
               if(size > maxLen) {
                     maxStart = start + 1;
                     maxLen = size;
               }                
            }
         }
      }
      System.out.println("maxStart: " + maxStart + " maxLen: " + maxLen);
      String sMatch = s.substring(maxStart, maxLen + maxStart);
      System.out.println(sMatch);
      return maxLen;
   }
   
   public static void main(String[] args) {
      
      String p = "((((())(((()";
      int res = findLongestMatchingParenthesis(p);
      System.out.println(res);
      
      String p2 = "((((";
      int res2 = findLongestMatchingParenthesis(p2);
      System.out.println(res2);
      
      String p3 = "()()()";
      int res3 = findLongestMatchingParenthesis(p3);
      System.out.println(res3);
   }
}
