package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Super Stack:
 * Implement a simple stack that accepts the following commands
 * and performs the operations associated with them:
 * - push k: push integer k onto the top of the stack
 * - pop: pop the top element from the stack. It is guaranteed that
 * this will not be called on an empty stack.
 * - inc e k: Add k to each of the bottom e elements of the stack.
 * 
 * If the stack is empty, print EMPTY instead.
 * 
 * Input Format:
 * Locked stub code. The first line contains an integer n indicating the 
 * number of operations to perform.
 * 
 * Output:
 * After performing each operation, print value of stack's top element on 
 * a new line. If the stack is empty, print EMPTY instead.
 * 
 */
public class LinkedListSuperStack {
   
   public List<Integer> stack;
   private Map<Integer, Integer> hm;
   private int size;

   public LinkedListSuperStack() {
      this.stack = new LinkedList<Integer>();
      this.hm = new HashMap<Integer, Integer>();
      this.size = 0;
   }
   
   public int size() {
      return size;
   }
   
   public int peek() {
      int val = stack.get(size-1);
      if(hm.containsKey(size))
         val = val + hm.get(size);
      return val;     
   }
   
   public int pop() {
      if(size == 0) {
         System.out.println("EMPTY");
         return -1;
      }
         
      int val = stack.get(size-1);
      if(hm.containsKey(size))
         val = val + hm.get(size);
      hm.remove(size);
      stack.remove(size-1);
      size--;
      return val;
   }
   
   public void push(int value) {
      stack.add(value);
      size++;
   }
   
   /*
    * Add e to the bottom k elements of the stack
    * level - stack level
    * k - number to be added
    */
   public void inc(int level, int k) {
      if(hm.containsKey(level)) 
         hm.put(level, k + hm.get(level));
      else
         hm.put(level, k);
      
      for(int i = 1; i<level; i++) {
         if(hm.containsKey(i))
            hm.put(i,k + hm.get(i));
         else
            hm.put(i, k);
      }
   }

   public static void main(String[] args) {
     LinkedListSuperStack stack = new LinkedListSuperStack();
     
     stack.push(4);
     stack.push(5);
     stack.push(7);
     int val = stack.peek();
     System.out.println(val);
     
     stack.inc(2, 1);
     int val2 = stack.pop();
     System.out.println(val2);
     
     int val3 = stack.pop();
     System.out.println(val3);
     
     int val4 = stack.pop();
     System.out.println(val4);
     
     stack.pop();
     
   }
}
