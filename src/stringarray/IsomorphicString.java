/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Isomorphic means that characters in string s can be replaced to 
 * get characters in string t. Example, lulu is isomorphic with mimi.
 * raaam is not isomorphic with liiituu
 * 
 * 1. Check if lengths are not same, if they are null, return false. Check if empty strings are same.
 * 2. Check if next value in second string, corresponded and match same key for both strings.
 * 3. Check value in s that is in map with corresponding value t.
 * 4. If not value in map, put it in.
 */
package stringarray;

import java.util.*;

/**
 * @author adrianafuentes
 *
 */
public class IsomorphicString {

	public boolean checkIfStringIsomorphic(String s, String t) {
		// Strings are null, not isomorphic
		if(s==null || t==null)
			return false;
		
		// If strings have different length, not isomorphic
		if(s.length() != t.length()) 
			return false;
		
		// If strings is empty, not isomorphic
		if(s.length()==0 && t.length()==0)
			return true;
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for(int i=0; i<s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			
			// Check if key of first string matches the key of same value for second string
			Character keyct = getKey(map, ct);
			// Compare cs key for this round to key stored for ct value
			if(keyct != null && keyct != cs) { 
				// Values do not have same key
				return false;				
			}
			// Compare if key value stored in map is same as the one in string
			else if(map.containsKey(cs)){
				if(map.get(cs) != ct) {
					return false;
				}
			}
			else {
				map.put(cs, ct);
			}			
		}
		return true;
	}
	
	private Character getKey(HashMap<Character, Character> map, char ct) {
		for(Map.Entry<Character, Character> entry : map.entrySet()) {
			if(entry.getValue().equals(ct)) {
				return entry.getKey();
			}
		}
		return null;
	}
}
