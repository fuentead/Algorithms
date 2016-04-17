/**
 * IC Problem - Shuffle Array in Place
 */
package icproblems;

import java.util.List;
import java.util.Random;

/**
 * @author adrianafuentes
 * 
 * Shuffle Array in Place
 */
public class ShuffleArrayInPlace {

	public void shuffleInPlace(final List<Integer> numbers) {
		
		int tmp;
		
		Random rand = new Random();
		
		for(int i=0; i<numbers.size(); i++) {
			int index = rand.nextInt(numbers.size()-1);
			tmp = numbers.get(index);
			
			numbers.set(index, numbers.get(i));
			numbers.set(i, tmp);		
		}
	}
}
