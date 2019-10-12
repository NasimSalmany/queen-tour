package com.demo;

/**
 * @author Nasim Salmany
 * represent chessboard tile
 */
public class Tile {
    private int row; // x
    private int col; // y
    private int step;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
        this.step = -1;    // Filling up the chessboard tiles with -1
    }

    @Override
    public String toString() {
        return "(" + this.getRow() + "," + this.getCol() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Tile tile = (Tile) obj;
        return row == tile.row &&
                col == tile.col &&
                step == tile.step;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
