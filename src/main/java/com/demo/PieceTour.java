package com.demo;

import static com.demo.TileHelper.neighbour;
import static com.demo.TileHelper.print;


/**
 * @author Nasim Salmany
 * <p>
 * Java program to Perform piece's tour using Warnsdorff's algorithm
 */
public class PieceTour {
    // Dimensions of chess board
    private static int COL_NUM = 10;
    private static int ROW_NUM = 10;

    /*
     Generates the legal moves using warnsdorff's
    heuristics. Returns false if not possible
     */
    public static boolean performPieceTour(int startRow, int startCol) {
        int currStep = 1;
        ChessBoard chessBoard = new ChessBoard(ROW_NUM, COL_NUM);
        Tile[][] tiles = chessBoard.getTiles();

        // Mark first move.
        if (!ConstraintHelper.isInBounds(startRow, startCol
                , chessBoard.getRowNumber(), chessBoard.getColumnNumber())) {
            return false;
        }

        Tile startTile = tiles[startRow][startCol];
        startTile.setStep(currStep);

        // Keep picking next points using
        // Warnsdorff's heuristic
        Tile newTile = null;
        for (int i = 0; i < ROW_NUM * COL_NUM - 1; ++i) {
            newTile = TileHelper.nextMove(chessBoard, startTile, currStep++);
            if (newTile == null)
                return false;
        }

        // Check if tour is closed (Can end
        // at starting point)
        boolean neighbour = neighbour(newTile, startTile);
        if (!neighbour)
            return false;

        print(chessBoard);
        return true;
    }
}
