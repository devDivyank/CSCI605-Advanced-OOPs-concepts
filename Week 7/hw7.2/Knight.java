package com.rit.hw.assignment7B;
/**
 * Filename - Knight.java
 *
 * Problem Statement - Defines the Knight chess piece.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Knight extends ChessPiece {
	/**
	 * @param gameBoard - board on which pieces are placed
	 *
	 * The method places knights on the board
	 * and blocks the square(s) that can't be occupied.
	 */
	@Override
	public void moveOnBoard(ChessBoard gameBoard) {
		int count = 0;
		int row[] = { 1, -1, 1, -1, 2, 2, -2, -2 };
		int col[] = { 2, 2, -2, -2, -1, 1, -1, 1 };

		for (int i = 0; i < gameBoard.size; i++) {
			for (int j = 0; j < gameBoard.size; j++) {
				if (!gameBoard.square[i][j].hole && !gameBoard.square[i][j].blocked) {
					gameBoard.square[i][j].piece = " K ";
					count += 1;

					for (int k = 0; k < 8; k++) {
						int r = i + row[k];
						int c = j + col[k];
						if (r >= 0 && r < gameBoard.size && c >= 0 && c < gameBoard.size
								&& !gameBoard.square[r][c].hole) {
							gameBoard.square[r][c].block();
						}
					}
				}
			}
		}
		System.out.println(gameBoard);
		System.out.println("Maximum Knights placed: " + count + "\n---------------------------------\n");
	}
}
