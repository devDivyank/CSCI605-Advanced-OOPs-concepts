package com.rit.hw.assignment7C;
/**
 * Filename - Queen.java
 *
 * Problem Statement - Defines the Queen chess piece.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Queen implements ChessPiece{
	
	Rook rook = new Rook();
	Bishop bishop = new Bishop();

    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method places queens on the board
     * and blocks the square(s) that can't be occupied.
     */
    @Override
    public void moveOnBoard(ChessBoard gameBoard) {
        int count = 0;
        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                if (!gameBoard.square[i][j].hole && !gameBoard.square[i][j].blocked) {
                    gameBoard.square[i][j].piece = " Q ";
                    count += 1;
                    gameBoard.square[i][j].block();

                    rook.blockStraight(gameBoard, i, j);
                    bishop.blockDiagonal(gameBoard, i, j);
                }
            }
        }
        System.out.println(gameBoard);
        System.out.println("Maximum Queens placed: " + count + "\n---------------------------------\n");
    }

}
