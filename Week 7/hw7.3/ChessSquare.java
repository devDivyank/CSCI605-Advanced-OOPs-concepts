package com.rit.hw.assignment7C;
/**
 * Filename - ChessSquare.java
 *
 * Problem Statement - Defines the ChessSquare object.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class ChessSquare {
    private int x;
    private int y;
    boolean hole;
    boolean blocked;
    String toPrint;
    String piece = "";

    public ChessSquare(int x, int y, boolean hole){
        this.x = x;
        this.y = y;
        this.hole = hole;
    }

    public void block(){
        this.blocked = true;
    }

    @Override
    public String toString() {
        if ((this.x+this.y)%2 == 0 && !this.hole){
            this.toPrint = " w ";}
        else if ((this.x+this.y)%2 != 0 && !this.hole){
            this.toPrint = " b ";
        } else if (this.hole){
            this.toPrint = " _ ";
        }
        if(!this.piece.equals("")) {
        	this.toPrint = this.piece;
        }

        return toPrint;
    }
    	
}

