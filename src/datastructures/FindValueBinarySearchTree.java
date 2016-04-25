/**
 * Data Structures Problems
 */
package datastructures;

/**
 * @author adrianafuentes
 * 
 * Find value in Binary Search Tree.
 * 
 * Algorithm:
 * ---------
 * If value is equal than current node, return.
 * 
 * If value is less than current node, and left
 * node is not null, search on left tree.
 * 
 * If value is greater than current node, and 
 * right node is not null, search on right tree.
 */

class Node {
	int data;
	Node right;
	Node left;
	Node parent;
	
	public Node(int data) {
		this.data = data;
		right = null;
		left = null;
	}
}

public class FindValueBinarySearchTree {
	
	public boolean findValue(int value, Node n) {
		
		if(n.data == value)
			return true;
		
		if(value > n.data && n.right != null) {
			return findValue(value, n.right);
		}
		else if(value< n.data && n.left != null) {
			return findValue(value, n.left);
		}	
		return false;
	}

	public Node constructTree(){
		Node head = new Node(8);
		head.right = new Node(10);
		head.left = new Node(3);
		head.parent = null;
		
		Node hright = head.right;
		Node hleft = head.left;
		
		hright.right = new Node(14);
		hleft.right = new Node(6);
		hleft.left = new Node(1);
			
		return head;		
	}
}
