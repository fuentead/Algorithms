package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Given a binary tree, print out all of its root-to-leaf
 * paths one per line.
 */
public class TreesPrintAllPaths {
   
   static class Tuple {
      Node left;
      Node right;
      public Tuple(Node left, Node right) {
         this.left = left;
         this.right = right;
      }
   }
   
   static class Node {
      int value;
      Node left;
      Node right;
      
      public Node(int value) {
         this.value = value;
         this.left = null;
         this.right = null;
      }
   }
   
   public static Node addRoot(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Tuple addChildren(Node n, int dataLeft, int dataRight) {
      n.left = new Node(dataLeft);
      n.right = new Node(dataRight);      
      return new Tuple(n.left, n.right);
   }
   
   public static Node addChildrenL(Node n, int dataLeft) {
      n.left = new Node(dataLeft);      
      return n.left;
   }
   
   public static Node addChildrenR(Node n, int dataRight) {
      n.right = new Node(dataRight);     
      return n.right;
   }
   
   /*
    * Depth first search can be used to print all nodes
    * 
    * Using depth first search to print all the paths
    */
   public static void printAllTreePaths(Node n) {
      if(n==null)
         return;
      
      Stack<Node> s = new Stack<Node>();
      s.add(n);
      while(!s.isEmpty()) {
         Node temp = s.pop();
         if(temp != null) {
            System.out.print(temp.value + " ");
            s.push(temp.right);
            s.push(temp.left);
         }
      }
   }

   public static void main(String[] args) {
      Node root = addRoot(5);
      Tuple t = addChildren(root, 3, 8);
      addChildren(t.left, 1, 4);
      addChildren(t.right, 6, 10);
      
      printAllTreePaths(root);
   }
}
