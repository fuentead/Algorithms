
package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 */
public class LinkedListSpecialClone {
	
	public Node cloneSpecialLinkedList(Node head) {
		Map<Integer, Node> hm = new HashMap<Integer, Node>();
		
		Node temp = head;
		Node n = new Node(temp.data);
		Node headCopy = n;
		hm.put(temp.data, n);
		temp = temp.next;		
		while(temp != null) {							
			n.next = new Node(temp.data);
			hm.put(temp.data, n.next);
			n = n.next;	
			temp = temp.next;
		}
		temp = headCopy;
	
		Node tempO = head;
		while(tempO != null) {
			Node curr = hm.get(tempO.data);			
			curr.arbit = hm.get(tempO.arbit.data);
			tempO = tempO.next;
		}		
		return headCopy;
	}

	public void printLinkedList(Node n) {
		Node trav = n;	
		while (trav != null) {			
			if(trav.next != null) 
				System.out.println(trav.data + " ->next " + trav.next.data);
			else 
				System.out.println(trav.data + " ->next null");
			System.out.println(trav.data + " ->arbit " + trav.arbit.data);				
			trav = trav.next;
		}
	}
	
	public static void main(String[] args) {		
		LinkedListSpecialClone sc = new LinkedListSpecialClone();
		Map<Integer, Node> hm = new HashMap<Integer, Node>();
		Map<Integer, Integer> arbithm = new HashMap<Integer, Integer>();
		
		// Build arbit hashmap
		arbithm.put(1, 3);
		arbithm.put(2, 1);
		arbithm.put(3, 5);
		arbithm.put(4, 3);
		arbithm.put(5, 2);
		
		// Build Linked List
		Node head;		
		Node n = new Node(1);
		head = n;
		n.next = new Node(2);
		hm.put(n.data, n);
		n.next.next = new Node(3);
		hm.put(n.next.data, n.next);
		n.next.next.next = new Node(4);
		hm.put(n.next.next.data, n.next.next);
		n.next.next.next.next = new Node(5);
		hm.put(n.next.next.next.data, n.next.next.next);
		n.next.next.next.next.next = null;
		hm.put(n.next.next.next.next.data, n.next.next.next.next);
		
		for (Map.Entry<Integer, Node> entry : hm.entrySet()) {
		    Integer nkey = entry.getKey();
		    Node node = entry.getValue();		    
		    int arbitNodeNum = arbithm.get(nkey);
		    node.arbit = hm.get(arbitNodeNum);
		}
		System.out.println("Original Linked List");
		sc.printLinkedList(head);
		Node cHead = sc.cloneSpecialLinkedList(head);
		System.out.println("\nCopy Linked List");
		sc.printLinkedList(cHead);
	}
}
