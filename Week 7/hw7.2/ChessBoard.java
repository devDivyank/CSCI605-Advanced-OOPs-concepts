package com.rit.hw.assignment7B;
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

    public ChessBoard(int size, 
    		String [] args){
        this.size = size;
        this.square = new ChessSquare[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                 this.square[i][j] = new ChessSquare(i, j, false);
            }
        }
        
		for (int i = 5; i < args.length; i+=2) {
			
			int row = Integer.valueOf(args[i].substring(0, 1));
			int col = Integer.valueOf(args[i].substring(2));
			
			this.square[row][col].hole = true;
			
		}
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
    
    public void block(int row, int col) {
    	
    	
    	
    }
}
