/**
 * 
 */
package icproblems;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * @author adrianafuentes
 *
 */
public class ICProblemsDriver {
	
	BinarySearchTreeSecondLargest bstSL;
	
	public ICProblemsDriver() {
		bstSL = new BinarySearchTreeSecondLargest();
	}


	//@Test
	/*public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testBSTSecondLargest() {
		Node head = bstSL.createBST();
		int result = bstSL.findSecondLargestElemBST(head);
		
		assertEquals(result, 12);
		System.out.println("Results: " + result);
	}
}
