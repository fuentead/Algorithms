package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * ---
 * Detect Cycle in a directed graph 
 * --
 */
public class GraphsDetectCycle extends Graph{

	public enum Vertices {
		WHITE, 
		GRAY, 
		BLACK
	}
	
	public GraphsDetectCycle() {
		super();
	}
	
	/*
	 * DFS & Color Method
	 * WHITE: Vertex not processed.
	 * GRAY: Vertex being processed.
	 * BLACK: Vertex and all descendants are processed.
	 */
	public boolean detectCycleDFSUtil(List<Integer>[] graph, Vertices[] visited, int v) {
		visited[v] = Vertices.GRAY;
		
		// Visit all the adjacent vertices for this vertex
		int adjnum = graph[v].size();
		for(int i=0; i<adjnum; i++) {
			int vertex = graph[v].get(i);
			
			if(visited[vertex] == Vertices.GRAY)
				return true;
			
			if(visited[vertex] == Vertices.WHITE && detectCycleDFSUtil(graph, visited, vertex))
				return true;
		}	
		
		// Mark vertex as processed
		visited[v] = Vertices.BLACK;
		
		return false;
	}
	
	public boolean detectCycleDFS(List<Integer>[] graph) {
		int n = graph.length;
		Vertices[] visited = new Vertices[n];
		
		for(int i=0; i<n; i++)
			visited[i] = Vertices.WHITE;
		
		// Process all vertices
		for(int i=0; i<n; i++) {
			if(visited[i] == Vertices.WHITE) {
				if(detectCycleDFSUtil(graph, visited, i));
					return true;				
			}				
		}
		return false;
	}
	
	
	/*
	 * DFS by keeping a Visited Array and Processed Stack
	 */
	public boolean detectCycleGraph(List<Integer>[] g, int vertices) {
	   if(g.length == 0)
	      return false;
	   
	   boolean[] visited = new boolean[vertices];
	   boolean[] stack = new boolean[vertices];
	   
	   for(int i=0; i<vertices; i++) {
	      boolean hasCycle = detectCycleGraphUtil(i, g, visited, stack);
	      if(hasCycle)
	         return true;
	   }
	   return false;
	}
	
	private static boolean detectCycleGraphUtil(int v, List<Integer>[] g, boolean[] visited, boolean[] stack) {
	   
	   if(visited[v] == false) {
	      visited[v] = true;
	      stack[v] = true;
	      Iterator<Integer> it = g[v].iterator();
	      while(it.hasNext()) {
	         Integer n = it.next();
	         if(!visited[n] && detectCycleGraphUtil(n, g, visited, stack)) {
	            return true;
	         }
	         else if(stack[v])
	            return true;	            
	      }
	   }
	   stack[v] = false;
	   return false;
	}
	
	public static void main(String[] args) {
		
		GraphsDetectCycle dc = new GraphsDetectCycle();
		List<Integer>[] graph = dc.createGraphWithCycle(4);		
		boolean isCycleDFS = dc.detectCycleDFS(graph);
		System.out.println("Does Graph has a Cycle: " + isCycleDFS);

		GraphsDetectCycle dcb = new GraphsDetectCycle();
		List<Integer>[] graphb = dcb.createGraphWithCycle2(3);
		boolean isCycleDFSb = dcb.detectCycleDFS(graphb);
		System.out.println("Does Graphb has a Cycle: " + isCycleDFSb);
		
		GraphsDetectCycle dcc = new GraphsDetectCycle();
		List<Integer>[] graphc = dcc.createGraphWithCycle3(3);
		boolean isCycleDFSc = dcc.detectCycleDFS(graphc);
		System.out.println("Does Graphc has a Cycle: " + isCycleDFSc);
		
		GraphsDetectCycle dcg = new GraphsDetectCycle();
		int vertices = 3;
      List<Integer>[] gc = dcg.createGraphWithCycle3(vertices);
      boolean hasCycle = dcg.detectCycleGraph(gc, vertices);
      System.out.println("Does Graphd has a Cycle: " + hasCycle);
	}
}
