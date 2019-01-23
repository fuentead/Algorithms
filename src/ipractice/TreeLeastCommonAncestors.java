package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Let T be a rooted tree. The lowest common ancestor
 * between two nodes n1 and n2 is defined as the lowest
 * node in T that has both n1 and n2 as descendants.
 * 
 * The LCA of n1 and n2 in T is the shared ancestor of n1 
 * and n2 that is located farthest from the root. Computation
 * of lowest common ancestors may be useful, for instance, as 
 * part of a procedure for determining the distance between 
 * pairs of nodes in a tree: the distance from n1 to n2
 * can be computed as the distance from the root to n1, plus
 * the distance from the root to n2, minus twice the distance 
 * from the root to their lowest common ancestor.
 * 
 * Design and write an algorithm to find the LCA node, given 
 * two nodes in a Binary Tree.
 *  - The tree may or may not be a BST
 *  - Assume a Node structure that has NO parent pointer
 *  - Assume that the two nodes are distinct and exist in the tree
 *  - Find a solution that has a runtime complexity of O(N). N is
 *  # of nodes in the tree.
 *  
 *  Given the following tree:
 *  
 *                 45
 *               /    \
 *              25     65
 *             / \     /  \
 *            15  30  55   75
 *           / \     / \   / \
 *          10  20  50 60 70 80
 *  
 *  FindLCA(10,20) = 15
 *  FindLCA(50,80) = 65
 *  FindLCA(20,60) = 45
 *  
 *  Desired solution: O(N) time.
 */
public class TreeLeastCommonAncestors {
   
   static class Result {
      boolean isLCAncestor;
      Node node;
      
      public Result(boolean isLCAncestor, Node n) {
         this.isLCAncestor = isLCAncestor;
         this.node = n;
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
   
   static class Tuple {
      Node left;
      Node right;
      public Tuple(Node l, Node r) {
         this.left = l;
         this.right = r;
      }
   }
   
   public static Node addRoot(int n) {
      Node root = new Node(n);
      return root;
   }
   
   public static Tuple addChildren(Node n, int l, int r) {
      n.left = new Node(l);
      n.right = new Node(r);
      
      Tuple t = new Tuple(n.left, n.right);
      return t;
   }
   
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
   
   public static Node findLeastCommonAncestor(Node root, int n1, int n2) {
      Result r = findLeastCommonAncestorHelper(root, n1, n2);
      if(r.isLCAncestor) 
         return r.node;
      
      return null;
   }
   
   private static Result findLeastCommonAncestorHelper(Node root, int n1, int n2) {
      if(root == null)
         return new Result(false, null);  
      
      else if(root.value == n1 || root.value == n2)
         return new Result(false, root);
      
      else {
         Result r1 = findLeastCommonAncestorHelper(root.left, n1, n2);
         if(r1.isLCAncestor)
            return r1;
         
         Result r2 = findLeastCommonAncestorHelper(root.right, n1, n2);
         if(r2.isLCAncestor) 
            return r2;
            
         else if(r1.node != null && r2.node != null)
            return new Result(true, root);
         else 
            return r1.node != null ? r1 : r2;
      }
   }
      
   public static void main(String[] args) {
      Node root = addRoot(45);
      Tuple t2 = addChildren(root, 25, 65);
      Tuple t3l = addChildren(t2.left, 15, 30);
      Tuple t3r = addChildren(t2.right, 55, 75);
      addChildren(t3l.left, 10, 20);
      addChildren(t3r.left, 50, 60);
      addChildren(t3r.right, 70, 80);
      
      printTree(root);
      
      Node n = findLeastCommonAncestor(root, 10, 20);
      System.out.println("\nResult " + n.value);
      
      Node n2 = findLeastCommonAncestor(root, 50, 80);
      System.out.println("\nResult " + n2.value);
      
      Node n3 = findLeastCommonAncestor(root, 20, 60);
      System.out.println("\nResult " + n3.value);
   }
}
