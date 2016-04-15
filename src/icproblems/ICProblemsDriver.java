/**
 * IC Problems Driver
 */
package icproblems;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * @author adrianafuentes
 *
 */
public class ICProblemsDriver {
	
	BinarySearchTreeSecondLargest bstSL;
	FindKthToLastLinkedList ktlLL;
	MergeCookiesOrders mco;
	
	public ICProblemsDriver() {
		bstSL = new BinarySearchTreeSecondLargest();
		ktlLL = new FindKthToLastLinkedList();
		mco = new MergeCookiesOrders();
	}

	@Test
	public void testBSTSecondLargest() {
		Node head = bstSL.createBST();
		int result = bstSL.findSecondLargestElemBST(head);
		
		assertEquals(result, 12);
		System.out.println("BST Second Largest Results: " + result);
	}
	
	@Test
	public void testFindKthToLastLinkedList(){
		NodeLL head = ktlLL.buildLinkedList();
		int kth = 3;
		// Find 3rd element to last
		int result = ktlLL.findKthToLast(kth, head);
		
		assertEquals(6, result);
		System.out.println("Kth To last in Single Linked List - Kth: " + kth + ", result: " + result);
	}
	
	@Test
	public void testMergeCookiesOrders() {
		final List<Integer> orders1 = Arrays.asList(2,3,4,5,7,8);
		final List<Integer> orders2 = Arrays.asList(1,6,9,10,11,12);
		final List<Integer> mergedExpected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		
		List<Integer> mergedList = mco.mergeGirlsScoutCookiesOrders(orders1, orders2);
		
		assertEquals(mergedExpected, mergedList);
		System.out.println("MergeCookiesOrders " + mergedList);
	}
}
