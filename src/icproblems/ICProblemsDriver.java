/**
 * IC Problems Driver
 */
package icproblems;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author adrianafuentes
 *
 */
public class ICProblemsDriver {
	
	BinarySearchTreeSecondLargest bstSL;
	FindKthToLastLinkedList ktlLL;
	
	public ICProblemsDriver() {
		bstSL = new BinarySearchTreeSecondLargest();
		ktlLL = new FindKthToLastLinkedList();
	}

	@Test
	public void testBSTSecondLargest() {
		Node head = bstSL.createBST();
		int result = bstSL.findSecondLargestElemBST(head);
		
		assertEquals(result, 12);
		System.out.println("Results: " + result);
	}
	
	@Test
	public void testFindKthToLastLinkedList(){
		NodeLL head = ktlLL.buildLinkedList();
		// Find 3rd element to last
		int result = ktlLL.findKthToLast(3, head);
		
		assertEquals(6, result);
	}
}
