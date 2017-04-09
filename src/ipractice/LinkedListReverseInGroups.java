package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a linked list, write a function to reverse
 * every k nodes (where k is an input to the function).
 * 
 * Example: 
 * Inputs: 1->2->3->4->5->6->7->8->NULL and K=3
 * Output: 3->2->1->6->5->4->8->7->NULL.
 * 
 * Inputs: 1->2->3->4->5->6->7->8->NULL and K=5
 * Output: 5->4->3->2->1->8->7->6->NULL 
 * 
 */
public class LinkedListReverseInGroups {
   
   static class Node {
      int value;
      Node next;
      Node(int value) {
         this.value = value;
         this.next = null;
      }
   }
   
   public static Node reverse(Node head) {
      if(head == null)
         return null;
      
      Node tnext, tfwd; 
      tnext = head;      
      tfwd = head.next;
      head = tfwd.next;
      tnext.next = null;
      tfwd.next = tnext;
      Node h = tfwd;
      
      while(head.next != null && head.next.next != null) {
         tnext = head;
         tfwd = head.next;
         head = tfwd.next;
         
         tfwd.next = tnext;
         tnext.next = h;
         h = tfwd;
      }
      head.next = tfwd;
      return head;
   }

   public static Node reverseInGroups(Node head, int k) {
      Node tbck, tfwd;
      int cnt = 1;
      tbck = head;
      while(cnt < k) {
         tbck = tbck.next;
         cnt++;
      }
      tfwd = tbck.next;
      tbck.next = null;
      
      Node head2 = tfwd;
      System.out.println("\nlist1");
      printLinkedList(head);
      System.out.println("\nlist2");
      printLinkedList(head2);
      
      head = reverse(head);      
      head2 = reverse(head2);  
      
      // Traverse to last element on first list
      Node tmp = head;
      while(tmp.next != null) {
         tmp = tmp.next;
      }
      tmp.next = head2;
      return head;
   }
   
   public static Node createNode(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Node createLinkedList(int[] data) {
      Node head = new Node(data[0]);
      Node tmp = head;
      
      for(int i=1; i<data.length; i++) {
         tmp.next = createNode(data[i]);
         tmp = tmp.next;
      }
      return head;
   }
   
   public static void printLinkedList(Node h) {
      Node tmp = h;
      while(tmp != null) {
         System.out.print(tmp.value + " ");
         tmp = tmp.next;
      }
   }
   
   public static void main(String[] args) {
      int[] data = {1,2,3,4,5,6,7,8};
      Node head = createLinkedList(data);
         
      System.out.println("\nProblem 1");
      Node h = reverseInGroups(head, 3);
      System.out.println("\nResult Problem 1");
      printLinkedList(h);
      
      System.out.println("\nProblem 2");
      Node head2 = createLinkedList(data);
      Node h2 = reverseInGroups(head2, 5);
      System.out.println("\nResult Problem 2");
      printLinkedList(h2);     
   }
}
