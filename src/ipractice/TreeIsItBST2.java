package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Given a Binary Tree, check if it is a Binary Search Tree (BST).
 * A valid BST doesn't have to complete or balanced. Duplicate 
 * elements are not allowed in a BST. 
 */
public class TreeIsItBST2 {
   
   static class Tuple {
      Node left;
      Node right;
      public Tuple(Node left, Node right) {
         this.left = left;
         this.right = right;
      }
   }
   
   static class Node {
      int  value;
      Node left;
      Node right;
      
      public Node(int value) {
         this.value = value;
         this.left = null;
         this.right = null;
      }
   }
   
   public static Node addRoot(int val) {
      Node r = new Node(val);
      return r;
   }
   
   public static Tuple addChildren(Node root, int nleft, int nright) {
      root.left = new Node(nleft);
      root.right = new Node(nright);      
      return new Tuple(root.left, root.right);     
   }
   
   public static Node addChildL(Node root, int nleft) {
      root.left = new Node(nleft); 
      return root.left;    
   }
   
   public static Node addChildR(Node root, int nright) {
      root.right = new Node(nright);
      return root.right;
   }
   
   /*
    * Print Tree with level order traversal,
    * breath first search. 
    */
   public static void printTree(Node root) {
      if(root == null)
         return;
      
      Queue<Node> q = new LinkedList<Node>();
      
      q.add(root);
      while(!q.isEmpty()) {
         Node n = q.poll();
         if(n != null) {
            System.out.print(n.value + " ");
            q.add(n.left);
            q.add(n.right);
         }
      }
   }
   
   /*
    * Check if tree is BST using a recursive routine.
    * 
    * Range can be used to check if each node in the tree is within
    * the limited values.
    * 
    * Time Complexity O(2^n) - two recursive calls
    * Space Complexity O(2n), recursive stack usage.
    * 
    */
   public static boolean isItBSTRange(Node root, int rangeMinVal, int rangeMaxVal) {     
      if(root == null)
         return true;
      
      System.out.print("\n" + root.value + " => rangeMinVal: " + rangeMinVal + ", rangeMaxVal: " + rangeMaxVal );

      if((rangeMinVal < root.value) && (root.value < rangeMaxVal))
         return isItBSTRange(root.left, rangeMinVal, root.value) && isItBSTRange(root.right, root.value, rangeMaxVal);
      else
         return false;         
   }
   
   public static boolean isItBST(Node root) {
      if(root == null)
         return false;     
      return isItBSTRange(root.left, Integer.MIN_VALUE, root.value) && isItBSTRange(root.right, root.value, Integer.MAX_VALUE);
   }
   
   public static void main(String[] args) {

      Node root = addRoot(8);
      Tuple t1 = addChildren(root, 6, 10);
      Tuple t2 = addChildren(t1.left, 4, 7);
      Node n1 = addChildR(t1.right, 14);
      addChildL(t2.left, 1);
      addChildR(t2.right, 9);
      addChildL(n1, 13);  
      
      printTree(root);
      
      boolean result = isItBST(root);
      System.out.print("\n" + result);
   }
}
