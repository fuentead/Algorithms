package ipractice;
import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * 3Sum: Find 3 numbers that add up to 0 in an array.
 */
public class Sorting3Sum {
	
	/*
	 * Find 3 Sum Iterative Solution
	 */
	public void find3SumIterative(int[] data) {
		if(data.length < 3)
			return;
		
		for(int i=0; i< data.length-2; i++) {
			int j = i+1;
			int k = data.length-1;
			
			while(j < k) {
				int sum = data[i] + data[j] + data[k];
				if(sum == 0) {
					System.out.format("[%d, %d, %d]\n", data[i], data[j], data[k]);

					j++;
					k--;
				
					while(data[j] == data[j-1] && j < k)
						j++;
					while(data[k] == data[k+1] && j < k)
						k--;
				}
				else if(sum < 0) {
					j++;
				}
				else if(sum > 0) {
					k--;
				}
			}
		}		
	}
	
	/*
	 * Find 3 Sum Recursive Solution
	 */	
	public void find3SumRecursive(int[] data) {
		if(data.length < 3)
			return;
		List<Integer> result = new ArrayList<Integer>();
		find3SumRecursiveHelper(data, 0, result);
	}
	
	private void check3SumResult(List<Integer> result) {
		if (result.get(0) + result.get(1) + result.get(2) == 0) {
			System.out.println(result);
		}
	}
	
	private void find3SumRecursiveHelper(int [] data, int i, List<Integer>result){
		if (i >= data.length) {
			if (result.size() == 3) {
				check3SumResult(result);
			}
			return;
		}
		if (result.size() == 3) {
			check3SumResult(result);
			return;
		}
		find3SumRecursiveHelper(data, i + 1, result);
		result.add(data[i]);
		find3SumRecursiveHelper(data, i + 1, result);
		result.remove(result.size()-1);
	}

	public static void main(String[] args) {
		int[] data = {-3, -2, 0, 1, 2, 3};
		Sorting3Sum s3sum = new Sorting3Sum();
		s3sum.find3SumIterative(data);
		s3sum.find3SumRecursive(data);		
	}
}
