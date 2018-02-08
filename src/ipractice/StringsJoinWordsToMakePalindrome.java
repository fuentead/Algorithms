package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Given a list of words, is there any pair of words that can be joined (in any order) to 
 * form a palindrome?
 * --
 * 
 * Example 1: Consider a list {bat, tab, cat}. Then bat and tab can be joined together to form a 
 * palindrome.
 * 
 * Example 2: {ab, deedba} can be joined to form a palindrome.
 * 
 * Example 3: {ant, cat, dog} No words can be joined to form a palindrome
 * 
 * Expected solution, given n = number of words and k is length of the longest word,
 * O(N.K^2) solution for this problem is relatively straightforward to come by, using Maps or
 * Tries. That may suffice for most interviews.
 */
public class StringsJoinWordsToMakePalindrome {
   
   static class Node {
      boolean end;
      String endword = "";
      char character = ' ';
      Map<Character, Node> nextLetters;
      Node(char c) {
         this.end = false;
         this.endword = "";
         this.character = c;
         nextLetters = new HashMap<Character, Node>();
      }
   }
   
   public static void joinWordsToMakePalindrome(String[] data) {
      if(data.length == 0)
         return;
      
      List<String> palResList = new ArrayList<String>();    
      
      // Build trie with reverse words from data
      Node root = buildTrie(data);      
      for(int i=0; i<data.length; i++) {
         String palRes = compareJoinedWordsPalindrome(data[i], root);
         if(!palRes.equals("")) {
            StringBuilder sb = new StringBuilder();
            sb.append(data[i]);
            sb.append(palRes);
            palResList.add(sb.toString());
         }
      }      
      printAllPalindromesResults(palResList);
   }
   
   private static Node buildTrie(String[] data) {
      Node root = new Node('-');
      Node tmp;
      for(int i=0; i<data.length; i++) {
         tmp = root;
         for(int j=data[i].length()-1; j>=0; j--) {
            if(!tmp.nextLetters.containsKey(data[i].charAt(j))) {
               tmp.nextLetters.put(data[i].charAt(j), new Node(data[i].charAt(j)));
               tmp = tmp.nextLetters.get(data[i].charAt(j));
               if(j == 0) { // mark in trie if it's the last char in word
                  tmp.end = true;
                  tmp.endword = data[i];
               }
            }
            else 
               tmp = tmp.nextLetters.get(data[i].charAt(j));     
         }
      }
      printTrie(root);
      return root;
   }
   
   private static String compareJoinedWordsPalindrome(String s1, Node trieRoot) {
      Node tmp = trieRoot;
      int i;
      String word2 = "";
      for(i=0; i<s1.length(); i++) {         
         if(tmp.nextLetters.containsKey(s1.charAt(i))) 
            tmp = tmp.nextLetters.get(s1.charAt(i));         
         else 
            return "";
      }
      
      if(tmp.end)
         return tmp.endword;
      else          
         word2 = dfsCheckPalindromeWords(tmp, i+1); // If not at end of trie, check if rest is a palindrome by itself      
      return word2;
   }
   
   private static String dfsCheckPalindromeWords(Node root, int iwpartial) {
      if(root.end == true)
         return "";
      
      Stack<Node> s = new Stack<Node>();
      s.push(root);
      while(!s.isEmpty()) {
         Node tmp = s.pop();
         if(tmp.end == true) {
            String wordpartial = tmp.endword.substring(iwpartial);
            boolean isPal = isPalindromeWord(wordpartial);
            if(isPal)
               return tmp.endword;
            else
               return "";
         }
         else {// push all nextLetters in stack
            for(Node nLetter : tmp.nextLetters.values())
               s.push(nLetter);
         }
      }
      return "";
   }
   
   private static boolean isPalindromeWord(String word) {
      if(word.length() == 1)
         return true;
      
      int ibeg = 0;
      int iend = word.length()-1;
      while(ibeg < iend) {
         if(word.charAt(ibeg) != word.charAt(iend))
            return false;   
      }
      return true;
   }
   
   private static void printAllPalindromesResults(List<String> palindromes) {
      if(palindromes.isEmpty()) {
         System.out.println("No palindromes");
         return;
      }
         
      for(String s : palindromes)
         System.out.println(s);
   }
   
   private static void printTrie(Node root) {
      if(root.character == ' ')
         return;
      
      Stack<Node> s = new Stack<Node>();
      s.push(root);
      while(!s.isEmpty()) {
         Node tmp = s.pop();
         System.out.print(tmp.character + " ");
         if(tmp.end == false)
            for(Node n : tmp.nextLetters.values()) 
               s.push(n);
      }
      System.out.print("\n");
   }
   
   public static void main(String[] args) {      
      String[] words = {"bat", "tab", "cat"};
      joinWordsToMakePalindrome(words);      
   }
}
