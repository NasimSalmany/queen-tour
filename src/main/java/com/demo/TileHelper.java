package com.demo;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

import static com.demo.ConstraintHelper.isEmpty;

/**
 * @author Nasim Salmany
 * <p>
 * Functions related to tile in chessboard
 */
public class TileHelper {

    /**
     * Move pattern on basis of the change of
     * x(row) coordinates and y(column) coordinates respectively
     */
    private static final int[] rowMoves = {3, 2, 0, -2, -3, -2, 0, 2, 0, 0};
    private static final int[] colMoves = {0, -2, -3, -2, 0, 2, 3, 2, 0, 0};

    /**
     *  Returns the number of empty tiles adjacent
     *  to (row, col)
     */
    public static int emptyAdjacentTilesCount(ChessBoard chessBoard, int row, int col) {
        int count = 0;
        for (int i = 0; i < rowMoves.length; ++i)
            if (isEmpty(chessBoard, (row + rowMoves[i]), (col + colMoves[i])))
                count++;

        return count;
    }

    /**
     * checks its neighbouring tiles
     * If the piece ends on a tile that is visited before
     * then tour is closed
     */
    public static boolean neighbour(Tile newTile, Tile startTile) {
        for (int i = 0; i < rowMoves.length; ++i)
            if (((newTile.getRow() + rowMoves[i]) == startTile.getRow())
                    && ((newTile.getCol() + colMoves[i]) == startTile.getCol()))
                return true;

        return false;
    }

    /**
     * Picks next point using Warnsdorff's heuristic.
     * Returns false if it is not possible to pick next point
     */
    public static Tile nextMove(ChessBoard chessBoard, Tile tile, int step) {
        int min_deg_idx = -1, c, min_deg = (chessBoard.getRowNumber() + 1), newRow, newCol;

        // Try all N adjacent of (*x, *y) starting
        // from a random adjacent. Find the adjacent
        // with minimum degree.
        int start = ThreadLocalRandom.current().nextInt(1000) % chessBoard.getRowNumber();
        for (int count = 0; count < chessBoard.getRowNumber(); ++count) {
            int i = (start + count) % chessBoard.getRowNumber();
            newRow = tile.getRow() + rowMoves[i];
            newCol = tile.getCol() + colMoves[i];
            if ((isEmpty(chessBoard, newRow, newCol)) &&
                    (c = emptyAdjacentTilesCount(chessBoard, newRow, newCol)) < min_deg) {
                min_deg_idx = i;
                min_deg = c;
            }
        }

        // IF we could not find a next cell
        if (min_deg_idx == -1)
            return null;

        // Store coordinates of next point
        newRow = tile.getRow() + rowMoves[min_deg_idx];
        newCol = tile.getCol() + colMoves[min_deg_idx];

        // Mark next move
        Tile[][] tiles = chessBoard.getTiles();
        tiles[newRow][newCol].setStep(step + 1);

        // Update next point
        tile.setRow(newRow);
        tile.setCol(newCol);

        return tile;
    }

    /**
     * displays the chessboard with all the legal piece's moves
     */
    public static void print(ChessBoard chessBoard) {
        Tile[][] tiles = chessBoard.getTiles();
        DecimalFormat twoDigits = new DecimalFormat("00");
        for (Tile[] pos : tiles) {
            for (int j = 0; j < tiles.length; j++) {
                System.out.print("   " + twoDigits.format(pos[j].getStep()));
            }
            System.out.println();
        }
    }


}
