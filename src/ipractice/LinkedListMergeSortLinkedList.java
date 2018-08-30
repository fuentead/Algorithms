package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Mergesort a linked list
 */
public class LinkedListMergeSortLinkedList {
   
   static class Node {
      int value;
      Node next;
      Node(int value) {
         this.value = value;
         this.next = null;
      }      
   }
   
   public static Node addNode(Node n, int v) {
      Node tn = new Node(v);
      n.next = tn;
      return tn;
   }
   
   public static Node createLinkedList(int[] data) {
      if(data.length == 0)
         return null;
      
      Node head = new Node(data[0]);
      Node temp = head;      
      int index = 1;
      while(index < data.length) {
         temp = addNode(temp, data[index]);
         index++;
      }
      return head;
   }
   
   public static void printLinkedList(Node n) {
      if(n == null)
         return;
      Node temp = n;
      while(temp != null) {
         System.out.print(temp.value + " ");
         temp = temp.next;
      }
   }

   public static int size(Node head) {
      Node temp = head;     
      int size = 0;
      while(temp != null) {
         temp = temp.next;
         size++;
      }
      return size;
   }
   
   public static Node merge(Node h1, Node h2) {
      if(h1 == null)
         return h2;
      else if(h2==null)
         return h1;
      
      Node t1 = h1;
      Node t2 = h2;
      Node head = null;
      Node trav = null;
      
      if(t1.value < t2.value) {
         head = t1;
         t1 = t1.next;
      }
      else {
         head = t2;
         t2 = t2.next;
      }
      trav = head;
      
      while(t1 != null && t2 != null) {
         if(t1.value < t2.value) {
            trav.next = t1;
            trav = trav.next;
            t1 = t1.next;
         }
         else {
            trav.next = t2;
            trav = trav.next;
            t2 = t2.next;
         }
      }
      
      while(t1 != null) {
         trav.next = t1;
         trav = trav.next;
         t1 = t1.next;
      }
      
      while(t2 != null) {
         trav.next = t2;
         trav = trav.next;
         t2 = t2.next;
      }
      
      trav.next = null;     
      return head;
   }
   
   public static Node mergeSortLinkedList(Node head) {      
      if(head == null)
         return null;
      
      int size = size(head);
      if(size == 1)
         return head;    
      
      // Partition list  
      Node head2;
      if(size == 2) {
         head2 = head.next;
         head.next = null;
      }
      else {
         Node slow = head;
         Node fast = head;
         while(fast != null && fast.next !=null) {
            slow = slow.next;
            fast = fast.next.next;
         }
         head2 = slow.next;
         slow.next = null;
      }
      
      // Mergesort
      Node h1 = mergeSortLinkedList(head);
      Node h2 = mergeSortLinkedList(head2);
      
      // Merge
      Node h = merge(h1, h2);   
      return h;     
   }
   
   public static void main(String[] args) {
      int[] data = {1, 7, 9, 11, 50, 5, 3};   
      Node root = createLinkedList(data);     
      Node r = mergeSortLinkedList(root);
      printLinkedList(r);
   }
}
