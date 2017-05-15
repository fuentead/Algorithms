package ipractice;


/**
 * @author Adriana Fuentes
 * Place N Queens on a chessboard so that no two queens are in line of attack of each other.
 */
public class RecursionNQueens {
	
	public int[] nQueen(int n) {
		int[] board = new int[n];	
		for(int i=0; i<n; i++)
			board[i] = -1;
		nQueenArrangement(n, board, 0);
		return board;
	}
	
	private boolean nQueenArrangement(int n, int[] board, int colN) {
		int row;
		if(colN >= n)
			return true;
		else 
			row=0;
		
		while(row < n) { 
			if(isSafe(board, row, colN)) {
				board[colN] = row;
				boolean res = nQueenArrangement(n, board, colN+1);
				if(res)
					return res;
				else
					row++;
			}
			else {
				row++;
			}
			
		}		
		return false;
	}

	/*
	 * Storing all values of Chess in a one dimensional 
	 * Row Check => Check that is not in same row
	 * Diagonal Check => Absolute value of the difference between 
	 *                   rows must not be equal to absolute value
	 *                   of difference between columns
	 */
	private boolean isSafe(int[] board, int row, int colN) {	
		for(int i=0; i< colN; i++) {
			// Row Check
			if(board[i] == row) {
				return false;
			}
			// Diagonal Check
			if(Math.abs(board[i] - row) == Math.abs(i-colN)) {
				return false;		
			}
		}		
		return true;
	}
	
	private void printBoard(int[] board) {
		int row = 0;
		for(int i=0; i< board.length; i++) {
			for(int j=0; j<board.length; j++) {
				if(board[j] == row)
					System.out.print("Q ");
				else 
					System.out.print("- ");
			}
			row++;
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		RecursionNQueens nq = new RecursionNQueens();
		
		int[] board = nq.nQueen(4);
		for(int c : board)
			System.out.print(c + " ");
		System.out.print("\n");
		
		nq.printBoard(board);
	}
}
