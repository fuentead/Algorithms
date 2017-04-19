package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Implement a Min Stack
 * 
 * Your goal for this problem is to implement an 
 * additional method: "getMinimum()" for a stack.
 * The method, as the name suggests, returns the 
 * minimum element in the entire stack. It shouldn't
 * pop that element; it should only peek i.e. return
 * the value. You may implement  methods of the stack 
 * if there is time but focus on getMinimum().
 * 
 * getMinimum() should return in constant time.
 * 
 * Example:
 * 1) If the stack has 1,2,3,4,5 in that order from
 * bottom to top, then the call to getMinimum() should
 * return 1.
 * 2) If the stack has 1,5,3,0 in that order from 
 * bottom to top, then  the call to getMinimum() 
 * should return 0.
 * 3) if the stack is empty, it should return NULL.
 * 
 */
public class LinkedListImplementMinStack {
   
   Stack<Integer> stack; 
   Stack<Integer> minStack;
   
   public LinkedListImplementMinStack() {
      stack = new Stack<Integer>();
      minStack = new Stack<Integer>();
   }
   
   public void push(int num) {
      stack.push(num);      
      if(minStack.isEmpty() || num < minStack.peek()) 
         minStack.push(num);    
   }
   
   public int pop() {
      int num = stack.pop();      
      if(num == minStack.peek()) 
         minStack.pop();      
      return num;
   }

   /*
    * Implementation with min stack.
    * Time Complexity: O(1)
    * Space Complexity: O(n)
    */
   public int getMinimum() {
      if(minStack.size() == 0)
         return -1;
      else
         return minStack.peek();
   }
   
   public static void main(String[] args) {
      LinkedListImplementMinStack s = new LinkedListImplementMinStack();
      int[] data = {2,3,4,5,1,0};
      
      for(int i=0; i< data.length; i++) {
         s.push(data[i]);         
         System.out.print(s.getMinimum() + " ");
      }
      
      s.pop();
      System.out.print(s.getMinimum() + " ");
      
      s.pop();
      System.out.print(s.getMinimum() + " ");
      
      s.push(0);
      System.out.print(s.getMinimum() + " ");
   }
}
