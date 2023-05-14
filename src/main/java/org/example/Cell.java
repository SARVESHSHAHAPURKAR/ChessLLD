package org.example;

public class Cell {

    int row;
    int col;
    boolean isEmpty;
    Piece piece;

    public Cell(int row, int col, boolean isEmpty, Piece piece) {
        this.row = row;
        this.col = col;
        this.isEmpty = isEmpty;
        this.piece = piece;
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

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
