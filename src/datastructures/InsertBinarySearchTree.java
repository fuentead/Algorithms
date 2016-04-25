/**
 * 
 */
package datastructures;

/**
 * @author adrianafuentes
 *
 * Insert value in binary search tree.
 */

public class InsertBinarySearchTree {
	
	public boolean insertValueBinarySearchTree(Node node, int value) {
		System.out.println(node.data);

		if(node.data == value)
			return false;
		if(node.data < value) {
			if(node.left == null) {
				node.left = new Node(value);
				System.out.println("Created");
				return true;
			}
			else {
				return insertValueBinarySearchTree(node.left, value);
			}
		}
		else if (node.data > value) {
			if(node.right == null) {
				node.right = new Node(value);
				return true;
			}
			else {
				return insertValueBinarySearchTree(node.right, value);
			}
		}
		return false;
	}
	
	/*
	 *  Constructs tree like this:
	 *  		8
	 *  	   / \
	 *  	  3   10
	 *  	 / \   \
	 *  	1	6   14
	 */
	public Node constructTree(){
		Node head = new Node(8);
		head.right = new Node(10);
		head.left = new Node(3);
		
		Node hright = head.right;
		Node hleft = head.left;
		
		hright.right = new Node(14);
		hleft.right = new Node(6);
		hleft.left = new Node(1);
		
			
		return head;		
	}

}
