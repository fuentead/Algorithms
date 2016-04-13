/**
 * 
 */
package datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author adrianafuentes
 * 
 * Sample code of queue init.
 * 
 * Queue is a first in, first out data structure. In java 
 * this is an interface that includes methods such as:
 *   Add: 		adds new element.
 *   Remove: 	removes oldest element.
 *   Peek: 		returns oldest element but doesn't remove.
 *   
 * Deque is a Queue extension. Allows to add or remove 
 * elements from either end of data structure.
 */
public class QueueExample {
	
	public Queue<Integer> queueCreation() {
		final Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		return queue;
	}

}
