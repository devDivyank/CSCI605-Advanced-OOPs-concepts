//package com.rit.hw.bc.updated
/**
 * Filename - ChessPiece3D.java
 *
 * Problem Statement - Defines the abstract class ChessPiece which is
 * extended by the chess pieces.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public abstract class ChessPiece3D {

    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method is implemented by every piece based on
     * its movement.
     */
    public abstract void moveOnBoard(ChessBoard3D gameBoard);

    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method blocks the squares in the same row/col.
     */
    public void blockStraight(ChessBoard3D gameBoard, int row, int col, int hei){
        for (int c = 0; c < 4; c++) {
                gameBoard.square[row][c][hei].block();
        }
        for (int r = 0; r < 4; r++) {
                gameBoard.square[r][col][hei].block();
        }
        for (int h = 0; h < 4; h++) {
                gameBoard.square[row][col][h].block();
        }
    }

    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method blocks the squares in the same diagonal.
     */
    public void blockDiagonal(ChessBoard3D gameBoard, int i, int j, int k) {
        int row = i;
        int col = j;
        int hei = k;
        // side 1
        {
            while (row >= 0 && col >= 0) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                col -= 1;
            }
            row = i;
            col = j;
            while (row < gameBoard.size && col < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                col += 1;
            }
            row = i;
            col = j;
            while (row >= 0 && col < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                col += 1;
            }
            row = i;
            col = j;
            while (row < gameBoard.size && col >= 0) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                col -= 1;
            }
        }
        // side 2
        row = i;
        col = j;
        hei = k;
        {
            while (row >= 0 && hei >= 0) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                hei -= 1;
            }
            row = i;
            hei = k;
            while (row < gameBoard.size && hei < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                hei += 1;
            }
            row = i;
            hei = k;
            while (row >= 0 && hei < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                hei += 1;
            }
            row = i;
            hei = k;
            while (row < gameBoard.size && hei >= 0) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                hei -= 1;
            }
        }
        // side3
        row = i;
        col = j;
        hei = k;
        {
            while (hei >= 0 && col >= 0) {
                gameBoard.square[row][col][hei].block();
                hei -= 1;
                col -= 1;
            }
            hei = k;
            col = j;
            while (hei < gameBoard.size && col < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                hei += 1;
                col += 1;
            }
            hei = k;
            col = j;
            while (hei >= 0 && col < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                hei -= 1;
                col += 1;
            }
            hei = k;
            col = j;
            while (hei < gameBoard.size && col >= 0) {
                gameBoard.square[row][col][hei].block();
                hei += 1;
                col -= 1;
            }
        }
        // cross-diagonals
        row = i;
        col = j;
        hei = k;
        {
            while (row < gameBoard.size && col < gameBoard.size && hei < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                col += 1;
                hei += 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row < gameBoard.size && col < gameBoard.size && hei >= 0) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                col += 1;
                hei -= 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row < gameBoard.size && col >= 0 && hei < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                col -= 1;
                hei += 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row >= 0 && col < gameBoard.size && hei < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                col += 1;
                hei += 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row >= 0 && col >= 0 && hei >= 0) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                col -= 1;
                hei -= 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row >= 0 && col >= 0 && hei < gameBoard.size) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                col -= 1;
                hei += 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row >= 0 && col < gameBoard.size && hei >= 0) {
                gameBoard.square[row][col][hei].block();
                row -= 1;
                col += 1;
                hei -= 1;
            }
            row = i;
            col = j;
            hei = k;
            while (row < gameBoard.size && col >= 0 && hei >= 0) {
                gameBoard.square[row][col][hei].block();
                row += 1;
                col -= 1;
                hei -= 1;
            }
        }
    }

}
