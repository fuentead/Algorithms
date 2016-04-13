package icproblems;

import java.util.*;

/**
 * @author adrianafuentes
 * 
 * Validate if brackets are correct in a string.
 * 
 * For bracket validation it is best to use a stack.
 * 
 * Stack can be used for parsing problems or for tree or 
 * graph traversal (depth-first search).
 */
public class BracketValidator {

	public static boolean validateStringBrackets(String str) {
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '(') {
				st.push('(');
			} else if (str.charAt(i) == '[') {
				st.push('[');
			} else if (str.charAt(i) == '{') {
				st.push('{');
			} else if (str.charAt(i) == ')') {
				if (!st.isEmpty() && st.peek() == '(')
					st.pop();
			} else if (str.charAt(i) == ']') {
				if (!st.isEmpty() && st.peek() == '[')
					st.pop();
			} else if (str.charAt(i) == '}') {
				if (!st.isEmpty() && st.peek() == '{')
					st.pop();
			} else
				return false;
		}

		if (st.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		boolean result = validateStringBrackets("[[[(((()))]]]");
		System.out.println(result);

		boolean result2 = validateStringBrackets("[[[(((())))]]]");
		System.out.println(result2);

		boolean result3 = validateStringBrackets("(([())])");
		System.out.println(result3);

		boolean result4 = validateStringBrackets("{{(([()]))}}");
		System.out.println(result4);

		boolean result5 = validateStringBrackets("({{[]})}");
		System.out.println(result5);
	}
}
