package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 */
class BSTNode {
	int data;
	BSTNode left;
	BSTNode right;
	
	public BSTNode (int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class TreeBinarySearch {
	
	public BSTNode createBSTRecursive(int[] data, int start, int end) {
		
		int mid;		
		if(start > end)
			return null;
		else {
			mid = (int) Math.ceil((double)(start + end)/ 2);
			BSTNode n = new BSTNode(data[mid]);
			n.left = createBSTRecursive(data, start, mid-1);
			n.right = createBSTRecursive(data, mid+1, end);
			return n;
		}
	}
	
	public BSTNode createBinarySearchTree(int[] data) {
		Arrays.sort(data);
		BSTNode root = createBSTRecursive(data, 0, data.length-1);
		return root;
	}
	
	public void printBinarySearchTreeBFS(BSTNode root) {
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		if(root == null)
			return;
		q.add(root);
		while(!q.isEmpty()) {
			BSTNode n = (BSTNode) q.remove();
			System.out.print(" " + n.data);
			if(n.left != null)
				q.add(n.left);
			if(n.right != null)
				q.add(n.right);
		}
	}
	
	public static void main(String[] args) {
		int[] data = {12, 14, 10, 11, 4, 2, 6, 8};		
		TreeBinarySearch bst = new TreeBinarySearch();			
		BSTNode root = bst.createBinarySearchTree(data);
		bst.printBinarySearchTreeBFS(root);
		
	}
}
