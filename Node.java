package TreesAndGraphs;

/**
 * @author Adriana Fuentes
 *
 * Class Node to construct tree or graph
 */
 
public class Node {
	
	int data;
	Node left;
	Node right;
	Node parent;

	/**
	 * Node Class Constructor
	 */
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

}
