package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * ---
 * Given a directed graph, check whether there 
 * is a cycle in it.
 * 
 * There can be multiple cycles. No need to print.
 * Just return true/ false if there is a cycle.
 * --
 */
public class GraphsDetectingCycleInGraph {
   
   public static Map<Integer, Vertex> g = new HashMap<Integer,Vertex>();

   static class Vertex {
      int value;
      List<Integer> edges;
      boolean visited;
      Vertex(int val) {
         this.value = val;
         edges = new ArrayList<Integer>();
         this.visited = false;
      }
   }
   
   public static Vertex addVertexEdges(int vertexVal, int[] edges) {      
      Vertex v = new Vertex(vertexVal);
      for(int i=0; i<edges.length; i++)
         v.edges.add(edges[i]);      
      return v;
   }
   
   public static Vertex createGraph() {
      int[] edges1 = {2,3};
      int[] edges2 = {4};
      int[] edges3 = {};
      int[] edges4 = {};
      
      Vertex v1 = addVertexEdges(1, edges1);
      g.put(v1.value, v1);      
      Vertex v2 = addVertexEdges(2, edges2);
      g.put(v2.value, v2);     
      Vertex v3 = addVertexEdges(3, edges3);
      g.put(v3.value, v3);      
      Vertex v4 = addVertexEdges(4, edges4);
      g.put(v4.value, v4);
      return v1;
   }
   
   public static Vertex createGraph2() {
      int[] edges1 = {2,3};
      int[] edges2 = {3};
      int[] edges3 = {4};
      int[] edges4 = {1};
      
      Vertex v1 = addVertexEdges(1, edges1);
      g.put(v1.value, v1);      
      Vertex v2 = addVertexEdges(2, edges2);
      g.put(v2.value, v2);     
      Vertex v3 = addVertexEdges(3, edges3);
      g.put(v3.value, v3);      
      Vertex v4 = addVertexEdges(4, edges4);
      g.put(v4.value, v4);
      return v1;
   }
   
   public static boolean detectCycle(Vertex v, Map<Integer, Vertex> graph) {
      Queue<Vertex> q = new LinkedList<Vertex>();
      q.add(v);
      while(!q.isEmpty()) {
         Vertex vtmp = q.poll();
         if(vtmp != null) {
            if(vtmp.visited == true)
               return true;
            else {
               vtmp.visited = true;
               for(int i=0; i<vtmp.edges.size(); i++) {
                  int vertexVal = vtmp.edges.get(i);
                  vtmp = graph.get(vertexVal);
                  q.add(vtmp);
               }
            }  
         }
      }
      return false;
   }
   
   public static void main(String[] args) {
      Vertex v = createGraph();      
      boolean res = detectCycle(v, g);
      System.out.println("Problem 1 - Cycle detected: " + res);
      
      Vertex v2 = createGraph2();      
      boolean res2 = detectCycle(v2, g);
      System.out.println("Problem 2 - Cycle detected: " + res2);
   }
}
