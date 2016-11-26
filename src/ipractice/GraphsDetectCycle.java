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
public class GraphsDetectCycle {

	public enum Vertices {
		WHITE, 
		GRAY, 
		BLACK
	}
	
	public boolean detectGraphCycle(List<Integer>[] graph) {
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
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphsDetectCycle dc = new GraphsDetectCycle();
		
		List<Integer>[] adj;
		Integer N;
		
		N=4;
		adj = new ArrayList[N];
		for(int i=0; i<N; i++)
			adj[i] = new ArrayList<Integer>();
			
		adj[0].add(2);
		adj[0].add(1);
		adj[1].add(2);
		adj[2].add(3);
		adj[2].add(0);
		adj[3].add(3);
		
		boolean isCycle = dc.detectGraphCycle(adj);
			
		System.out.println("Is Graph a Cycle: " + isCycle);
	}
}
