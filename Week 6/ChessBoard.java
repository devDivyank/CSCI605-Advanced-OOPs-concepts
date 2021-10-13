//package com.rit.hw.bc.updated
/**
 * Filename - ChessBoard.java
 *
 * Problem Statement - Defines the ChessBoard object.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */


public class ChessBoard {

    final int size;
    public ChessSquare[][] square;

    public ChessBoard(int size){
        this.size = size;
        this.square = new ChessSquare[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                 this.square[i][j] = new ChessSquare(i, j, false);
            }
        }
        this.square[0][4].hole = true;
        this.square[1][2].hole = true;
        this.square[2][1].hole = true;
        this.square[3][3].hole = true;
        this.square[3][5].hole = true;
        this.square[4][4].hole = true;
        this.square[5][0].hole = true;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){
                System.out.print(this.square[i][j]);
            }
            System.out.print("\n");
        }
        return "";
    }
}
