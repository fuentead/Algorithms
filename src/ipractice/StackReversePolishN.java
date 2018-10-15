/**
 * Reverse Polish Notation
 * Write a function that takes in a Reverse Polish Notation (RPN) string and returns an integer.
 * e.g.
 * '40 2 +' -> 42
 * '2 3 -' -> -1
 * '5 4 * 2 /' -> 10
 * '5 4 2 * -' -> -3
 * 
 * Operators: + - * /
 * 40 2 +
 * 2 3 -
 * 
 * 5 4 * => 20, 2 / =>
 * 5 4 2 , * , res = 8
 * 5 , res = 8, => 5-8=-3
 */
package ipractice;

import java.util.Stack;

/**
 * @author Adriana Fuentes
 *
 */
public class StackReversePolishN {

   public static int reversePolish(String s) {
      if(s.length() == 0) 
        return 0;     
      
      Stack<Integer> stack = new Stack<Integer>();
      String[] values = s.split(" ");
      
      int res = Integer.MIN_VALUE;   
      int i = 0; 
      while (i<values.length) {
        String val = values[i];
        if(!val.equals("+") && !val.equals("-")  && !val.equals("*") && !val.equals("/")) {
          int num = Integer.parseInt(val);    
          stack.push(num);
        }
        else {
          int num1; 
          int num2;
          if(res == Integer.MIN_VALUE) {
            num2 = stack.pop(); 
            num1 = stack.pop();            
            res = 0;          
          } else {
            num1 = stack.pop();
            num2 = res;                 
          }        
          
          if (val.equals("+")) {
            res = num1 + num2;
          }
          else if(val.equals("-")) {
            res = num1 - num2;
          }
          else if(val.equals("*")) {
            res = num1 * num2;
          }
          else if(val.equals("/")) {
            res = num2 / num1;
          }
        }
        i++;
      }
      return res;
    }

   public static void main(String[] args) {
      int res1 = reversePolish("40 2 +");
      System.out.println("res1: " + res1);
      
      int res2 = reversePolish("2 3 -");
      System.out.println("res2: " + res2);
      
      int res3 = reversePolish("5 4 * 2 /");
      System.out.println("res3: " + res3);
      
      int res4 = reversePolish("5 4 2 * -");
      System.out.println("res3: " + res4);
   }
}
