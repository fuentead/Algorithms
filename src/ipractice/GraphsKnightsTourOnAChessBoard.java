package ipractice;

/**
 * @author Adriana Fuentes
 * 
 * Assume you are given a normal chessboard and a knight that moves like a normal chess.
 * You are given two inputs: starting location and ending location in the form of x,y
 * Coordinates. The goal is to calculate and print the shortest path that the knight can 
 * take to the target location.
 */

public class GraphsKnightsTourOnAChessBoard {
	
	private int[] kx = {1, 2, 2, 1,-1,-2,-2,-1};
	private int[] ky = {2, 1,-1,-2,-2,-1, 1, 2};
	private int size = 8;

	public boolean isSafe(int x, int y, int[][] solution) {
		if((x < size) && (y <size) && (x >=0) && (y >=0) && (solution[x][y] == -1)) 
			return true;		
		else 
			return false;			
	}
	

	/*
	 * Use Backtracking for solution
	 */
	public boolean knightTour(int xstart, int ystart, int xend, int yend) {
	   if(xstart == xend && ystart == yend) {
	      System.out.println("moves: 0");
	      return true;
	   }
	   
	   int[][] soln = new int[size][size];
	   for(int i=0; i<size; i++)
	      for(int j=0; j<size; j++)
	         soln[i][j] = -1;
	   soln[xstart][ystart] = 0;
	   
	   int nummoves=0;
	   boolean res = knightTourUtil(xstart, ystart, xend, yend, nummoves+1, soln);
	   if(res) {
	      return true;
	   }
	   else {
	      System.out.println("No path");
	      return false;
	   }	 
	}
	
	private boolean knightTourUtil(int xstart, int ystart, int xend, int yend, int nummoves, int[][] solution) {
	   if((xstart == xend) && (ystart == yend)) {
         System.out.println("moves: " + nummoves);
         printMoves(solution);
         return true;
      }
	   
	   int nextmovex;
	   int nextmovey;
	   for(int i=0; i<kx.length; i++) {
	      nextmovey = ystart + ky[i];
	      nextmovex = xstart + kx[i];
	      if(isSafe(nextmovex, nextmovey, solution)) {
	         System.out.println("isSafe " + "nextmovex: " + nextmovex + " nextmovey " + nextmovey);
	         solution[nextmovex][nextmovey] = nummoves;
	         boolean res = knightTourUtil(nextmovex, nextmovey, xend, yend, nummoves+1, solution);
	         if(res) {
	            return true;
	         }
	         else
	            solution[nextmovex][nextmovey] = -1;
	      }
	   }
	   return false;
	}
	
	private static void printMoves(int[][] solution) {
	   for(int i=0; i<solution.length; i++){
	      for(int j=0; j<solution[i].length; j++) {
	         System.out.print(solution[i][j] + " ");
	      }
	      System.out.print("\n");
	   }
	}
	
	public static void main(String[] args) {
		GraphsKnightsTourOnAChessBoard cb = new GraphsKnightsTourOnAChessBoard();
		boolean pathExists = cb.knightTour(2, 1, 6, 2);
		System.out.println("path: " + pathExists);		
	}
}
