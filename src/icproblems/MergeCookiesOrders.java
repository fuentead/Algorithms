/**
 * IC Problems
 */
package icproblems;

import java.util.*;

/**
 * @author adrianafuentes
 * 
 * Merge girls scout cookies orders.
 * Orders1 and Orders2 are the list of sorted orders.
 */
public class MergeCookiesOrders {

	public List<Integer> mergeGirlsScoutCookiesOrders(final List<Integer> orders1, final List<Integer> orders2) {
		
		int rightPtr = 0;
		int leftPtr = 0;
		
		List<Integer> mergedList = new ArrayList<Integer>(orders1.size() + orders2.size());
		
		while(leftPtr < orders1.size() && rightPtr < orders2.size()) {
			if(orders1.get(leftPtr) < orders2.get(rightPtr)) {
				mergedList.add(orders1.get(leftPtr));
				leftPtr++;
			}
			else {
				mergedList.add(orders2.get(rightPtr));
				rightPtr++;
			}
		}
		
		while(leftPtr < orders1.size()) {
			mergedList.add(orders1.get(leftPtr));
			leftPtr++;
		}
		
		while(rightPtr < orders2.size()) {
			mergedList.add(orders2.get(rightPtr));
			rightPtr++;
		}
		
		return mergedList;
	}
}
