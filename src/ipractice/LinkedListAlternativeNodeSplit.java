
package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Given a linked list, split it into two such that every
 * other node goes into the new list. For lists with odd
 * number of nodes, first one should be longer. For example:
 * an input list: {a, b, c, d, e, f, g} results in {a, c, e, g}
 * and {b, d, f}
 */
public class LinkedListAlternativeNodeSplit {

   static class Node {
      Node next;
      char val;      
      Node(char val) {
         this.val = val;
         this.next = null;
      }
   }
   
   static class Tuple {
      Node root1;
      Node root2;     
      Tuple(Node r1, Node r2) {
         this.root1 = r1;
         this.root2 = r2;
      }
   }
   
   public static Tuple alternativeNodeSplit(Node root) {
      if(root == null)
         return null;
      
      Node tmp = root;
      Node ntmp = root.next;
      Node root1  = null;
      Node root2 = null;
      Node t1 = null;
      Node t2 = null;
      while(ntmp != null ) {
        if(root1 == null) {
           t1 = tmp;
           root1 = t1;
           t2 = ntmp;
           root2 = t2;          
        }
        else {
           t1.next = tmp;
           t2.next = ntmp;
           t1 = t1.next;
           t2 = t2.next;
        }
        tmp = ntmp.next;       
        ntmp = tmp.next;
      }
      t2.next = null;

      while(tmp != null) {
         t1.next = tmp;
         t1 = t1.next;
         tmp = tmp.next;
      }
      t1.next = null; 
      return new Tuple(root1, root2);
   }
   
   public static void print(Node root) {
      Node tmp = root;
      while(tmp != null) {
         System.out.print(tmp.val + " ");
         tmp = tmp.next;
      }
   }
   
   public static void main(String[] args) {
      char[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
      Node root = new Node(data[0]);
      
      Node tmp = root;
      int i = 1;
      while(i < data.length) {
         tmp.next = new Node(data[i]); 
         tmp = tmp.next;
         i++;
      }
      
      print(root);
      
      Tuple t = alternativeNodeSplit(root);
      System.out.println("\nList 1");
      print(t.root1);
      System.out.println("\nList 2");
      print(t.root2);
   }
}
