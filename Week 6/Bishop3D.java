//package com.rit.hw.bc.updated

/**
 * Filename - Bishop3D.java
 *
 * Problem Statement - Defines the Bishop chess piece.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Bishop3D extends ChessPiece3D {
    @Override
    public void moveOnBoard(ChessBoard3D gameBoard) {
        int count = 0;
        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                for (int k = 0; k < gameBoard.size; k++){
                    if (!gameBoard.square[i][j][k].hole && !gameBoard.square[i][j][k].blocked) {
                        gameBoard.square[i][j][k].piece = " B ";
                        count += 1;
                        gameBoard.square[i][j][k].block();

                        blockDiagonal(gameBoard, i, j, k);
                    }
                }

            }
        }
        System.out.println(gameBoard);
        System.out.println("Maximum Bishops placed: " + count + "\n---------------------------------\n");
    }

}
