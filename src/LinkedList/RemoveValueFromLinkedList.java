/**
 * Remove elements from Linked List.
 */
package LinkedList;

import java.util.*;

/**
 * @author adrianafuentes
 *
 * Remove all elements from Linked List that have a specific value.
 */

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next = null;
	}
}
public class RemoveValueFromLinkedList {

	public Node removeElementLinkedList(Node head, int value) {
		Node helper = new Node(0);
		helper.next = head;
		Node curr = helper;

		while(curr.next !=null) {
			if(curr.next.data == value) {
				Node next = curr.next;
				curr.next = next.next;		
			}
			else {
				curr = curr.next;
			}
		}
		return helper.next;
	}
	
	public Node createLinkedList(final List<Integer> numbers) {
		Node head = new Node(numbers.get(0));
		
		Node n = new Node(numbers.get(1));
		head.next = n;
		
		for(int i=2; i<numbers.size(); i++){
			Node tmp = new Node(numbers.get(i));
			n.next = tmp;
			n = tmp;
		}

		return head;
	}
}
