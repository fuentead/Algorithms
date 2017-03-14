package ipractice;

import java.util.*;
/**
 * @author Adriana Fuentes
 * 
 * Populate sibling pointers
 * Given a full binary tree, populate the nextRight pointers in each node.
 * 
 * Full binary tree = every node other than leaves has two children.
 *
 */
public class TreesPopulateSiblingsPointers {

   static class Node {
      int value;
      Node right;
      Node left;
      Node nextRight;
      boolean visited;
      
      Node(int value) {
         this.value = value;
         this.right = null;
         this.left = null;
         this.nextRight = null;
         this.visited = false;
      }
   }
   
   static class Tuple {
      Node right;
      Node left;    
      
      Tuple(Node l, Node r) {
         this.left = l;
         this.right = r;
      }
   }
   
   static class TupleP {
      Node n;
      String position;  
      
      TupleP(Node n, String p) {
         this.n = n;
         this.position = p;
      }
   }
   
   public static Node addRoot(int value) {
      Node root = new Node(value);
      return root;
   }
   
   public static Tuple addChildren(Node n, int lvalue, int rvalue) {
      n.left = new Node(lvalue);
      n.right = new Node(rvalue);
      
      Tuple t = new Tuple(n.left, n.right);
      return t;
   }
   
   public static void printPopulatedTree(Node root) {
      if(root == null)
         return;
      
      Queue<TupleP> q = new LinkedList<TupleP>();
      q.add(new TupleP(root,"root"));
      while(!q.isEmpty()) {
         TupleP t = q.poll();
         if(t.n!=null) {
            System.out.println(t.n.value + ":" + t.position);
            if(!t.position.contains("nextRight")) {
               q.add(new TupleP(t.n.left, "left of " + Integer.toString(t.n.value)));
               q.add(new TupleP(t.n.right, "right of " + Integer.toString(t.n.value)));
               q.add(new TupleP(t.n.nextRight, "nextRight of " + Integer.toString(t.n.value)));
            }
         }
      }
   }

   public static Node populateSiblings(Node n) {
      if(n == null)
         return null;
      
      Node nleft = populateSiblings(n.left);
      Node nright = populateSiblings(n.right);
      
      if(nleft !=null && nright !=null) {
         nleft.nextRight = nright; 
     
         if(nleft.right != null && nright.left != null)
         nleft.right.nextRight = nright.left;
      }
      
      return n;
   }
   
   public static void main(String[] args) {
      
      // Create tree
      Node root = addRoot(50);
      Tuple t1 = addChildren(root, 40, 60);
      addChildren(t1.left, 20, 45);
      addChildren(t1.right, 55, 70);
      printPopulatedTree(root);
          
      // Populate siblings
      System.out.println("\n Populated Tree");
      populateSiblings(root);
      printPopulatedTree(root);
   }
}
