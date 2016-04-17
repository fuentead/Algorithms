/**
 * 
 */
package LinkedList;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * @author adrianafuentes
 *
 */
public class LinkedListDriver {
	RemoveValueFromLinkedList rvll;
	
	public LinkedListDriver() {
		rvll = new RemoveValueFromLinkedList();
	}

	@Test
	public void removeElementsLinkedList() {
		final List<Integer> numbers = Arrays.asList(1,2,3,5,6,8,6,9,6,10,6);
		
		Node head = rvll.createLinkedList(numbers);
		Node tmp = head;
		
		while(tmp != null) {
			System.out.print(tmp.data + " -> ");
			tmp = tmp.next;
		}
		System.out.println("null");
		
		Node resHead = rvll.removeElementLinkedList(head, 6);	
		Node tmp2 = resHead;
		while(tmp2 != null) {
			System.out.print(tmp2.data + " -> ");
			tmp2 = tmp2.next;
		}
		System.out.println("null");
	}
}
