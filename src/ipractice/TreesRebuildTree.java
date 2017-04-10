package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Given the in-order and pre-order traversal
 * results of a binary tree as an array, write
 * a function to rebuild the tree. The function
 * should return the pointer to the root node of
 * the tree. Then, take that pointer and print 
 * the tree level by level (level order)
 * 
 * Note: One needs to be given in-order traversal
 * (with either pre or post or level), as input,
 * in order to re-construct a binary tree. Without
 * in-order traversal given, it's not possible to 
 * re-construct a binary tree. An exception is that 
 * if we know something more about the tree such as
 * if it is full and complete
 */
public class TreesRebuildTree {

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
   
   public static Node rebuildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
      if(inStart > inEnd || preStart > preEnd)
         return null;
      
      int valRoot = preorder[preStart];
      int iroot = 0;
      
      // Find index of root in inorder array
      for(int i=0; i<inorder.length; i++) {
         if(inorder[i] == valRoot) {
            iroot = i;
            break;
         }
      }
      
      int len = iroot - inStart;
      Node root = new Node(valRoot);
      root.left = rebuildTree(inorder, inStart, iroot-1, preorder, preStart+1, preStart+len);
      root.right = rebuildTree(inorder, iroot+1, inEnd, preorder, preStart+len+1, preEnd);
      return root;
   }
   
   public static Node rebuildTree(int[] inorder, int[] preorder) {
      if(inorder.length ==0 || preorder.length == 0)
         return null;
      
      Node root = rebuildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1);
      return root;
   }
   
   public static void printTree(Node n) {
      if(n == null)
         return;
      
      Queue<Node> q = new LinkedList<Node>();
      q.add(n);
      while(!q.isEmpty()) {
         Node tmp = q.poll();
         if(tmp !=null) {
            System.out.print(tmp.value + " ");
         }
         if(tmp.left != null)
            q.add(tmp.left);
         if(tmp.right != null)
            q.add(tmp.right);
      }
   }
   
   public static void main(String[] args) {
      int[] inorder = {4,2,5,1,6,3,7};
      int[] preorder = {1,2,4,5,3,6,7};
      Node root = rebuildTree(inorder, preorder);
      printTree(root);
   }
}
