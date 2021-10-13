//package com.rit.hw.bc.updated

/**
 * Filename - Chess3D.java
 *
 * Problem Statement - Find the maximum number of rooks, bishops, queens and knights
 * 					   that can be placed on a 3D chessboard with holes.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Chess3D {
    /**
     * @param args -  file name (optional)
     *
     * The main method calls the subsequent methods finding the
     * required values.
     */
    public static void startGame(String[] args) {
        placeOnBoard(new Rook3D(), Integer.parseInt(args[3]));
        placeOnBoard(new Bishop3D(), Integer.parseInt(args[3]));
        placeOnBoard(new Queen3D(), Integer.parseInt(args[3]));
        placeOnBoard(new Knight3D(), Integer.parseInt(args[3]));
    }

    /**
     * @param chessPiece - chess piece to be placed
     *
     * The method prints the board the number of rooks
     * placed.
     */
    public static void placeOnBoard(Rook3D chessPiece, int size) {
        ChessBoard3D gameBoard = new ChessBoard3D(size);
        chessPiece.moveOnBoard(gameBoard);
    }

    /**
     * @param chessPiece - chess piece to be placed
     *
     * The method prints the board the number of bishops
     * placed.
     */
    public static void placeOnBoard(Bishop3D chessPiece, int size) {
        ChessBoard3D gameBoard = new ChessBoard3D(size);
        chessPiece.moveOnBoard(gameBoard);
    }

    /**
     * @param chessPiece - chess piece to be placed
     *
     * The method prints the board the number of queens
     * placed.
     */
    public static void placeOnBoard(Queen3D chessPiece, int size) {
        ChessBoard3D gameBoard = new ChessBoard3D(size);
        chessPiece.moveOnBoard(gameBoard);
    }

    /**
     * @param chessPiece - chess piece to be placed
     *
     * The method prints the board the number of queens
     * placed.
     */
    public static void placeOnBoard(Knight3D chessPiece, int size) {
        ChessBoard3D gameBoard = new ChessBoard3D(size);
        chessPiece.moveOnBoard(gameBoard);
    }

}