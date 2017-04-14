package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Given a sorted dictionary of an alien
 * language, find order of characters.
 * 
 * Example 1:
 * Input: words[] = {"baa","abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * 
 * Example 2:
 * Input: words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 * 
 * Words are sorted and in the given language, "baa" comes
 * before "abcd", therefore 'b' is before 'a' in output.
 */
public class GraphsTopologicalSort {
   
   private static int numVertices;
   private static Vertex[] graph; // To record adjacent vertices
   private static List<Integer> alphaOrder; // To store order of different letters seen

   GraphsTopologicalSort(int nvertices) {
      numVertices = nvertices;
      graph = new Vertex[nvertices];
      alphaOrder = new ArrayList<Integer>();
   }
   
   static class Vertex {
      char value;
      List<Character> edges;
      Vertex(char value) {
         this.value = value;
         this.edges = new ArrayList<Character>();
      }
   }
   
   /*
    * Check for the letters that are different and 
    * establish edges amongst them.
    */
   public static void buildEdges(String w1, String w2) {
      for(int j=0; j<Math.min(w1.length(), w2.length()); j++) {
         if(w1.charAt(j) != w2.charAt(j)) {
            graph[w1.charAt(j)-'a'] = new Vertex(w1.charAt(j));
            graph[w1.charAt(j)-'a'].edges.add(w2.charAt(j));
            alphaOrder.add(w1.charAt(j)-'a');
            break;
         } 
      }      
   }
   
   /*
    * Traverse the tree created and put in a stack 
    * the alphabet seen in the correct order.
    */
   public static void printTopologicalSortUtil(int ivertex, Boolean[] visited, Stack<Integer> s) {
      visited[ivertex] = true;
           
      if(graph[ivertex]!= null) {
         for(int i=0; i<graph[ivertex].edges.size(); i++) {
            if(!visited[graph[ivertex].edges.get(i) - 'a']) {               
               printTopologicalSortUtil(graph[ivertex].edges.get(i) -'a', visited, s);               
            }
         }         
      }
      s.push(ivertex);
   }
   
   /*
    * Print alphabet represented in tree in topological
    * order
    */
   public static void printTopologicalSort(Vertex[] g) {
      if(g.length==0)
         return;

      Stack<Integer> s = new Stack<Integer>();
      Boolean[] visited = new Boolean[numVertices];
      
      for(int i=0; i<visited.length; i++) {
         visited[i] = false;
      }

      for(int i=0; i<alphaOrder.size(); i++) {         
         int ivertex = alphaOrder.get(i);
         
         if(visited[ivertex] == false) {  
            printTopologicalSortUtil(ivertex, visited, s);
         }
      }   
      
      System.out.println("\nResult: ");
      while(!s.isEmpty()) {         
         System.out.print((char)(s.pop() + 'a') + " ");
      }
   }

   public void topologicalSort(String[] words) {
      int i=0;
      while(i < words.length-1) {
         buildEdges(words[i],words[i+1]);
         i++;
      }
      printTopologicalSort(graph);
   }

   public static void main(String[] args) {
      GraphsTopologicalSort g = new GraphsTopologicalSort(4);
      String[] words = {"baa","abcd", "abca", "cab", "cad"};      
      g.topologicalSort(words);
      
      GraphsTopologicalSort g2 = new GraphsTopologicalSort(4);
      String[] words2 = {"caa", "aaa", "aab"};
      g2.topologicalSort(words2);
   }
}
