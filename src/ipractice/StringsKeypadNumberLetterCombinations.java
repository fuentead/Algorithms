package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Keypad Number Letter Combinations
 * --
 */

public class StringsKeypadNumberLetterCombinations {
   
   static class Node {
      char c;
      Map<Character, Node> nextLetters;
      Node(char c) {
         this.c = c;
         nextLetters = new HashMap<Character, Node>();
      }
   }
   
   public static void keypadLetterCombinations(String num, String[] dict) {
      if(num.length() == 0)
         return;      
      
      Map<Integer, String> keypad = new HashMap<Integer, String>();
      int len = num.length();
      char[] res = new char[len];
      
      fillKeypad(keypad);
      Node root = buildTrie(dict);  
      printTrieDFS(root);
      keypadLetterCombinationsHelper(num, 0, dict, keypad, res, root);
   }
   
   private static void keypadLetterCombinationsHelper(String num, int level, String[] dict, Map<Integer, String> keypad, char[] res, Node pNode) {
      if(level >= num.length()) {
         System.out.println(new String(res));
         return;
      }
      int inum = Character.getNumericValue(num.charAt(level));
      String cdata = keypad.get(inum);
      for(int i=0; i<num.length(); i++){
         char c = cdata.charAt(i);
         if(pNode.nextLetters.containsKey(c)) {
            res[level] = cdata.charAt(i);
            Node tNode = pNode.nextLetters.get(c);
            keypadLetterCombinationsHelper(num, level+1, dict, keypad, res, tNode);
            res[level] = ' ';
         }
      }
   }

   public static void fillKeypad(Map<Integer, String> keypad) {
      keypad.put(2, "ABC");
      keypad.put(3, "DEF");
      keypad.put(4, "GHI");
      keypad.put(5, "JKL");
      keypad.put(6, "MNO");
      keypad.put(7, "PQRS");
      keypad.put(8, "TUV");
      keypad.put(9, "WXYZ");
   }
   
   private static Node buildTrie(String[] dict) {
      if(dict.length == 0)
         return null;

      Node root = new Node('-');
      Node n;
      for(int i=0; i<dict.length; i++) {
         n = root;
         for(int j=0; j<dict[i].length(); j++) {
            String ckey = dict[i];
            if(n.nextLetters.containsKey(ckey.charAt(j))) {
               n = n.nextLetters.get(ckey.charAt(j));
            }
            else {
               Node tmp = new Node(ckey.charAt(j));
               n.nextLetters.put(ckey.charAt(j), tmp);
               n = tmp;
            }           
         }
      }
      return root;
   }
   
   private static void printTrieDFS(Node root) {
      Stack<Node> s = new Stack<Node>();
      s.push(root);
      while(!s.isEmpty()) {
         Node tmp = s.pop();
         if(tmp.c != ' ') {
            System.out.print(tmp.c + " ");
            Iterator it = tmp.nextLetters.entrySet().iterator();
            while(it.hasNext()) {
               Map.Entry<Character, Node> pair = (Map.Entry<Character, Node>) it.next();
               s.push(pair.getValue());
            }           
         }
      }
      System.out.print("\n");
   }

   public static void main(String[] args) {
      String[] dict = {"AAC", "BAU", "CAT", "BAT"};
      keypadLetterCombinations("228", dict);
   }
}
