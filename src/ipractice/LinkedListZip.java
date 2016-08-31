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
		t1 = t1.next;
		Node t2 = l2;
		t2 = t2.next;
		Node l = l1;		
		l.next = l2;		
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
	
	public Node reverseList(Node l) {
		Node lr, t;
		t = l.next;
		lr = l;
		lr.next = null;		
		while(t != null) {
			Node temp = t;
			t = t.next;
			temp.next = lr;
			lr = temp;
		}
		return lr;
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

		// Reverse second list
		Node lr = reverseList(l2);
		
		// Zip two lists
		Node l  = zipMerge(l1, lr);
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
		head.next.next.next.next.next.next = new Node(7);
		
		llz.printNodes(head);
		Node l = llz.zipLinkedList(head);
		llz.printNodes(l);		
	}
}
