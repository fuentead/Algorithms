/**
 * Data Structures Samples
 */
package datastructures;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * @author adrianafuentes
 *
 */
public class DataStructuresDriver {
	
	ExtendArrayExample ea;
	QueueExample q;
	FindValueBinarySearchTree btfv;
	InsertBinarySearchTree ibst;
	
	public DataStructuresDriver() {
		ea = new ExtendArrayExample();
		q = new QueueExample();
		btfv = new FindValueBinarySearchTree();
		ibst = new InsertBinarySearchTree();
	}

	@Test
	public void testExtendArray() {
		int[] values = {3, 4, 5, 6, 7};
		
		values = ea.extendArrayWithArrayCopy(values);
		
		assertEquals(8, values[5]);
		assertEquals(9, values[6]);
		assertEquals(10, values[7]);
	}
	
	@Test
	public void testQueue() {
		
		Queue<Integer> result = q.queueCreation();
		
		int num1 = result.remove();
		int num2 = result.remove();
		int num3 = result.peek();
		
		assertEquals(1, num1);
		assertEquals(2, num2);
		assertEquals(3, num3);
	}
	
	@Test
	public void testFindValueBinarySearchTree() {

		Node head = btfv.constructTree();
		boolean result = btfv.findValue(3, head);	
		assertEquals(true, result);
		System.out.println("BST Find Result 1: " + result);
		
		boolean result2 = btfv.findValue(11, head);	
		assertEquals(false, result2);	
		System.out.println("BST Find Result 2: " + result2);
	}
	
	@Test
	public void testInsertValueBinarySearchTree() {
		Node n = ibst.constructTree();
		boolean result = ibst.insertValueBinarySearchTree(n, 9);
		
		assertEquals(true, result);
	}
}
