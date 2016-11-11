
package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Write a function to traverse a Binary Tree PostOrder 
 * without using recursion. Print contents of nodes as 
 * traversed.
 */
public class TreePostOrderTraversalNonRecursive {

	public void postOrderTraversal(BSTNode node) {
		if(node == null)
			return;
		else {
			Stack<BSTNode> s = new Stack<BSTNode>();
			Stack<BSTNode> out = new Stack<BSTNode>();
			
			s.add(node);
			while(!s.isEmpty()) {
				BSTNode n = s.peek();
				out.push(n);
				s.pop();
				
				if(n.left != null)
					s.push(n.left);
				if(n.right != null)
					s.push(n.right);				
			}
			
			while(!out.isEmpty()) {
				System.out.print(out.pop().data + " ");
			}
		}
	}
	
	public static void main(String[] args) {
		TreePostOrderTraversalNonRecursive pot = new TreePostOrderTraversalNonRecursive();
		TreeBinarySearch bst = new TreeBinarySearch();
		
		int[] data = {12, 14, 10, 11, 4, 2, 6, 8};
		BSTNode root = bst.createBinarySearchTree(data);
		System.out.println("Print Binary Search Tree");
		bst.printBinarySearchTreeBFS(root);
		System.out.println("\nPrint Binary Search Tree - PostOrder");
		pot.postOrderTraversal(root);		
	}
}
