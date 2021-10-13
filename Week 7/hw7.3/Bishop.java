package com.rit.hw.assignment7C;

/**
 * Filename - Bishop.java
 *
 * Problem Statement - Defines the Bishop chess piece.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Bishop implements ChessPiece{

    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method places bishops on the board
     * and blocks the square(s) that can't be occupied.
     */
	@Override
	public void moveOnBoard(ChessBoard gameBoard) {
		int count = 0;
        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                if (!gameBoard.square[i][j].hole && !gameBoard.square[i][j].blocked) {
                    gameBoard.square[i][j].piece = " B ";
                    count += 1;
                    gameBoard.square[i][j].block();

                    blockDiagonal(gameBoard, i, j);
                }
            }
        }
        System.out.println(gameBoard);
        System.out.println("Maximum Bishops placed: " + count + "\n---------------------------------\n");
    }
	
    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method blocks the squares in the same diagonal.
     */
	 public void blockDiagonal(ChessBoard gameBoard, int i, int j) {
	        int row = i;
	        int col = j;
	     while (row >= 0 && col >= 0){
	         gameBoard.square[row][col].block();
	         row -= 1;
	         col -= 1;
	     }
	     row = i;
	     col = j;
	     while (row < gameBoard.size && col < gameBoard.size){
	      gameBoard.square[row][col].block();
	      row += 1;
	      col += 1;
	     }
	     row = i;
	     col = j;
	     while (row >= 0 && col < gameBoard.size){
	      gameBoard.square[row][col].block();
	      row -= 1;
	      col += 1;
	     }
	     row = i;
	     col = j;
	     while (row < gameBoard.size && col >= 0){
	      gameBoard.square[row][col].block();
	      row += 1;
	      col -= 1;
	     }
	    }
}