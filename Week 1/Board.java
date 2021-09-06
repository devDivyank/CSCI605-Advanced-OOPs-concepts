/**
 * Filename - Board.java
 * 
 * Problem Statement - To place maximum number of kings in a n*n grid 
 *                             such that they don't check each other.
 *                              
 * @author Abhijeet Mulik      - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 * 
 */
public class Board {

	/**
	 * @param args - default main argument
	 * 
	 * This method calls subsequent methods which places the king on legal 
	 * positions to avoid checks from other kings on board.
	 */
	public static final char KING = 'K';
	public static final char BLOCKED = '.';

	public static void main(String[] args) {

	    int row = 6; //row numbers of gird
		int col = 6; //column numbers of gird

		char[][] originalBoard = createBoard();
		char[][] originalBoard2 = createBoard();
		char[][] verticalBoard = createBoard();
		char[][] verticalBoard2 = createBoard();
		
		int horizontalCounter = 0;
		int horizontalCounter2 = 0;
		int verticalCounter = 0;
		int verticalCounter2 = 0
				;
		horizontalCounter = placeKingHorizontally(originalBoard, 
				            horizontalCounter, 0, 0, row,col);
		
		horizontalCounter2 = incrementHorizontalPlacement(originalBoard2,
		               		 horizontalCounter2, 0, 1, col);
		
		verticalCounter = placeKingVertically(verticalBoard, verticalCounter,
				          0, 0, row, col); 

		verticalCounter2 = incrementVerticalPlacement(verticalBoard2,
				           verticalCounter2,1, 0, col);
		
		display(horizontalCounter, horizontalCounter2, verticalCounter, 
				verticalCounter2, originalBoard, originalBoard2, 
				verticalBoard, verticalBoard2);

	}
	
	/**
	 * @param horizontalCounter - count of maximum number of kings placed on the
	 *                            board for horizontal processing with starting
	 *                            position as (0,0).
	 * @param horizontalCounter2- count of maximum number of kings placed on the
	 *                            board for horizontal processing with starting
	 *                            position as (0,1).
	 * @param verticalCounter   - count of maximum number of kings placed on the
	 *                            board for vertical processing with starting
	 *                            position as (0,0).
	 * @param verticalCounter2  - count of maximum number of kings placed on the
	 *                            board for vertical processing with starting
	 *                            position as (1,0).
	 * @param originalBoard     - final n*n grid used to display the output for 
	 *                            horizontal processing with starting position
	 *                            as (0,0).
	 * @param originalBoard2    - final n*n grid used to display the output for 
	 *                            horizontal processing with starting position
	 *                            as (0,1). 
	 * @param verticalBoard     - final n*n grid used to display the output for 
	 *                            vertical processing with starting position
	 *                            as (0,0).
	 * @param verticalBoard2    - final n*n grid used to display the output for 
	 *                            vertical processing with starting position
	 *                            as (1,0).
	 *                        
	 * This method displays the n*n grid which has maximum number of kings.
	 */
	public static void display(int horizontalCounter, int horizontalCounter2, 
			int verticalCounter, int verticalCounter2, char[][] originalBoard,
			char[][] originalBoard2, char[][] verticalBoard, 
			char[][] verticalBoard2) {
		
		if (horizontalCounter >= horizontalCounter2 
		   && horizontalCounter >= verticalCounter 
		   && horizontalCounter >= verticalCounter2 ) 
		{
			displayBoard(originalBoard, horizontalCounter);
		} else if(horizontalCounter2> verticalCounter 
		          && horizontalCounter2 >= verticalCounter2) 
		{
			displayBoard(originalBoard2, horizontalCounter2);
		} else if(verticalCounter >= verticalCounter2) 
		{
			displayBoard(verticalBoard, verticalCounter);
		} else 
		{
			displayBoard(verticalBoard2, verticalCounter2);
		}
	}
	
	/**
	 * @param verticalBoard  - final n*n grid used to display the output for 
	 *                         vertical processing with starting position
	 *                         as (0,0).
	 * @param counter        - count of maximum number of kings placed on the
	 *                         board.
	 * @param startingRow    - starting position of the row for processing.
	 * @param startingColumn - starting position of the column for processing.
     * @param row            - row number of the grid.
	 * @param col            - column number of the grid.
	 * @return               - count of kings placed on the grid so far.
	 * 
	 * This method loops through the n*n grid vertically one at a time with
	 * starting position as (0,0) and determines the legal position to place
	 *  king and blocks neighboring positions to avoid checks from other kings 
	 *  on the board. 
	 */
	public static int placeKingVertically(char[][] verticalBoard, int counter,
			int startingRow, int startingColumn, int row, int col ) {
		
		char[][] theBoard = createBoard();
		
		for (int i = startingRow; i < theBoard.length; i++) {
			for (int j = startingColumn; j < theBoard[i].length; j++) {

				if (j >= 0 && j <= row-2 && i == 0 && theBoard[j][i] != BLOCKED 
						&& theBoard[j][i] != KING) {

					counter = increamentCounter(counter, theBoard,
						      verticalBoard, j, i);

					// block neighboring row and col
					if(j > 0) {
				     	markSquaresBlocked(theBoard, j, i, true);
					}else {
						markSquaresBlocked(theBoard, j, i, false);
					}
				}
				counter = findPosition(theBoard, j, i, counter, verticalBoard, 
						  true, col - 1);
			}
		}
		return counter;
	}
	
	/**
	 * @param verticalBoard2 - final n*n grid used to display the output for 
	 *                         vertical processing with starting position
	 *                         as (1,0).
	 * @param counter        - count of maximum number of kings placed on the
	 *                         board.
	 * @param startingRow    - starting position of the row for processing.
	 * @param startingColumn - starting position of the column for processing.
	 * @param col            - column number of the grid.
	 * @return               - count of kings placed on the grid so far.
	 * 
	 * This method loops through the n*n grid vertically one at a time with 
	 * starting position as (1,0)and determines the legal position to place 
	 * king and blocks neighboring positions to avoid checks from other kings 
	 *  on the board. 
	 */
	public static int incrementVerticalPlacement(char[][] verticalBoard2,
			int counter, int startingRow, int startingColumn, int col) {
		
		char[][] theBoard = createBoard();
		
		for (int i = startingRow; i < theBoard.length; i++) {
			for (int j = startingColumn; j < theBoard.length; j++) {

				if (j == 0 && i > 0 && i < col-1 && theBoard[j][i] != BLOCKED //
						&& theBoard[j][i] != KING) {

					counter = increamentCounter(counter, theBoard, 
							verticalBoard2, j, i);

					// block neighboring row and col
					theBoard[j][i - 1] = BLOCKED;
					theBoard[j][i + 1] = BLOCKED;
					theBoard[j + 1][i - 1] = BLOCKED;
					theBoard[j + 1][i] = BLOCKED;
					theBoard[j + 1][i + 1] = BLOCKED;

				}
				counter = findPosition(theBoard, j, i, counter, verticalBoard2,
						  false, col - 1);
			}
		}
		return counter;
		
	}

	/**
	 * @param originalBoard   - final n*n grid used to display output.
	 * @param counter         - count of maximum number of kings placed on the
	 *                          board.
	 * @param startingRow     - starting position of the row for processing.
	 * @param startingColumn  - starting position of the column for processing.
	 * @param row             - row number of the grid.
	 * @param col             - column number of the grid.
	 * @return                - count of kings placed on the grid so far.
	 * 
	 * This method loops through the n*n grid horizontally one at a time with 
	 * starting position as (0,0) and determines the legal position to place
	 *  king and blocks neighboring positions to avoid checks from other kings 
	 *  on the board. 
	 */
	public static int placeKingHorizontally(char[][] originalBoard, int counter,           
			int startingRow, int startingColumn, int row, int col) {

		char[][] theBoard = createBoard();

		for (int i = startingRow; i < theBoard.length; i++) {
			for (int j = startingColumn; j < theBoard[i].length; j++) {

				if (i >= 0 && i <= row-2 && j == 0 && theBoard[i][j] != BLOCKED 
						&& theBoard[i][j] != KING) {

					counter = increamentCounter(counter, theBoard,
							originalBoard, i, j);

					// block neighboring row and col
					markSquaresBlocked(theBoard, i, j, false);
				}
				counter = findPosition(theBoard, i, j, counter, originalBoard, 
						  false, col - 1);
			}
		}
		return counter;

	}

	/**
	 * @param theBoard       - n*n grid on which kings are placed.
	 * @param row            - row number of the grid.
	 * @param col            - column number of the grid.
	 * @param counter        - count of maximum number of kings placed on the
	 *                         board.
	 * @param originalBoard  - final n*n grid used to display output.
	 * @param isValid        - conditional flag to determine if the position 
	 *                         method is trying to mark as illegal exists on the
	 *                         gird, isValid is true for vertical processing
	 *                         only. 
	 * @param endpoint       - edge point of the grid.
	 * @return               - count of kings placed on the grid so far.
	 * 
	 * This method determines the legal position to place king and blocks 
	 * neighboring positions to avoid checks from other kings on the board for 
	 * conditions generic to horizontal and vertical processing.
	 */
	public static int findPosition(char theBoard[][], int row, int col, 
			int counter, char originalBoard[][], boolean isValid, int endpoint)
	   {
		
		if (row == 0 && col == endpoint && theBoard[row][col] != BLOCKED
				&& theBoard[row][col] != KING) {

			counter = increamentCounter(counter, theBoard, originalBoard, 
					  row, col);
			
			theBoard[row + 1][col] = BLOCKED;

		} else if (row == endpoint && col == endpoint && theBoard[row][col] != 
					 BLOCKED && theBoard[row][col] != KING) {

			counter = increamentCounter(counter, theBoard, originalBoard, 
					  row, col);

		} else if (row > 0 && row < endpoint && col == endpoint
				&& theBoard[row][col] != BLOCKED && theBoard[row][col] != KING)
		{

			counter = increamentCounter(counter, theBoard, originalBoard, 
					  row, col);
			
			theBoard[row + 1][col] = BLOCKED;
			theBoard[row + 1][col - 1] = BLOCKED;

		} else if (row == endpoint && col >= 0 && col < endpoint 
				&& theBoard[row][col] != BLOCKED && theBoard[row][col] != KING)
		{

			counter = increamentCounter(counter, theBoard, originalBoard, 
					  row, col);
			
			theBoard[row][col + 1] = BLOCKED;
			if(isValid) {
				
				theBoard[row-1][col + 1] = BLOCKED;
				
			}

		} else if (theBoard[row][col] != BLOCKED && theBoard[row][col] != KING) 
		
		{

			counter = increamentCounter(counter, theBoard, originalBoard, 
					  row, col);
			
			markSquaresBlocked(theBoard, row, col, false);

			if (row > 0 && col > 0) {
				theBoard[row][col - 1] = BLOCKED;
				theBoard[row + 1][col - 1] = BLOCKED;
				theBoard[row - 1][col + 1] = BLOCKED; 
			}else if (col > 0) {
				
				theBoard[row + 1][col - 1] = BLOCKED;
				
			}
		}
		return counter;
	}
	
	/**
	 * @param originalBoard2  - final n*n grid used to display output.
	 * @param counter         - count of maximum number of kings placed on the
	 *                          board.
	 * @param startingRow     - starting position of the row for processing.
	 * @param startingColumn  - starting position of the column for processing.
	 * @param col             - column number of the grid.
	 * @return                - count of kings placed on the grid so far.
	 * 
	 * This method loops through the n*n grid horizontally one at a time with 
	 * starting position as (0,1) and determines the legal position to place
	 *  king and blocks neighboring positions to avoid checks from other kings 
	 *  on the board. 
	 */
	public static int incrementHorizontalPlacement(char[][] originalBoard2,
			int counter, int startingRow, int startingColumn, int col) {

		char[][] theBoard = createBoard();

		for (int i = startingRow; i < theBoard.length; i++) {
			for (int j = startingColumn; j < theBoard.length; j++) {

				if (i == 0 && j > 0 && j < col-1 && theBoard[i][j] != BLOCKED
						&& theBoard[i][j] != KING) {

					counter = increamentCounter(counter, theBoard, 
							originalBoard2, i, j);

					// block neighboring row and col
					theBoard[i][j - 1] = BLOCKED;
					theBoard[i + 1][j - 1] = BLOCKED;
					theBoard[i + 1][j] = BLOCKED;
					theBoard[i][j + 1] = BLOCKED;
					theBoard[i + 1][j + 1] = BLOCKED;

				}
				counter = findPosition(theBoard, i, j, counter, originalBoard2,
						  false, col - 1);
			}
		}
		return counter;
	}

	/**
	 * @param counter        - count of maximum number of kings placed on the 
	 *                         board.
	 * @param theBoard       - n*n grid on which kings are placed.
	 * @param originalBoard  - final n*n grid used to display output.
	 * @param row            - row number of the grid.
	 * @param col            - column number of the grid.
	 * @return               - count of kings placed on the grid so far.
	 * 
	 * This method places the king on legal position and increments the count
	 * of kings.  
	 */
	public static int increamentCounter(int counter, char[][] theBoard,
			char[][] originalBoard, int row, int col) {

		theBoard[row][col] = KING;
		originalBoard[row][col] = KING;
		counter += 1;
		return counter;
	}

	
	/**
	 * @param - none
	 * @return - new n*n board
	 * 
	 * This method returns new n*n grid.
	 */
	public static char[][] createBoard() { 
		
		return new char[][] {{'w','b','w','b','w','b'},
                             {'.','w','.','w','.','w'},
                             {'w','.','.','.','w','b'},
                             {'b','.','b','.','b','w'},
                             {'.','.','.','.','.','b'},
                             {'b','w','b','w','b','w'}}; 
	
	}

	/**
	 * @param theBoard   - n*n grid on which kings are placed.
	 * @param row        - row number of the grid.
	 * @param col        - column number of the grid
	 * @param isVertical - flag to block neighboring squares on grid for 
	 *                     vertical processing.
	 *                     
	 *@return            - none
	 *
	 * This method will make the neighboring squares of square where king is 
	 * placed illegal, so no other king checks the existing king.
	 */
	public static void markSquaresBlocked(char[][] theBoard, int row, int col,
			boolean isVertical) {

		theBoard[row][col + 1] = BLOCKED;
		theBoard[row + 1][col] = BLOCKED;
		theBoard[row + 1][col + 1] = BLOCKED;
		
		if(isVertical) {
			theBoard[row -1][col + 1] = BLOCKED;
		}
	}

	/**
	 * @param theBoard  - n*n grid on which kings are placed.
	 * @param counter   - Count of maximum number of kings placed on the board.
	 * 
	 * 
	 * This method displays the output in expected format.
	 */
	public static void displayBoard(char[][] theBoard, int counter) {

		System.out.println("Maximum number of Kings placed on board is :"
		+ counter + "\n");

		for (int i = 0; i < theBoard.length; i++) {
			for (int j = 0; j < theBoard[i].length; j++) {
				System.out.print(theBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
