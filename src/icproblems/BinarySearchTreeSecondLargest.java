/**
 * IC Problems
 */
package icproblems;

/**
 * @author adrianafuentes
 *
 * Find the second largest element in a Binary Search Tree - pb81
 */

class Node {
	int data;
	Node right;
	Node left;
	Node parent;
	
	Node(int data) {
		this.data = data;
		this.right = null;
		this.left = null;
		this.parent = null;
	}	
}

public class BinarySearchTreeSecondLargest {
	
	public int findSecondLargestElemBST(Node head) {
		if(head == null)
			return -1;
		
		Node current = head;
		
		while(current.right != null) {
			current = current.right;
		}
		System.out.println("Current " + current.data);
		return current.parent.data;
	}
	
	public Node createBST() {
		
		Node head = new Node(10);
		head.right = new Node(12);
		head.left = new Node(6);
		head.parent = null;
		
		Node hright = head.right;
		Node hleft = head.left;
		hright.parent = head;
		hleft.parent = head;
		
		hright.right = new Node(14);
		hright.right.parent = hright;
		hright.left = new Node(11);
		hright.left.parent = hright;
			
		hleft.right = new Node(8);
		hleft.right.parent = hleft;
		hleft.left = new Node(4);
		hleft.left.parent = hleft;
		
		return head;
	}
}
