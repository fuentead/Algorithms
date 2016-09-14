package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Long array is given and there is a sliding window size w which is moving 
 * from the left of the array to the right. You can only see the numbers w 
 * in the window. Print the maximum value for this array at each of these 
 * windows.
 */
public class LinkedListSlidingMaximumWindow {
	
	private void removeLowValues(int[] a, Deque<Integer> deque, int val) {
		while(deque.size() > 0 && deque.getLast() < val) {
			deque.removeLast();			
		}
	}
	
	private void getMaxVal(int[] a, Deque<Integer> deque) {
		int imax = deque.getFirst();
		System.out.println("Max Val = " + a[imax]);
	}
	
	public void findMaximumSlidingWindow(int[] a, int k) {
		int index_init = 0;
		int index_end = k-1;
		Deque<Integer> deque = new LinkedList<Integer>();	
		if(a.length == 0)
			return;		

		// Enter initial k numbers
		for(int i=0; i<k; i++) {						
			removeLowValues(a, deque, a[i]);
			deque.add(i);			
		}
		getMaxVal(a, deque);

		// Enter following numbers after first k
		for(int j=k; j< a.length; j++) {
			if(deque.getFirst() == index_init)
				deque.removeFirst();			
			index_init++;
			index_end++;	
			removeLowValues(a, deque, a[j]);	
			deque.add(index_end);
			getMaxVal(a, deque);
		}	
	}

	public static void main(String[] args) {		
		LinkedListSlidingMaximumWindow smw = new LinkedListSlidingMaximumWindow();		
		int[] a = {1,3,-1,-3,5,3,6,7};		
		smw.findMaximumSlidingWindow(a, 3);
	}
}