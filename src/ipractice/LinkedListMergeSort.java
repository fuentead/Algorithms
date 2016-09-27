package ipractice;

/**
 * @author Adriana Fuentes
 *
 */
public class LinkedListMergeSort {
	
	public int lengthLL(Node head) {
		Node tmp = head;
		int len = 0;
		while(tmp != null) {
			tmp = tmp.next;
			len++;
		}
		return len;
	}
	
	public Node merge(Node headA, Node headB) {
		Node headMerged = null;
		Node prev = null;
		Node currentA = headA;
		Node currentB = headB;
		
		if(currentA.data < currentB.data) {
			headMerged = currentA;
			currentA = currentA.next;
		}
		else {
			headMerged = currentB;
			currentB = currentB.next;
		}
		prev = headMerged;
		
		while(currentA != null && currentB != null) {
			if(currentA.data < currentB.data) {
				prev.next = currentA;
				prev = currentA;
				currentA = currentA.next;
			}
			else {
				prev.next = currentB;
				prev = currentB;
				currentB = currentB.next;
			}

		}
		
		while(currentA != null) {
			prev.next = currentA;
			prev = currentA;
			currentA = currentA.next;
		}
		
		while(currentB != null) {
			prev.next = currentB;
			prev = currentB;
			currentB = currentB.next;
		}
		prev.next = null;		
		return headMerged;
	}
	
	public Node sortLinkedList(Node head, int size) {	
		if(size==0 || size==1)
			return head;
		
		Node tail = head;
		Node prev = head;
		
		// Partition list into two lists
		int halfsize = size/2;
		for(int i=0; i<halfsize && tail!=null; i++) {
			prev = tail;
			tail = tail.next;
		}
		prev.next = null;
		
		Node n1 = sortLinkedList(head, halfsize);
		Node n2 = sortLinkedList(tail, size - halfsize);
		return merge(n1, n2);
	}

	public Node mergeSortLinkedList(Node head) {
		return sortLinkedList(head, lengthLL(head));
	}

	public static void main(String[] args) {
		LinkedListMergeSort llms = new LinkedListMergeSort();
		
		Node head = new Node(3);
		Node tmp = head;
		tmp.next = new Node(5);
		tmp.next.next = new Node(1);
		tmp.next.next.next = new Node(8);
		tmp.next.next.next.next = new Node(2);
		tmp.next.next.next.next.next = new Node(9);
		tmp.next.next.next.next.next.next = new Node(0);
		
		Node headS = llms.mergeSortLinkedList(head);
		Node curr = headS;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}	
	}
}
