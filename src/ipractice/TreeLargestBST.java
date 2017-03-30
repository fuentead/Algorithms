package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a binary tree, find the largest 
 * Binary Search Tree (BST), where largest
 * means BST with largest number of nodes 
 * in it. The largest BST must include all 
 * of its descendants.
 */
public class TreeLargestBST {

   static class Node {
      int value;
      Node right;
      Node left;
      Node(int value) {
         this.value = value;
         this.right = null;
         this.left = null;
      }
   }
   
   static class Tuple {
      Node right;
      Node left;
      Tuple (Node lnode, Node rnode) {
         this.left = lnode;
         this.right = rnode;
      }
   }
   
   static class Result {
      int height;
      Node n;
      boolean isBST;     
      Result(int h, Node n, boolean isBST) {
         this.height = h;
         this.n = n;
         this.isBST = isBST;
      }
   }
   
   public static Node addNode (int val) {
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
   
   public static Result findLargestBST(Node n, int lrange, int rrange) {
      if(n == null)
         return new Result(1, n, true);
           
      if(n.value > lrange && n.value < rrange) {
         Result lres = findLargestBST(n.left, lrange, n.value);
         Result rres = findLargestBST(n.right, n.value, rrange);
         
         if(lres.isBST && rres.isBST) {
            if(lres.height == rres.height) {
               lres.height = lres.height+1;
               lres.n = n;
               return lres;
            }
            else {
               if(lres.height > rres.height)
                  return lres;
               else
                  return rres;
            }
         }
         else if(lres.isBST) {
            lres.isBST = false;
            return lres;
         }
         else if(rres.isBST) {
            rres.isBST = false;
            return rres;
         }
         else {
            if(lres.height > rres.height)
               return lres;
            else 
               return rres;
         }
      }
      else {
         return new Result(0, n, false);
      }         
   }
   
   public static Node findLargestBST(Node n) {
      if(n == null)
         return null;
      
      Result res = findLargestBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);      
      return res.n; 
   }
   
   public static void main(String[] args) {
      Node root = addNode(50);
      Tuple t1 = addChildren(root, 40, 90);
      addChildren(t1.left, 30, 70);
      addChildren(t1.right, 60, 100);

      printTree(root);
      
      Node n = findLargestBST(root);
      System.out.println("Largest BST root: " + n.value);
      System.out.println("Full Tree ");
      printTree(n);     
   }
}
