/**
 * IC Problems
 * 
 * Find Kth To Last in Single Linked List
 */
package icproblems;

/**
 * @author adrianafuentes
 * 
 * Single Linked List:
 * 2->4->6->3->8
 * Third to last element, would be 6 if we start 
 * counting from last element.
 */
class NodeLL {
	int data;
	NodeLL next;
	
	NodeLL(int data) {
		this.data = data;
		next = null;
	}
}

public class FindKthToLastLinkedList {
	
	public int findKthToLast(int kthElem, NodeLL head) {
		
		NodeLL current = head;
		NodeLL lead = head;
		
		if(head.next == null)
			return head.data;

		// Move element forward till next for kthElem-1
		// since we start counting from last element.
		for(int i=1; i<kthElem; i++) {
			lead = lead.next;
		}
		
		while(lead.next != null) {
			lead = lead.next;
			current = current.next;
		}
		return current.data;		
	}
	
	public NodeLL buildLinkedList() {
		NodeLL head = new NodeLL(2);
		head.next = new NodeLL(4);
		
		NodeLL n = head.next;
		n.next = new NodeLL(6);
		
		NodeLL n3 = n.next;
		n3.next = new NodeLL(3);
		
		NodeLL n4 = n3.next;
		n4.next = new NodeLL(8);
		
		return head;		
	}
}
