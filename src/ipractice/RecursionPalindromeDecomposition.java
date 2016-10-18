package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * Return all possible strings with Palindromic Decompositions
 * Depth First Search
 */
public class RecursionPalindromeDecomposition {

	public ArrayList<ArrayList<String>> palindromeDecomposition(String str) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(str.length() == 0 || str == null)
			return result;
		
		ArrayList<String> partition = new ArrayList<String>();
		findPalindrome(str, 0, partition, result);
		
		return result;
	}
	
	public void findPalindrome(String s, int start, ArrayList<String> partition, ArrayList<ArrayList<String>> result) {
		if(start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			result.add(temp);
			return;
		}
		
		for(int i=start+1; i<=s.length(); i++) {
			String str = s.substring(start, i);
			if(isPalindrome(str)) {
				partition.add(str);
				System.out.println("Partition " + partition);
				findPalindrome(s, i, partition, result);
				partition.remove(partition.size()-1);
				System.out.println("Partition2 " + partition);
			}
		}
	}
	
	public boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		
		while(left < right) {
			if(str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		RecursionPalindromeDecomposition pd = new RecursionPalindromeDecomposition();
		ArrayList<ArrayList<String>> result = pd.palindromeDecomposition("madam");
		System.out.println(result);
	}
}
