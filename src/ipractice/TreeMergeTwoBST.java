
package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Merge two BSTs in O(N1 + N2) time, where N1 and N2 are the 
 * number of nodes in the two trees respectively. The merged
 * tree should contain all the elements of both trees and also
 * be a balanced BST. Finally, print the new tree level by level.
 * 
 * Example:
 * Tree1: 2->1, 3
 * Tree2: 7->6, 8
 * 
 * Output: 
 * 6
 * 2 7
 * 1 3 8
 */
public class TreeMergeTwoBST {
	
	TreeBinarySearch tbs;
	
	public TreeMergeTwoBST() {
		tbs = new TreeBinarySearch();
	}
	
	public static void convertBSTtoArrayInOrder(BSTNode root, List<Integer> l) {
		if(root == null)
		   return;
		convertBSTtoArrayInOrder(root.left, l);
		l.add(root.data);
		convertBSTtoArrayInOrder(root.right, l);		
	}

	public List<Integer> mergeBST(List<Integer> bst1, List<Integer> bst2) {
		List<Integer> mbst = new ArrayList<Integer>();	
		int i=0;
		int j=0;
		while(i < bst1.size() && j < bst2.size()) {
			if(bst1.get(i) <= bst2.get(j)) {
				mbst.add(bst1.get(i));
				i++;
			}
			else {
				mbst.add(bst2.get(j));
				j++;
			}
		}
		
		while(i < bst1.size()) {
			mbst.add(bst1.get(i));
			i++;
		}
		
		while(j < bst2.size()) {
			mbst.add(bst2.get(j));
			j++;
		}
		return mbst;
	}
	
	public BSTNode mergeTwoBST(BSTNode node1, BSTNode node2) {
		
		// Convert Trees to Arrays
	   List<Integer> bst1 = new ArrayList<Integer>();
      List<Integer> bst2 = new ArrayList<Integer>();
		convertBSTtoArrayInOrder(node1, bst1);
		convertBSTtoArrayInOrder(node2, bst2);
		
		// Merge Two Arrays in Sorted Order
		List<Integer> mbst = mergeBST(bst1, bst2);
		int[] mbsta = new int[mbst.size()];
		int i=0;
		for(Integer e : mbst) 
			mbsta[i++] = e.intValue();

		// Convert Array to BST
		BSTNode bstnode = tbs.createBinarySearchTree(mbsta);		
		return bstnode;
	}

	public static void main(String[] args) {
		TreeMergeTwoBST mbst = new TreeMergeTwoBST();
		TreeBinarySearch tbs = new TreeBinarySearch();

		int[] data1 = {3, 2, 7};
		int[] data2 = {8, 5, 10};
		
		BSTNode node1 = tbs.createBinarySearchTree(data1);
		BSTNode node2 = tbs.createBinarySearchTree(data2);
		
		System.out.println("\n-- Tree 1 --");
		tbs.printBinarySearchTreeBFS(node1);
		
		System.out.println("\n-- Tree 2 --");
		tbs.printBinarySearchTreeBFS(node2);
		
		BSTNode bstroot = mbst.mergeTwoBST(node1, node2);
		
		System.out.println("\n--- Merged Trees --");
		tbs.printBinarySearchTreeBFS(bstroot);
	}
}
