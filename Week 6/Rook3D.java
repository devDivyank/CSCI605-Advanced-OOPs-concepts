//package com.rit.hw.bc.updated

/**
 * Filename - Rook3D.java
 *
 * Problem Statement - Defines the Rook chess piece.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Rook3D extends ChessPiece3D {
    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method places rooks on the 3D board
     * and blocks the square(s) that can't be occupied.
     */
    @Override
    public void moveOnBoard(ChessBoard3D gameBoard) {
        int count = 0;
        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                for (int k = 0; k < gameBoard.size; k++){
                    if (!gameBoard.square[i][j][k].hole && !gameBoard.square[i][j][k].blocked) {
                        gameBoard.square[i][j][k].piece = " R ";
                        count += 1;
                        gameBoard.square[i][j][k].block();

                        blockStraight(gameBoard, i, j, k);
                    }
                }
            }
        }
        System.out.println(gameBoard);
        System.out.println("Maximum Rooks placed: " + count + "\n---------------------------------\n");
    }
}
