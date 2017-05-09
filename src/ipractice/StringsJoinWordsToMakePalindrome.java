package ipractice;

import java.util.*;


/**
 * @author Adriana Fuentes
 * 
 * Given a list of words, is there any pair of words that can be joined (in any order) to 
 * form a palindrome?
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

   // Trie implementation
   Node root;
   static class Node {
      char c;
      Map<Character, Node> m;     
      Node(char c) {
         m = new HashMap<Character, Node>();
         this.c = c;
      }    
   }
   
   static class Tuple {
      boolean isPalindrome;
      String word1;
      String word2;
      Tuple(String word1, String word2, boolean isPalindrome) {
         this.isPalindrome = isPalindrome;
         this.word1 = word1;
         this.word2 = word2;
      }
   }
   
   public StringsJoinWordsToMakePalindrome() {
      root = new Node('0');
   }
   
   public void add(String s) {
      if(s.length() == 0)
         return;
      
      Node n = root;
      for(int i=0; i<s.length(); i++) {
         if(!n.m.containsKey(s.charAt(i))) 
            n.m.put(s.charAt(i), new Node(s.charAt(i)));
         n = n.m.get(s.charAt(i));
      }     
   }
   
   /*
    * Compare if current string is a palindrome
    */
   public boolean isPalindrome(String s) {
      if(s.length() == 0 || s.length() == 1)
         return false;

      int istart = 0;
      int iend = s.length() - 1;
      while(istart <= iend) {
        if(s.charAt(istart) == s.charAt(iend)) {
           istart++;
           iend--;
        }
        else
           return false;
     }
     return true;
   }
   
   /* 
    * Lookup to see if palindrome of this s string exists
    */
   public Tuple lookup(String s) {
      StringBuilder sb = new StringBuilder();
      if(s.length() == 0)
         return new Tuple("", "", false);
      
      Node n = root;
      for(int i=s.length()-1; i>=0; i--) {        
         if(!n.m.containsKey(s.charAt(i))) {   
            // Character not included, check if rest is palindrome.
            boolean isPal = isPalindrome(s.substring(0, i+1));
            if(isPal)
               return new Tuple(s, sb.toString(), true);
            else
               return new Tuple(s, sb.toString(), false);
         }
         else {
            n = n.m.get(s.charAt(i));
            sb.append(s.charAt(i));
         }
      }
      return new Tuple(s, sb.toString(), true);
   }
   
   public Tuple joinWordsToMakePalindrome(String[] words) {
      if(words.length == 0)
         return new Tuple("No", "match", false);
      
      add(words[0]);
      for(int i=1; i<words.length; i++) {
         Tuple t = lookup(words[i]);
         if(t.isPalindrome)
            return t;  
         else
            add(words[i]);
      }  
      return new Tuple("No", "match", false);
   }
   
   public void printTrie(Node n) {
      Stack<Node> s = new Stack<Node>();
      System.out.print("\n" + n.c);
      
      s.push(n);
      while(!s.isEmpty()) {
         n = s.pop();         
         Iterator<Map.Entry<Character, Node>> j = n.m.entrySet().iterator();
         while(j.hasNext()) {
            Character c = j.next().getKey();
            System.out.print(n.m.get(c).c);
            Node tmp = n.m.get(c);
            s.push(tmp);
         }
      }
   }
   
   public void printTrie() {
      Node n = root;     
      Iterator<Map.Entry<Character, Node>> j = n.m.entrySet().iterator();
      while(j.hasNext()) {
         Character c = j.next().getKey();
         Node tmp = n.m.get(c);
         printTrie(tmp);
      }
   }
   
   public static void main(String[] args) {
      
      System.out.println("Problem 1");
      StringsJoinWordsToMakePalindrome mp = new StringsJoinWordsToMakePalindrome(); 
      
      String[] words = {"bat", "tab", "cat"};
      Tuple t = mp.joinWordsToMakePalindrome(words);
      System.out.println(t.word1 + " : " + t.word2);
      
      System.out.print("Trie 1: ");
      mp.printTrie();
      
      
      System.out.println("\nProblem 2");
      StringsJoinWordsToMakePalindrome mp2 = new StringsJoinWordsToMakePalindrome(); 
      
      String[] words2 = {"ab", "deedba"}; 
      Tuple t2 = mp2.joinWordsToMakePalindrome(words2);
      System.out.println(t2.word1 + " : " + t2.word2);
      
      System.out.print("Trie 2: ");
      mp2.printTrie();
      
      System.out.println("\nProblem 3");
      StringsJoinWordsToMakePalindrome mp3 = new StringsJoinWordsToMakePalindrome(); 
      
      String[] words3 = {"ant", "cat", "dog"};
      Tuple t3 = mp2.joinWordsToMakePalindrome(words3);
      System.out.print(t3.word1 + " : " + t3.word2);
      
   }
}
