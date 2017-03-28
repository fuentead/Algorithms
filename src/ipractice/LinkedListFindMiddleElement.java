package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Find the middle element of a singly linked
 * list.
 * Constraint: Do it in one pass over the list.
 * If it is even number of elements, then output
 * the 2nd of the middle two elements.
 * 
 * Examples
 * 1->2->3->null, answer=2
 * 1->11->45->12->67->89->91->null, answer 12 
 * 1->11->45->12->67->89->null, answer 12
 * null, answer null
 */
public class LinkedListFindMiddleElement {
   
   static class Node {
      int value;
      Node next;
      Node(int value) {
        this.value = value;
        this.next = null;
      }
   }

   public static int findMiddleElement(Node n) {
      if(n == null)
         return 0;    
      Node nprev = n, nnext = n.next;
      while((nnext != null)) {
         nprev = nprev.next;
         if(nnext.next == null)
            nnext = nnext.next;
         else
            nnext = nnext.next.next;
      }
      return nprev.value; 
   }
   
   public static Node addNode(Node n, int nextval) {
      n.next = new Node(nextval);
      return n.next;
   }
   
   public static void printLL(Node n) {
      if(n == null) {
         System.out.print("null ");
         return;     
      }
      Node tmp = n;
      while(tmp != null) {
         System.out.print(tmp.value + " ");
         tmp = tmp.next;
      }
   }
   
   public static void main(String[] args) {
      
      // Example 1, 1->2->3->null, answer=2
      Node root = new Node(1);
      Node tmp = addNode(root, 2);
      tmp = addNode(tmp, 3);
      printLL(root);
      int midval = findMiddleElement(root);
      System.out.println("midval: " + midval);
      
      // Example 2,  1->11->45->12->67->89->91->null, answer 12 
      Node root2 = new Node(1);
      Node tmp2 = addNode(root2, 11);
      tmp2 = addNode(tmp2, 45);
      tmp2 = addNode(tmp2, 12);
      tmp2 = addNode(tmp2, 67);
      tmp2 = addNode(tmp2, 89);
      tmp2 = addNode(tmp2, 91);
      printLL(root2);
      int midval2 = findMiddleElement(root2);
      System.out.println("midval: " + midval2);
      
      // Example 3, 1->11->45->12->67->89->null, answer 12
      Node root3 = new Node(1);
      Node tmp3 = addNode(root3, 11);
      tmp3 = addNode(tmp3, 45);
      tmp3 = addNode(tmp3, 12);
      tmp3 = addNode(tmp3, 67);
      tmp3 = addNode(tmp3, 89);
      printLL(root3);
      int midval3 = findMiddleElement(root3);
      System.out.println("midval: " + midval3);
      
      // Example 4, null
      Node root4 = null;
      int midval4 = findMiddleElement(root4);
      printLL(root4);
      System.out.println("midval: " + midval4);
   }
}
