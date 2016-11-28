package ipractice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Adriana Fuentes
 */
public class Graph {
	public List<Integer>[] adj;
	public int size;
	
	public void addVertices(int n) {
		size = n;		
		adj = new ArrayList[size];
		for(int i=0; i<size; i++)
			adj[i] = new ArrayList<Integer>();
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public List<Integer>[] createGraphWithCycle(int V) {		
		addVertices(V);		
		addEdge(0,2);
		addEdge(0,1);
		addEdge(1,2);
		addEdge(2,3);
		addEdge(2,0);
		addEdge(3,3);
		return adj;
	}
	
	public List<Integer>[] createGraphWithCycle2(int V) {
		addVertices(V);		
		addEdge(0,1);
		addEdge(1,2);
		addEdge(2,0);	
		return adj;
	}
	
	public List<Integer>[] createGraphWithCycle3(int V) {
		addVertices(V);		
		addEdge(0,1);
		addEdge(0,2);
		addEdge(1,2);		
		return adj;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.createGraphWithCycle(4);				
	}
}
