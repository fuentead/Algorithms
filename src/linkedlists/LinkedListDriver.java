package linkedlists;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListDriver {
	
	StackUsingArray sua;
	
	public LinkedListDriver() {
		sua = new StackUsingArray(5);
	}

	@Test
	public void testStackUsingArray() {
		// Push [5,6,7,8,9,10] -> 10 return false, exceeded max
		sua.push(5);
		sua.push(6);
		sua.push(7);
		sua.push(8);
		sua.push(9);
		boolean fullresult = sua.isFull();
		assertEquals(fullresult, true);
		
		boolean result = sua.push(10);
		assertEquals(result, false);
		
		// Pop [9,8] and check size
		sua.pop();
		sua.pop();
		int size = sua.getSize();
		assertEquals(size, 3);
	}
}
