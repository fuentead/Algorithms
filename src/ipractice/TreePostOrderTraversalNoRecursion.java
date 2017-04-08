package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Write a function to traverse a Binary tree 
 * PostOrder, without using recursion. Print nodes 
 * as traversing.
 */
public class TreePostOrderTraversalNoRecursion {

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
      Tuple (Node left, Node right) {
         this.right = right;
         this.left = left;
      }
   }
   
   static class Result {
      Node n;
      boolean childrenChecked;
      Result(Node n) {
         this.n = n;
         childrenChecked = false;
      }
   }
   
   public static Node addNode(int value) {
      Node n = new Node(value);
      return n;
   }
   
   public static Tuple addChildren(Node n, int lval, int rval) {
      n.left = new Node(lval);
      n.right = new Node(rval);
      Tuple t = new Tuple(n.left, n.right);
      return t;
   }
   
   public static void printBFSTree(Node n) {
      if(n == null)
         return;   
      
      Queue<Node> q = new LinkedList<Node>();
      Node tmp = n;
      q.add(tmp);
      while(!q.isEmpty()) {
         tmp = q.poll();
         if(tmp != null) {            
            System.out.print(tmp.value + " ");
            q.add(tmp.left);
            q.add(tmp.right);
         }
      }
   }
   
   public static void printPostOrder(Node n) {
      if(n == null)
         return;
      
      Stack<Result> s = new Stack<Result>();
      Node tmp = n;
      s.push(new Result(tmp));
      while(!s.isEmpty()) {
         Result r = s.pop();
         if(r != null) {
            if(r.childrenChecked)
               System.out.print(r.n.value + " ");
            else if(r.n.left == null && r.n.right == null) {
               System.out.print(r.n.value + " ");
            }
            else {
               r.childrenChecked = true;
               s.push(r);
               s.push(new Result(r.n.right));
               s.push(new Result(r.n.left));
            }            
         }
      }
   }
    
   public static void main(String[] args) {
      Node root = addNode(60);
      Tuple t1 = addChildren(root, 40, 80);
      addChildren(t1.left, 30, 50);
      addChildren(t1.right, 70, 90);
      
      System.out.println("BFS");
      printBFSTree(root);
      
      System.out.println("\nPost Order Traversal");
      printPostOrder(root);
   }
}
