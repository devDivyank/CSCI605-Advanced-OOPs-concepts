//package com.rit.hw.bc.updated

/**
 * Filename - ChessSquare3D.java
 *
 * Problem Statement - Defines the ChessSquare object for 3D chess.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class ChessSquare3D {
    private int x;
    private int y;
    private int z;
    boolean hole;
    boolean blocked;
    String toPrint;
    String piece = "";

    public ChessSquare3D(int x, int y, int z, boolean hole){
        this.x = x;
        this.y = y;
        this.z = z;
        this.hole = hole;
    }

    public void block(){
        this.blocked = true;
    }
    public void unblock(){
        this.blocked = false;
    }

    @Override
    public String toString() {
        if ((this.x+this.y+this.z)%2 == 0 && !this.hole){
            this.toPrint = " w ";}
        else if ((this.x+this.y+this.z)%2 != 0 && !this.hole){
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

