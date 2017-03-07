package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of
 * a BST.
 *    1. Calling next() will return the next smallest number
 *       in the BST.
 *    2. Calling hasNext() should return whether the next 
 *       element exists.
 * Both functions should run in average O(1) time and uses O(h) 
 * memory, where h is the height of the tree.
 */
public class TreeIterator {
   
   private Stack<Node> stack;
   private Node next;
   private boolean noExtraSpace;
   
   public TreeIterator(Node root, boolean noSpace) {  
      this.noExtraSpace = noSpace;
      
      // Solution with no extra space
      if(noExtraSpace) {
         if(root == null)
            return;         
         next = root;
         while(next.left != null)
            next = next.left;
      }
      // Solution with extra space
      else {
         stack = new Stack<Node>();
         storeLeftChildren(root);
      }
   }
   
   static class Node {
      int value;
      Node right;
      Node left;
      Node parent;
      boolean visited;
      
      Node(int value) {
         this.value = value;
         this.right = null;
         this.left = null;
         this.parent = null;
         this.visited = false;
      }
   }
   
   static class Tuple {
      Node nleft;
      Node nright;
      
      Tuple(Node nl, Node nr) {
         this.nleft = nl;
         this.nright = nr;
      }
   }
   
   /*
    *  Methods to create tree
    */
   public static Node addTreeRoot(int val) {
      Node r = new Node(val);
      return r;
   }
   
   public static Tuple addChildren(Node n, int lval, int rval) {
      n.left = new Node(lval);
      n.right = new Node(rval);
      n.left.parent = n;
      n.right.parent = n;
      
      Tuple t = new Tuple(n.left, n.right);
      
      return t;
   }
   
   /*
    *  Store left children using a stack
    */
   public void storeLeftChildren(Node n) {
      if(n == null)
         return;
      
      while(n != null) {
         stack.push(n);
         n = n.left;
      }     
   }
   
   public Node next() {
      
      // Solution with no extra space
      if(noExtraSpace) {
         if(!hasNext())
            return null;
         
         Node n = next;
         n.visited = true;
         if(next.right != null) {
            next = next.right;
            while(next.left != null)
               next = next.left;
            return n;
         }
         else {
            if(next.parent == null) {
               next = null;
               return n;
            }
            
            while(next.visited && next.parent != null)
               next = next.parent;
            return n;
         }
      }
      // Solution with extra space
      else {
         Node tmp = stack.pop();
         storeLeftChildren(tmp.right);
         return tmp;
      }
   }
   
   public boolean hasNext() {
      if(noExtraSpace)
         if(next != null && !next.visited)
            return true;
         else
            return false;
      else
         return !stack.isEmpty();
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
   
   public static void main(String[] args) {
      Node root = addTreeRoot(50);
      
      Tuple t1 = addChildren(root, 40, 70);
      addChildren(t1.nleft, 10, 45);
      addChildren(t1.nright, 60, 80);

      System.out.println(" \nPrint Tree with Level Order Traversal: ");
      printTree(root);

      System.out.println(" \nPrint Tree with Iterator: ");
      TreeIterator ti2 = new TreeIterator(root, true);
      while(ti2.hasNext()) {
         int value = ti2.next().value;
         System.out.print(value + " ");
      }
   }
}
