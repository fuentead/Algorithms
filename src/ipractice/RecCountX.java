
package ipractice;

/**
 * @author Adriana Fuentes
 *
 * Given a string, compute recursively (no loops) the number 
 * of lowercase 'x' chars in the string.
 * 
 * countX("xxhixx") → 4
 * countX("xhixhix") → 3
 * countX("hi") → 0
 */
public class RecCountX {

  /* 
   * CountX problem solved with recursion
   * 
   * Time Complexity: O(n)
   * Space Complexity: O(n), recursive calls
   */
  public static int recCountX(String s) {
    if(s.length() == 0)
      return 0;
		
    String letter = s.substring(s.length()-1);
    String word = s.substring(0, s.length()-1);
	
    if(letter.equals("x")) {
      return 1 + recCountX(word);		
    }
    else
      return recCountX(word);
  }

  public static void main(String[] args) {	
    int res = recCountX("xxmxx");
    System.out.println(res);
  }
}
