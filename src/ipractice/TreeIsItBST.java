package ipractice;

/**
 * @author Adriana Fuentes
 */
public class TreeIsItBST {
	
	public boolean isBSTHelper(BSTNode node, int min, int max) {
		if(node == null)
			return true;
		else {
			if(node.data >= min && node.data < max) {
				return isBSTHelper(node.left, min, node.data) && isBSTHelper(node.right, node.data, max);
			}
			else {
				return false;
			}
		}		
	}

	public boolean isBST(BSTNode node) {		
		boolean result = isBSTHelper(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return result;
	}
	
	public static void main(String[] args) {
		TreeBinarySearch bst = new TreeBinarySearch();
		TreeIsItBST isbst = new TreeIsItBST();
		
		int[] data = {12, 14, 10, 11, 4, 2, 6, 8};
		BSTNode root = bst.createBinarySearchTree(data);
		bst.printBinarySearchTreeBFS(root);
		boolean result = isbst.isBST(root);
		System.out.println("\nIs this tree a BST: " + result);
	}
}
