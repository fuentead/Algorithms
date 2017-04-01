
package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a binary tree, count number of 
 * unival subtrees (all nodes that have
 * same value).
 * 
 * Example: the following tree has 6 unival 
 * trees. Leafs are counted as one tree.
 *           5
 *          / \
 *         5   5
 *        /\    \
 *       5  5    5
 */
public class TreeSingleValue {
   
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
      Tuple(Node left, Node right) {
         this.left = left;
         this.right = right;
      }     
   }
   
   static class Result {
      int univalTreeCnt;
      boolean areBothChildrenUnival;
      
      Result() {
         this.univalTreeCnt = 0;
         areBothChildrenUnival = false;
      }
   }
   
   public static Node addRoot(int val) {
      Node n = new Node(val);
      return n;
   }
   
   public static Tuple addChildren(Node n, int lval, int rval) {
      if(lval != -1)
         n.left = new Node(lval);
      if(rval != -1)
         n.right = new Node(rval);      
      Tuple t = new Tuple(n.left, n.right);
      return t;
   }
   
   public static Result countSingleValueTrees(Node n) {

      Result r = new Result();
      if(n == null) {
         r.areBothChildrenUnival = true;
         r.univalTreeCnt = 0;
         return r;        
      }
      
      Result leftR = countSingleValueTrees(n.left);
      Result rightR = countSingleValueTrees(n.right);
      
      if(n.left == null || n.right == null) {
         r.areBothChildrenUnival = true;
         r.univalTreeCnt = 1;
         return r; 
      }
      
      if((leftR.areBothChildrenUnival && rightR.areBothChildrenUnival) &&
         (n.left.value == n.right.value && n.left.value == n.value)) {
         r.univalTreeCnt = leftR.univalTreeCnt + rightR.univalTreeCnt + 1;
         r.areBothChildrenUnival = true;        
      }
      else if(leftR.areBothChildrenUnival && n.right == null) {
         r.univalTreeCnt = leftR.univalTreeCnt;
         r.areBothChildrenUnival = true;
      }
      else if(rightR.areBothChildrenUnival && n.left == null) {
         r.univalTreeCnt = rightR.univalTreeCnt;
         r.areBothChildrenUnival = true;
      }
      else {
         r.univalTreeCnt = leftR.univalTreeCnt + rightR.univalTreeCnt;
         r.areBothChildrenUnival = false;        
      }
      return r;
   }

   public static int singleValueTree(Node n) {
     if(n == null)
        return 0;    
     
     Result r = countSingleValueTrees(n);
     return r.univalTreeCnt;
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
   
   public static void main(String[] args) {
      Node root = addRoot(5);
      Tuple t1 = addChildren(root, 5, 5);
      addChildren(t1.left, 5, 5);
      addChildren(t1.right, -1, 5);
      
      printTree(root);
      
      int res = singleValueTree(root);
      System.out.print("Result: " + res);
   }
}
