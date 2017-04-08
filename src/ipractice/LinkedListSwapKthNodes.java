package ipractice;

/**
 * @author Adriana Fuentes
 *
 */
public class LinkedListSwapKthNodes {
   
   static class Node {
      int value;
      Node next;
      
      Node(int value) {
         this.value = value;
         this.next = null;
      }
   }
   
   public static int findLength(Node head) {
      if(head == null)
         return 0;
      
      Node tmp = head;
      int len = 0;
      while(tmp != null) {
         len++;
         tmp = tmp.next;
      }
      return len;
   }
   
   public static Node swap(Node head, int lindex, int rindex) {
      Node lfwdtmp, lbcktmp, rfwdtmp, rbcktmp;
      
      Node tmp = head;
      int tmpindex = 0;
      while(tmp != null && tmpindex < lindex-1) {
         tmp = tmp.next;
         tmpindex++;
      }
      lbcktmp = tmp;
      lfwdtmp = tmp.next;
      System.out.println("lbacktmp: " + lbcktmp.value + ", lfwdtmp "+ lfwdtmp.value);
      
      tmp = head;
      tmpindex = 0;
      while(tmp != null && tmpindex < rindex-1) {
         tmp = tmp.next;
         tmpindex++;
      }
      rbcktmp = tmp;
      rfwdtmp = tmp.next;
      System.out.println("rbcktmp: " + rbcktmp.value + ", rfwdtmp "+ rfwdtmp.value);

      
      lbcktmp.next = rfwdtmp;
      tmp = lfwdtmp.next;
      lfwdtmp.next = rfwdtmp.next;
      rbcktmp.next = lfwdtmp;
      rfwdtmp.next = tmp;
      
      return head;
   }
   
   public static Node swapKthNodes(Node head, int k) {
      if(head == null)
         return null;
      
      // Find length of linked list
      int len = findLength(head);    
      
      // Find left index to switch
      int lindex = k-1;
      
      // Find right index to switch. Adding  +1 since null counts
      int rindex = len + 1 - k;
      
      if(lindex == rindex)
         return head;
      else {
         System.out.println("\nlen: " + len + ", lindex: " + lindex + ", rindex: " + rindex );
         Node n = swap(head, lindex, rindex);
         return n;
      }
   }
   
   public static Node createNode(int value) {
      Node n = new Node(value);
      return n;
   }
   
   public static Node createLinkedList(int[] data) {
      if(data.length == 0)
         return null;
      
      Node head = new Node(data[0]);
      Node tmp = head;
      
      for(int i=1; i<data.length; i++) {
         tmp.next = new Node(data[i]);
         tmp = tmp.next;
      }
      return head;
   }
   
   public static void printLL(Node head) {
      if(head == null)
         return;
      
      Node tmp = head;
      while(tmp != null) {
         System.out.print(tmp.value + " ");
         tmp = tmp.next;
      }
   }
   
   public static void main(String[] args) {
      
      // Problem 1
      System.out.println("Problem 1");
      System.out.println("---------");
      int[] data = {1,2,3,4,7};
      Node head1 = createLinkedList(data);
      System.out.print("Initial array: ");
      printLL(head1);
      Node n = swapKthNodes(head1, 2);
      System.out.print("Final result: ");
      printLL(n);
      
      // Problem 2
      System.out.println("\n\nProblem 2");
      System.out.println("---------");
      int[] data2 = {1,2,4,7};
      Node head2 = createLinkedList(data2);
      System.out.print("Initial array: ");
      printLL(head2);
      Node n2 = swapKthNodes(head2, 3);
      System.out.print("Final result: ");
      printLL(n2);
      
      // Problem 3
      System.out.println("\n\nProblem 3");
      System.out.println("---------");
      int[] data3 = {1,2,3,4,7};
      Node head3 = createLinkedList(data3);
      System.out.print("Initial array: ");
      printLL(head3);
      Node n3 = swapKthNodes(head3, 5);
      System.out.print("Final result: ");
      printLL(n3);
   }
}
