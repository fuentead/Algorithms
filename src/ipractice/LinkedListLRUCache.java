package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 */
class ValObj {
	DLLNode n;
	int val;	
	public ValObj(int val, DLLNode n) {
		this.val = val;
		this.n = n;
	}
}

class DLLNode {
	int data;
	DLLNode next;
	DLLNode prev;	
	DLLNode(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedListLRUCache {

	public Map<Integer, ValObj> map;
	private DLLNode head;
	private DLLNode tail;
	private int lrusize;
	private int maxsize;
	
	public LinkedListLRUCache (int size) {
		map = new HashMap<Integer, ValObj>();
		this.head = null;
		this.tail = null;
		this.lrusize = 0;
		this.maxsize = size;		
	}

	public DLLNode get(int data) {	
		DLLNode tmp;
		DLLNode tnext;
		DLLNode tprev;
		
		if(head.data == data)
			return head;
	
		if(map.containsKey(data)) {
			tmp = map.get(data).n;	
			if(tmp.next != null) {
				tnext = tmp.next;
				tprev = tmp.prev;
				tprev.next = tnext;
				tnext.prev = tprev;
			}
			else {
				tprev = tmp.prev;
				tprev.next = null;
			}			
			tmp.next = head;
			head = tmp;
		}	
		return head;
	}
	
	public void evict() {
		DLLNode tmp = tail;		
		map.remove(tmp.data);
		tail = tail.prev;		
		tmp = null;
		tail.next = null;
	}
	
	public void add(int data) {
		if(head == null) {
			head = new DLLNode(data);
			tail = head;			
			map.put(data, new ValObj(data, head));
		}
		else {
			DLLNode tmp = new DLLNode(data);
			tmp.next = head;
			head.prev = tmp;
			head = tmp;
			map.put(data, new ValObj(data, head));
		}	
		lrusize++;		
		if(lrusize >= maxsize)
			evict();
	}
	
	public void print() {
		System.out.println("\nLRU Cache ");
		DLLNode tmp;
		tmp = head;
		while(tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedListLRUCache lru = new LinkedListLRUCache(5);	
		lru.add(1);
		lru.add(2);
		lru.add(3);	
		lru.add(4);
		lru.print();
		lru.get(2);
		lru.print();
		lru.get(1);
		lru.print();
	}
}
