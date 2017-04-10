package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Complete the optimal (Linked List) function
 * so that it checks a Linked List for redundant
 * nodes, removes them, and returns the modified
 * list without altering the order of non-redundant
 * nodes.
 * 
 * Note: A redundant node is a node whose data
 * matches the data of a previous node in the list
 * (e.g.: given some node ni containing data di, if
 * di == dj and i<j, node nj is redundant)
 * 
 * Constraint: Each Linked List input has 10,000 nodes.
 * 0<= di <= 1000
 * 
 * Input Format: A Linked List passed as an argument to 
 * the optimal (Linked List) function.
 * 
 * Output Format: The optimal (Linked List) function 
 * should return the updated (non-redundant) Linked List.
 */
public class LinkedListsDuplicates {
   
   static class Node {
      int value;
      Node next;
      Node(int value) {
         this.value = value;
         this.next = null;
      }
   }
   
   public Node addNode(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Node createLinkedList(int[] data) {
      Node head = new Node(data[0]);
      Node tmp = head;
      for(int i=1; i<data.length; i++) {
         tmp.next = new Node(data[i]);
         tmp = tmp.next;
      }
      return head;
   }
   
   public static void printLinkedList(Node head) {
      Node tmp = head;
      while(tmp != null) {
         System.out.print(tmp.value + " ");
         tmp = tmp.next;
      }
   }
   
   /*
    * Find and remove duplicates using a map
    * Time Complexity: O(n) time
    * Space Complexity: O(n) space
    */
   public static Node findDuplicates(Node head) {
      if(head == null)
         return null;
      
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      Node tmp = head;
      map.put(tmp.value, 1);
      Node prev = tmp;
      tmp = tmp.next;
      
      while(tmp != null) {
         // Current node duplicate, remove
         if(map.containsKey(tmp.value)) {
            prev.next = tmp.next;
            tmp = null;
            tmp = prev.next;  
         }            
         else {
            map.put(tmp.value, 1);
            prev = tmp;
         }
         tmp = tmp.next;
      }
      return head;
   }
   
   public static void main(String[] args) {
      int[] data = {1,2,3,4,5,6,7,7,8,9};
      Node head = createLinkedList(data);
      printLinkedList(head);
      
      System.out.println("\nResult");
      Node h = findDuplicates(head);
      printLinkedList(h);
   }
}
