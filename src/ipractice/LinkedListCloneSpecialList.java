package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * You are given a Double Linked List with one pointer of
 * each node pointing to the next node just like a single
 * linked list. The second pointer however can point to 
 * any node in the list and not just the previous node. 
 * Write a program in O(n) time to duplicate this list /
 * create a copy of this list.
 * 
 * Let us call the second pointer as arbit pointer as it 
 * can point to any arbitrary node in the linked list.
 * 
 * Use constant extra memory.
 * 
 *   |---------!|--------!
 *   1 -> 2 -> 3 -> 4 -> 5
 *   !----|!-------------|
 *             !-----|
 */
public class LinkedListCloneSpecialList {

   static class Node {
      int value;
      Node next;
      Node arb;
      
      Node(int val) {
         this.value = val;
         this.next = null;
         this.arb = null;
      }
   }
   
   /* Clone special list solution with extra memory
    * 
    * Space complexity: O(n), using extra memory to store copy.
    * Time complexity: O(n)
    */
   public static Node cloneSpecialList(Node root) {
      Map<Integer, Node> m = new HashMap<Integer, Node>();
      
      Node croot = new Node(root.value);
      m.put(croot.value, croot);
      
      Node temp = root.next;
      Node ctemp =  null;
      Node pctemp = croot;
      while(temp != null) {       
         ctemp =  new Node(temp.value);
         pctemp.next = ctemp;
         pctemp = pctemp.next;
         
         m.put(pctemp.value, pctemp);
         temp = temp.next;         
      }

      temp = root;
      ctemp = croot;
      while(temp != null) {
         int tval = temp.arb.value;         
         Node arbNode = m.get(tval);
         ctemp.arb = arbNode;         
         ctemp = ctemp.next;
         temp = temp.next;
      }
      return croot;
   }
   
   public static Node cloneSpecialListConstantSpace(Node root) {
      Node croot = null;
      Node t = root;

      // Copy values
      while(t != null) {
         Node c = new Node(t.value);
         
         if(croot == null)
            croot = c;
         
         c.next = t.next;
         t.next = c;
         t = c.next;
      } 
            
      // Add arbitrary nodes
      t = root;
      while(t != null) {
         t.next.arb = t.arb.next;
         t = t.next;
         t = t.next;
      }
      
      // Separate two lists
      t = root; 
      while(t != null) {
         t.next = t.next.next;
         t = t.next;
      }
      
      return root;
   }
   
   
   
   public static void printLinkedList(Node root) {
      if(root == null)
         return;      
      Node temp = root;
      while(temp != null) {
         if(temp.arb !=null)
            System.out.println("Val: " + temp.value + " with arb val: " + temp.arb.value);
         else 
            System.out.println("Val: " + temp.value);
         temp = temp.next;
      }
   }
   
   public static void main(String[] args) {
      
      Node root = new Node(1);
      Node n2 = new Node(2);
      Node n3 = new Node(3);
      Node n4 = new Node(4);
      Node n5 = new Node(5);
      
      root.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;
      
      root.arb = n3;
      n3.arb = n5;
      n4.arb = n3;
      n5.arb = n2;
      n2.arb = root;
      
      System.out.println("Copy special list with extra space");
      Node croot = cloneSpecialList(root);
      printLinkedList(croot);
      
      System.out.println("Copy special list with no extra space");
      Node clist = cloneSpecialListConstantSpace(root);
      printLinkedList(clist);
   }
}
