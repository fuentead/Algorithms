package TreesAndGraphs;

/**
 * @author Adriana Fuentes
 * 
 * PROBLEM: Find the shortest leaf in the tree.
 * SOLUTION: Breath First Search- Level Order Traversal
 *           Algorithm for Traversing a Binary Tree.
 *           Starts at tree root and explores neighbor nodes first.
 * APPROACH:
 *          1. Start with empty queue.
 *          2. Start from root & enter root into queue.
 *          3. While queue is not empty
 *             -> extract node from queue and insert children
 *             -> print node extracted
 *             -> Check their children and add to queue
 *             -> If no children, then it is the shortest leaf
 */

import java.util.LinkedList;
import java.util.Queue;

public class Tress_BFS {

	public void breathFirstQueue(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		
		// Test empty case
		if (root == null)
			return;
		
		// Add to root
		q.add(root);	
		
		// While not empty, check children and remove from queue
		while(!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.println(" " + n.data);
			
			if(n.left != null)
				q.add(n.left);
			if(n.right != null)
				q.add(n.right);
			if((n.right == null) && (n.left == null)) {
				System.out.println("Shortest leaf is: " + n.data);
				return;
			}
		}
	}

	/**
	 * @param args
	 * 
	 *  Tree Construction
	 *               6
	 *             /    \
	 *            12     17
	 *           /  \
	 *         25    47  
	 *         
	 */
	public static void main(String[] args) {
		System.out.println("Creating Tree");
		
		Node root = new Node(6);
		root.left = new Node(12);
		root.right = new Node(17);
		root.parent = null;
		
		root.left.left = new Node(25);
		root.left.right = new Node(47);
		root.left.parent = root;
		
		root.left.left.left = null;
		root.left.left.right = null;
		root.left.left.parent = root.left;
		
		root.right.left = null;
		root.right.right = null;
		root.right.parent = root;
		
		
		Tress_BFS bfs = new Tress_BFS();
		
		System.out.println("Find Shortest Path with BFS");
		
		bfs.breathFirstQueue(root);
		
	}

}
