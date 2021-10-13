package com.rit.hw.assignment7C;

/**
 * Filename - Chess.java
 *
 * Problem Statement - Find the maximum number of rooks, bishops, queens and knights
 * 					   that can be placed on a 2D chessboard with holes.
 *
 * @author Abhijeet Mulik - am6492@rit.edu
 * @author Divyank Kulshrestha - dk9924@rit.edu
 */

public class Chess {
	/**
	 * @param args -  file name (optional)
	 *
	 * The main method calls the subsequent methods finding the
	 * required values.
	 */

	public static void main(String[] args) {
		if (args[1].equals("2")){
			placeOnBoard(new Rook(), Integer.parseInt(args[3]), args);
			placeOnBoard(new Bishop(), Integer.parseInt(args[3]), args);
			placeOnBoard(new Queen(), Integer.parseInt(args[3]), args);
			placeOnBoard(new Knight(), Integer.parseInt(args[3]), args);
		}
		else {
			System.out.println("This Chess game is designed for 2D only");
		}
	}

	/**
	 * @param chessPiece - chess piece to be placed
	 *
	 * The method prints the board the number of rooks
	 * placed.
	 */
	public static void placeOnBoard(Rook chessPiece, int size, String[] args) {
		ChessBoard gameBoard = new ChessBoard(size, args);
		chessPiece.moveOnBoard(gameBoard);
	}

	/**
	 * @param chessPiece - chess piece to be placed
	 *
	 * The method prints the board the number of bishops
	 * placed.
	 */
	public static void placeOnBoard(Bishop chessPiece, int size, String[] args) {
		ChessBoard gameBoard = new ChessBoard(size, args);
		chessPiece.moveOnBoard(gameBoard);
	}

	/**
	 * @param chessPiece - chess piece to be placed
	 *
	 * The method prints the board the number of queens
	 * placed.
	 */
	public static void placeOnBoard(Queen chessPiece, int size, String[] args) {
		ChessBoard gameBoard = new ChessBoard(size, args);
		chessPiece.moveOnBoard(gameBoard);
	}

	/**
	 * @param chessPiece - chess piece to be placed
	 *
	 * The method prints the board the number of knights
	 * placed.
	 */
	public static void placeOnBoard(Knight chessPiece, int size, String[] args) {
		ChessBoard gameBoard = new ChessBoard(size, args);
		chessPiece.moveOnBoard(gameBoard);
	}

}
