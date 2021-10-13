//package com.rit.hw.bc.updated

public class Knight3D extends ChessPiece3D {
    /**
     * @param gameBoard - board on which pieces are placed
     *
     * The method places knights on the board
     * and blocks the square(s) that can't be occupied.
     */
    @Override
    public void moveOnBoard(ChessBoard3D gameBoard) {
        int count = 0;
        int row[] = { 1, -1, 1, -1, 2, 2, -2, -2 };
        int col[] = { 2, 2, -2, -2, -1, 1, -1, 1 };

        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                for (int k = 0; k < gameBoard.size; k++) {
                    if (!gameBoard.square[i][j][k].hole && !gameBoard.square[i][j][k].blocked) {
                        gameBoard.square[i][j][k].piece = " K ";
                        count += 1;

                        for (int a = 0; a < 8; a++) {
                            int r = i + row[a];
                            int c = j + col[a];
                            int h = k;
                            if (r >= 0 && r < gameBoard.size && c >= 0 && c < gameBoard.size
                                    && !gameBoard.square[r][c][h].hole) {
                                gameBoard.square[r][c][h].block();
                            }
                        }
                        for (int a = 0; a < 8; a++) {
                            int r = i;
                            int c = j + row[a];
                            int h = k + col[a];
                            if (c >= 0 && c < gameBoard.size && h >= 0 && h < gameBoard.size
                                    && !gameBoard.square[r][c][h].hole) {
                                gameBoard.square[r][c][h].block();
                            }
                        }
                        for (int a = 0; a < 8; a++) {
                            int r = i + col[a];
                            int c = j;
                            int h = k + row[a];
                            if (h >= 0 && h < gameBoard.size && r >= 0 && r < gameBoard.size
                                    && !gameBoard.square[r][c][h].hole) {
                                gameBoard.square[r][c][h].block();
                            }
                        }
                    }
                }
            }
        }
        System.out.println(gameBoard);
        System.out.println("Maximum Knights placed: " + count + "\n---------------------------------\n");
    }
}
