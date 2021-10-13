//package com.rit.hw.bc.updated

/**
 * Filename - ChessBoard3D.java
 *
 * Problem Statement - Defines the 3D ChessBoard object.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class ChessBoard3D {

    final int size;
    public ChessSquare3D[][][] square;

    public ChessBoard3D(int size){
        this.size = size;
        this.square = new ChessSquare3D[size][size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                for (int k = 0; k < size; k++){
                    this.square[i][j][k] = new ChessSquare3D(i, j, k,false);
                }
            }
        }

        this.square[0][1][0].hole = true;
        this.square[1][2][3].hole = true;
        this.square[2][1][3].hole = true;
        this.square[3][3][0].hole = true;
        this.square[3][2][2].hole = true;
        this.square[2][2][1].hole = true;
        this.square[3][0][3].hole = true;
    }

    @Override
    public String toString() {
        for ( int i = 0; i < this.size; i++ ) {
            for ( int j = 0; j < this.size; j++ ) {
                for(int k = 0; k < this.size; k++) {
                    System.out.print(this.square[i][j][k]);
                }
                System.out.println("\n");
            }
            System.out.println("\n");
        }
        return "";
    }
}
