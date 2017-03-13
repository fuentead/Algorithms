
package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Give a binary tree (represented by its root node,
 * like usual), clone it. Return the root of the cloned
 * tree.
 * 
 * Tips: cloning or copying tree is best done recursively.
 * BFS could get complicated to handle implementation.
 */
public class TreeCloneBinaryTree {
   
   static class Node {
      int value;
      Node left;
      Node right;
      
      Node(int value) {
         this.value = value;
         this.left = null;
         this.right = null;
      }
   }
   
   static class Tuple {
      Node left;
      Node right;
      Tuple() {
         this.left = null;
         this.right = null;        
      }
   }
   
   public static Node addRoot(int val) {
      Node root = new Node(val);
      return root;
   }
   
   public static Tuple addChildren(Node root, int lval, int rval) {
      Tuple t = new Tuple();
      root.left = new Node(lval);
      root.right = new Node(rval);
      t.left = root.left;
      t.right = root.right;
      return t;
   }
   
   /*
    * Clone binary tree solution with recursion
    * 
    * Time Complexity: O(n) since copying every node.
    * Space Complexity: O(n) since using stack for recursion.
    */
   public static Node cloneBinaryTree(Node root) {      
      if(root == null)
         return null;
      
      Node cnode = new Node(root.value);
      cnode.left = cloneBinaryTree(root.left);
      cnode.right = cloneBinaryTree(root.right);
      return cnode;
   }
   
   /*
    * Breath first search tree printing
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
   
   public static void main(String[] args) {
      // Create tree
      Node root = addRoot(40);
      Tuple t1 = addChildren(root, 30, 60);
      addChildren(t1.left, 15, 35);
      addChildren(t1.right, 50, 70);
      System.out.println(" Original Tree");
      printTree(root);
      
      // Clone Tree
      Node croot = cloneBinaryTree(root);
      System.out.println("\nCopy Tree");
      printTree(croot);
   }
}
