package com.rit.hw.assignment7B;
/**
 * Filename - ChessPiece.java
 *
 * Problem Statement - Defines the abstract class ChessPiece which is
 * extended by the chess pieces.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

//package ChessBoard;

public abstract class ChessPiece {

    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method is implemented by every piece based on
     * its movement.
     */
    public abstract void moveOnBoard(ChessBoard gameBoard);

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
