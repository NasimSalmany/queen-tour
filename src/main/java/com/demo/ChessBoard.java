package com.demo;

/**
 * @author Nasim Salmany
 *
 * represents a chessboard with  rowNumber x columnNumber tiles
 */
public class ChessBoard {
    private int rowNumber;
    private int columnNumber;
    private Tile[][] tiles;

    public ChessBoard(int rowNumber, int columnNumber) {
        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;
        this.tiles = this.initBoard();
    }

    private Tile[][] initBoard() {
        this.tiles = new Tile[rowNumber][columnNumber];
        for (int i = 0; i < rowNumber; ++i) {
            for (int j = 0; j < columnNumber; ++j) {
                Tile tile = new Tile(i, j);
                this.tiles[i][j] = tile;
            }
        }
        return tiles;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }
}
