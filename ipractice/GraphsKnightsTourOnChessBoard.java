package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 *
 * Assume you are given a normal chessboard and
 * knight that moves like a normal chess. You are
 * given two inputs: starting location and ending
 * location in the form of x, y coordinates. The
 * goal is to calculate the shortest number of 
 * moves that the knight can take to get to the 
 * target location.
 */
public class GraphsKnightsTourOnChessBoard {
   
   static class Tuple {
      int x;
      int y;
      int moves;
      Tuple(int x,int y){
         this.x = x;
         this.y = y;
         this.moves = 0;
      }
   }  

   /*
    * Using BFS to find shortest path on knights problem.
    * Dijkstra's could also be used to find shortest path.
    */
   public static int knightsShortestMoves(int rows, int cols, int xstart, int ystart, int xend, int yend) {
      
      Tuple[] moves = {new Tuple(2,1), new Tuple(1,2), new Tuple(-2,1), new Tuple(1,-2), 
                        new Tuple(-1,2), new Tuple(-1,-2), new Tuple(2,-1), new Tuple(-2,-1)};
      
      // BFS to find minimum moves
      Queue<Tuple> q = new LinkedList<Tuple>();
      Tuple t = new Tuple(xstart, ystart);
      q.add(t);
      
      while(!q.isEmpty()) {
         t = q.poll();
         if(t != null) {
            if(t.x == xend && t.y == yend) {
               return t.moves;
            }
            
            for(int i=0; i<moves.length; i++) {
               int xtemp = t.x;
               int ytemp = t.y;
               
               xtemp = xtemp + moves[i].x;
               ytemp = ytemp + moves[i].y;
               
               isSafe(rows, cols, xtemp, ytemp);
               
               Tuple ttemp = new Tuple(xtemp, ytemp);
               ttemp.moves = t.moves+1;
               q.add(ttemp);
            }
         }
      }
      return -1;
   }
   
   public static boolean isSafe(int rows, int cols, int x, int y) {
      if(x )
   }
   
   public static void main(String[] args) {
      int res = knightsShortestMoves(8, 8, 0, 0, 7, 7);
      System.out.println(res);
   }
}
