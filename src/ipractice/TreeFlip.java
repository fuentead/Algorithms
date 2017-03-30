package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Reverse a general binary tree.
 * Flip it from right to left.
 */
public class TreeFlip {
   
   static class Node {
      int value;
      Node right;
      Node left;     
      Node(int value) {
         this.value = value;
      }
   }
   
   static class Tuple {
      Node right;
      Node left;
      Tuple(Node left, Node right) {       
         this.left = left;
         this.right = right;
      }
   }
   
   public static Node addNode(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Tuple addChildren(Node n, int lval, int rval) {
      n.left = addNode(lval);
      n.right = addNode(rval);
      Tuple t = new Tuple(n.left, n.right);
      return t;
   }

   public static void printTree(Node n) {
      if(n == null)
         return;
      
      Queue<Node> q = new LinkedList<Node>();
      q.add(n);
      while(!q.isEmpty()) {
         Node tmp = q.poll();
         if(tmp != null) {
            System.out.print(tmp.value + " ");
            q.add(tmp.left);
            q.add(tmp.right);
         }
      }
   }
   
   public static void reverseBinaryTree(Node n) {
      if(n == null)
         return;
      
      Node tmp = n.left;
      n.left = n.right;
      n.right = tmp;
      reverseBinaryTree(n.left);
      reverseBinaryTree(n.right);
   }
   
   public static void main(String[] args) {
      
      Node root = addNode(6);
      Tuple t1 = addChildren(root, 3, 4);
      addChildren(t1.left, 7, 3);
      addChildren(t1.right, 8, 1);
      
      System.out.println("Original Tree");
      printTree(root);
      
      reverseBinaryTree(root);
      
      System.out.println("\nReversed Tree");
      printTree(root);
   }
}
