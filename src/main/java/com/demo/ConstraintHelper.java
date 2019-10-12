package com.demo;

/**
 * @author Nasim Salmany
 */
public class ConstraintHelper {

    /**
     * function restricts the piece to remain within
     * the nxn chessboard
     */
    public static boolean isInBounds(int row, int col, int maxRow, int maxCol) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }

    /**
     * Checks whether a tile is valid and empty or not
     */
    public static boolean isEmpty(ChessBoard chessBoard, int row, int col) {
        Tile[][] tiles = chessBoard.getTiles();
        return (isInBounds(row, col, chessBoard.getRowNumber(), chessBoard.getColumnNumber()))
                && (tiles[row][col].getStep() < 0);
    }
}
