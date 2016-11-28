package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Detect Cycle in a directed graph using colors.
 * WHITE: Vertex not processed.
 * GRAY: Vertex being processed.
 * BLACK: Vertex and all descendants are processed.
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
	 * BFS method
	 */
	/*public boolean detectGraphCycle(List<Integer>[] graph) {
		Queue<Integer> q = new LinkedList<Integer>();
		int N = graph.length;
		Vertices[] visited = new Vertices[N];
		
		if(graph.length <=0)
			return false;
		
		for(int i=0; i<N; i++) {
			visited[i] = Vertices.WHITE;
		}
		
		q.add(0);
		while(!q.isEmpty()) {
			int v = q.poll();	
			visited[v] = Vertices.GRAY;
			for(int i=0; i < graph[v].size(); i++) {
				int adjv = graph[v].get(i);				
				if(visited[adjv] == Vertices.GRAY)
					return true;
				q.add(adjv);
			}
			visited[v] = Vertices.BLACK;
		}
		return false;
	}*/
	
	/*
	 * DFS Method
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
	}
}
