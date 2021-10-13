package com.rit.hw.assignment7C;

/**
 * Filename - Rook.java
 *
 * Problem Statement - Defines the Rook chess piece.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Rook implements ChessPiece{


	/**
	 * @param gameBoard - board on which pieces are placed
	 *
	 * The method places rooks on the board
	 * and blocks the square(s) that can't be occupied.
	 */
	@Override
	public void moveOnBoard(ChessBoard gameBoard) {
		int count = 0;
		for (int i = 0; i < gameBoard.size; i++) {
			for (int j = 0; j < gameBoard.size; j++) {
				if (!gameBoard.square[i][j].hole && !gameBoard.square[i][j].blocked) {
					gameBoard.square[i][j].piece = " R ";
					count += 1;
					gameBoard.square[i][j].block();

					blockStraight(gameBoard, i, j);
				}
			}
		}
		System.out.println(gameBoard);
		System.out.println("Maximum Rooks placed: " + count + "\n---------------------------------\n");
	}
	
	  /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method blocks the squares in the same row/col.
     */
    public void blockStraight(ChessBoard gameBoard, int i, int j){
     for (int c = 0; c < gameBoard.size; c++) {
         gameBoard.square[i][c].block();
     }
     for (int r = 0; r < gameBoard.size; r++) {
         gameBoard.square[r][j].block();
     }
    }
}
