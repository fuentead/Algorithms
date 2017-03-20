package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Build a Trie
 */
public class GraphsTrie {
   
   Node root;   

   static class Node {
      char c;
      Map<Character, Node> hm;
      boolean isWord;
      
      Node(char c, boolean isWord) {
         hm = new HashMap<Character, Node>();
         this.c = c; 
         this.isWord = isWord;
      }
   }
   
   static class Tuple {
      Node n;
      StringBuilder letters;
      
      Tuple(Node n, StringBuilder letters) {
         this.n = n;
         this.letters = letters;
      }
   }
   
   public GraphsTrie() {
      root = new Node('0', false);
   }
   
   public void add(String s) {      
      if(s.length() ==0)
         return;
      
      Node n = root;      
      int i = 0;
      while(i < s.length()-1) {
         if(!n.hm.containsKey(s.charAt(i))) 
            n.hm.put(s.charAt(i), new Node(s.charAt(i), false));        
         n = n.hm.get(s.charAt(i));
         i++;                              
      }            
      if(!n.hm.containsKey(s.charAt(i))) 
         n.hm.put(s.charAt(i), new Node(s.charAt(i), true));
      else
         n.isWord = true;
   }
   
   public boolean lookup(String s) {
      if(s.length() == 0)
         return true;
      
      Node n = root;
      int i = 0;
      while(i < s.length()-1) {
         if(!n.hm.containsKey(s.charAt(i)))
            return false;
         else {
            n = n.hm.get(s.charAt(i));
            i++;
         }
      }      
      return true;
   }
   
   public void printTrie(Node n) {
      Stack<Node> s = new Stack<Node>();
      System.out.print("\n" + n.c);
      
      s.push(n);
      while(!s.isEmpty()) {
         n = s.pop();         
         Iterator<Map.Entry<Character, Node>> j = n.hm.entrySet().iterator();
         while(j.hasNext()) {
            Character c = j.next().getKey();
            System.out.print(n.hm.get(c).c);
            Node tmp = n.hm.get(c);
            s.push(tmp);
         }
      }
   }
   
   public void printTrie() {
      Node n = root;     
      Iterator<Map.Entry<Character, Node>> j = n.hm.entrySet().iterator();
      while(j.hasNext()) {
         Character c = j.next().getKey();
         Node tmp = n.hm.get(c);
         printTrie(tmp);
      }
   }
   
   private void suggest(StringBuilder sb, Node n) {
      Stack<Tuple> s = new Stack<Tuple>();
      
      s.push(new Tuple(n, sb.append(n.c)));
      
      if(n.isWord)
         System.out.print(sb.toString());
      Tuple t;
      while(!s.isEmpty()) {
         t = s.pop();
         if(t != null) {
         Iterator<Map.Entry<Character, Node>> j = t.n.hm.entrySet().iterator();
         while(j.hasNext()) {
            Character c = j.next().getKey();
            Node tmp = n.hm.get(c);
            s.push(new Tuple(tmp, t.letters.append(c)));
            
            if(tmp != null && tmp.isWord)
               System.out.print(s.peek().letters.toString());
         }         
         }
      }
   }
   
   public void suggestWords(String s) {
      Node n = root;
      int i=0;
      while(i< s.length()) {
         if(n.hm.containsKey(s.charAt(i))) {
            System.out.println("yes it contains");
            n = n.hm.get(s.charAt(i));
            System.out.println("char " + n.c);
            i++;
         }
      }
      Iterator<Map.Entry<Character, Node>> j = n.hm.entrySet().iterator();
      while(j.hasNext()) {
         Character c = j.next().getKey();
         Node tmp = n.hm.get(c);
         suggest(new StringBuilder(s), tmp);
      }
   }
   
   
   public static void main(String[] args) {
      String[] dictionary = {"car", "arm", "plot"};
      
      GraphsTrie gt = new GraphsTrie();
      for(int i=0; i<dictionary.length; i++)
         gt.add(dictionary[i]);
      System.out.println("Result:");
      gt.printTrie();
      
      boolean res = gt.lookup("car");
      System.out.print("\ncar in trie: " + res);
      
      boolean res2 = gt.lookup("arm");
      System.out.print("\narm in trie: " + res2);
      
      boolean res3 = gt.lookup("lol");
      System.out.print("\nlol in trie: " + res3);
      
      System.out.println("\nSuggestions pl: ");
      gt.suggestWords("pl");
      
      System.out.println("Suggestions ar: ");
      gt.suggestWords("ar");
      
      /*System.out.println("Suggestions c: ");
      gt.suggestWords("c");*/
   }
}
