package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Calculate the diameter of a tree (not necessarily a binary tree).
 * Diameter is the longest path between two leaves of a tree. A path
 * is the sum total of all distances (weights) attached to all edges
 * between the nodes.
 * 
 * A tree is represented in a specific notation
 * {0,1,{5,0}}
 * - It starts with root (0), which has (1) child, which will follow in 
 * braces.
 * - Inside the braces, it says that the distance (weight) of reaching 
 * that first child is 5 and that there are no more children after that (0)
 * 
 * Some examples:
 * - One node, no diameter
 *    ("{0,0}", 0)
 * - One leaf
 *    ("{0,1,{5,0}}", 5)
 * - Still one leaf
 *    ("{0,1,{5,1,{4,1,{7,0}}}}", 16)
 * - Diameter of first son is the diameter of the tree
 *    ("{0,1,{5,2,{8,0},{7,0}}}", 15)
 * - Diameter of last son is the diameter of the tree
 *    ("{0,3,{1,2,{5,0},{7,0}},{1,2,{6,0},{5,0}},{1,2,{10,0}, {9,0}}}", 19)
 * - Diameter is between a leaf in the first son and leaf in the third son
 *    ("{0,3,{5,2,{8,0},{7,0}},{5,2,{9,0},{8,0}},{5,2,{10,0},{9,0}}}", 29)
 */
public class RecursionDiameterNaryTree {

   static class Node {
      int value;
      List<Node> children;      
      Node(int value) {
         this.value = value;
         this.children = new ArrayList<Node>();
      }
   }
   
   public static Node addNode(int val) {
      Node tmp = new Node(val);
      return tmp;
   }
   
   public static List<Node> addChildren(Node n, int[] childvals) {
      for(int v : childvals)
         n.children.add(new Node(v));  
      return n.children;
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
            for(int i=0; i<tmp.children.size(); i++) {
               q.add(tmp.children.get(i));
            }
         }
      }
   }
   
   public static int depthTree(Node n) {
      // Base case
      if(n == null)
         return 0;
      
      int maxdepth = 0;
      for(int i=0; i < n.children.size(); i++) {
         maxdepth = Math.max(maxdepth, depthTree(n.children.get(i)));
      }
      return maxdepth + n.value;
   }
   
   public static int diameterNaryTree(Node n) {
      // Base case
      if(n == null)
         return 0;
      
      // Find height of highest two subtrees
      int hmax1 = 0;
      int hmax2 = 0;
      for(int i=0; i<n.children.size(); i++) {
         int h = depthTree(n.children.get(i));
         if(h > hmax1) {
            hmax2 = hmax1;
            hmax1 = h;
         }
         else if (h > hmax2){
            hmax2 = h;
         }
      }
      
      // Find diameter for each child to compare
      int dmax = 0;
      for(int j=0; j<n.children.size(); j++) 
         dmax = Math.max(dmax, diameterNaryTree(n.children.get(j)));
      
      return Math.max(dmax, hmax1 + hmax2);
   }
   
   public static void main(String[] args) {
      
      // Tree 1
      Node root = addNode(0);
      
      int[] childvals = {1,1,1};
      List<Node> rchildren = addChildren(root, childvals);
      
      int[] childvals21 = {5,7};
      addChildren(rchildren.get(0), childvals21);
      
      int[] childvals22 = {6,5};
      addChildren(rchildren.get(1), childvals22);
      
      int[] childvals23 = {10,9};
      addChildren(rchildren.get(2), childvals23);
      
      printTree(root);      
      int dmax = diameterNaryTree(root);
      System.out.println(" max diam: " + dmax);
      
      // Tree 2,   ("{0,1,{5,1,{4,1,{7,0}}}}", 16)
      Node root2 = addNode(0);
      
      int[] childvals2 = {5};
      List<Node> rchildren2 = addChildren(root2, childvals2);
      
      int[] childvals221 = {4};
      List<Node> rchildren22 = addChildren(rchildren2.get(0), childvals221);
      
      int[] childvals222 = {7};
      addChildren(rchildren22.get(0), childvals222);
      
      printTree(root2);      
      int dmax2 = diameterNaryTree(root2);
      System.out.println(" max diam: " + dmax2);
      
      
      // Tree 3, ("{0,1,{5,2,{8,0},{7,0}}}", 15)
      Node root3 = addNode(0);
      
      int[] childvals3 = {5};
      List<Node> rchildren3 = addChildren(root3, childvals3);
      
      int[] childvals321 = {8, 7};
      addChildren(rchildren3.get(0), childvals321);
      
      printTree(root3);
      int dmax3 = diameterNaryTree(root3);
      System.out.println(" max diam: " + dmax3);
      
      // Tree 4, ("{0,3,{5,2,{8,0},{7,0}},{5,2,{9,0},{8,0}},{5,2,{10,0},{9,0}}}", 29)
      Node root4 = addNode(0);
      
      int[] childvals4 = {5, 5, 5};
      List<Node> rchildren4 = addChildren(root4, childvals4);
      
      int[] childvals421 = {8, 7};
      addChildren(rchildren4.get(0), childvals421);
      
      int[] childvals422 = {9,8};
      addChildren(rchildren4.get(1), childvals422);
      
      int[] childvals423 = {10,9};
      addChildren(rchildren4.get(2), childvals423);
      
      printTree(root4);
      int dmax4 = diameterNaryTree(root4);
      System.out.println(" max diam: " + dmax4);
   }
}
