package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Assume you are given a normal chessboard and a knight that moves like a normal chess.
 * You are given two inputs: starting location and ending location in the form of x,y
 * Coordinates. The goal is to calculate and print the shortest path that the knight can 
 * take to the target location.
 */

class Tuple {
	int x;
	int y;
	int path; 
	
	public Tuple(int x, int y, int path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}
}

public class GraphsKnightsTourOnAChessBoard {
	
	private int size;
	private int[] kx = {1, 2, 2, 1,-1,-2,-2,-1};
	private int[] ky = {2, 1,-1,-2,-2,-1, 1, 2};
	
	public GraphsKnightsTourOnAChessBoard(int size) {
		this.size = size;
	}
	
	public boolean isSafe(int x, int y) {
		if((x < size) && (y <size) && (x >=0) && (y >=0)) 
			return true;		
		else 
			return false;			
	}
	
	/*
	 * Use BFS for solution
	 */
	public int shortestPath(int xstart, int ystart, int xend, int yend){
		Queue<Tuple> q = new LinkedList<Tuple>();
		
		if(!isSafe(xend, yend)) 			
			return -1;	
		
		q.add(new Tuple(xstart, ystart, 0));
		while(!q.isEmpty()) {
			Tuple t = q.poll();			
			if(t.x == xend && t.y == yend) {			
				return t.path;
			}
			
			for(int i=0; i<size; i++) {
				int x = t.x + kx[i];
				int y = t.y + ky[i];
				if(isSafe(x,y)) 
					q.add(new Tuple(x,y,t.path+1));		
			}			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		GraphsKnightsTourOnAChessBoard cb = new GraphsKnightsTourOnAChessBoard(5);
		int path = cb.shortestPath(2, 2, 4, 1);
		System.out.println("path: " + path);
	}
}
