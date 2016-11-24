package ipractice;

import java.util.*;

/**
 * @author Adriana Fuentes
 * 
 * Given a snake and ladder rectangular MXN board-game, find the minimum number of dice
 * throws required to reach the final cell from the 1st cell.
 * 
 * Rules are as usual: If after a dice-throw, the player reaches a cell where the ladder
 * starts, the player has to climb up that ladder and if the player reaches a cell that 
 * that has the mouth of the snake, s/he has to go down to the tail of the snake.
 * 
 * For example, in the board below, it will take a minimum of 4 throws to reach from 1 to 36. 
 */

class qEntry {
	int position;
	int pathcost;
	
	public qEntry(int position, int pathcost) {
		this.position = position;
		this.pathcost = pathcost;
	}
}

/*
 * Using BFS to solve snakes and ladder problem
 */
public class GraphsSnakesAndLaddersMatrix {
	
	public int minNumDiceThrowsSnakesAndLadders(int[] board, int size) {
		
		/*boolean[] visited = new boolean[size];
		for(int i=0; i<size; i++)
			visited[i] = false;*/
		
		Queue<qEntry> q = new LinkedList<qEntry>();
		qEntry qe = new qEntry(0,0);
		q.add(qe);
		//visited[0] = true;
		
		while(!q.isEmpty()) {
			
			// Check if we have reached destination with
			// value in the queue
			qe = q.poll();
			if(qe.position == size-1) {
				System.out.println(qe.position);
				return qe.pathcost;
			}
			else {
				//q.poll();
				// From current dist in queue, add all dice possibilities
				for(int j=1; j<= 6; j++) {				
					//if(visited[j] == false) {
					System.out.println("This is position " + qe.position + " pathcost " + qe.pathcost);
					qEntry e = new qEntry(qe.position +j, qe.pathcost+1);

					//visited[j] = true;
					
					if(e.position < size) {
						// Check if there is a ladder or snake
						if(board[e.position]!=-1)
							e.position = board[e.position];		
						q.add(e);
					}
				//}
				}
			}
		}	
		return -1;
	}

	public static void main(String[] args) {
		GraphsSnakesAndLaddersMatrix sl = new GraphsSnakesAndLaddersMatrix();
		
		int size = 30;
		int[] board = new int[size];

		board = new int[size];
			
		for(int i=0; i<size; i++) {
			board[i] = -1;
		}
			
		// Stairs
		board[2]  = 21;
		board[4]  = 7;
		board[10] = 25;
		board[19] = 28;
			
		// Snakes
		board[16] = 3;
		board[18] = 6;
		board[20] = 8;
		board[26] = 0;
		
		int minThrows = sl.minNumDiceThrowsSnakesAndLadders(board, size);	
		System.out.println("Min Throws: " + minThrows);
	}
}
