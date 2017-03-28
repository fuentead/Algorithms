package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Calculate the diameter of a binary tree. 
 * Diameter is the longest between two leaves of a tree.
 * A path is the sum total of all distances (weights) attached to 
 * all edges between two nodes.
 */
public class RecursionDiameterBinaryTree {

   static class Node {
      int value;      
      Node left;
      Node right;  
      
      Node(int val) {
         this.value = val;
         this.left = null;
         this.right = null;
      }
   }
   
   static class Tuple {
      Node left;
      Node right;     
      Tuple(Node nleft, Node nright) {
         this.left = nleft;
         this.right = nright;
      }
   }
   
   public static void printTree(Node r) {
      if(r == null)
         return;  
      
      Queue<Node> q = new LinkedList<Node>();
      q.add(r);
      while(!q.isEmpty()) {
         Node tmp = q.poll();
         if(tmp != null) {
            System.out.print(tmp.value + " ");
            q.add(tmp.left);
            q.add(tmp.right);
         }
      }
   }
   
   public static Node addRoot(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Tuple addChildren(Node n, int lval, int rval) {
      n.left = new Node(lval);
      n.right = new Node(rval);
      Tuple t = new Tuple(n.left, n.right);
      return t;
   }
   
   private static int max(int maxDiaL, int maxDiaR, int DepthLR) {
      int tmp = Math.max(maxDiaL, maxDiaR);     
      int max = Math.max(tmp, DepthLR);
      return max;
   }
   
   private static int maxDepth(Node n, boolean isParent) {
      if(n == null)
         return 0; 
      
      if(isParent) 
         return Math.max(maxDepth(n.left, false), maxDepth(n.right, false));
      else
         return n.value + Math.max(maxDepth(n.left, false), maxDepth(n.right, false));
   }
   
   public static int maxDiameter(Node n) {
      if(n.right == null && n.left == null)
         return 0;      
      return max(maxDiameter(n.left), maxDiameter(n.right), n.right.value + n.left.value + maxDepth(n.left, true) + maxDepth(n.right, true));
   }
   
   public static void main(String[] args) {
      
      Node root = addRoot(0);
      Tuple t1 = addChildren(root, 1, 1);
      addChildren(t1.right, 100, 100);
      
      int maxDia = maxDiameter(root);
      System.out.println(maxDia);
   }
}
