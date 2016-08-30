package ipractice;

/**
 * @author adrianafuentes
 *
 * Zip a linked list from two ends
 */
class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

public class LinkedListZip {
	
	private Node zipMerge(Node l1, Node l2) {
		Node t1 = l1;
		Node t2 = l2;
		Node l = l1;
		t1 = t1.next;
		l.next = l2;
		t2 = t2.next;
		Node t = l.next;
				
		while(t1 != null && t2 != null) {
			t.next = t1;
			t1 = t1.next;
			t.next.next = t2;			
			t2 = t2.next;	
			t = t.next.next;
		}
		while(t1 !=null) {
			t.next = t1;
			t = t.next;
			t1 = t1.next;
		}
		while(t2 != null) {
			t.next = t2;
			t = t.next;
			t2 = t2.next;
		}
		t.next = null;
		return l;
	}	

	public Node zipLinkedList(Node n) {
		int len=0;
		Node l1, l2;
		
		// Find list size
		Node t=n;
		while(t !=null) {
			len++;
			t = t.next;
		}

		// Split linked list into two different lists
		l1 = n;
		t = l1;
		int i=1;
		while(t != null && i < len/2) {
			t = t.next;
			i++;
		}
		l2 = t.next;
		t.next = null;

		// Zip two lists
		Node l  = zipMerge(l1, l2);
		return l;
	}
	
	public void printNodes(Node head) {
		Node temp = head;
		System.out.println("");
		while(temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListZip llz = new LinkedListZip();
		
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		
		llz.printNodes(head);
		Node l = llz.zipLinkedList(head);
		llz.printNodes(l);		
	}
}
