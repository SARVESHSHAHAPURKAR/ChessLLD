package org.example;

public abstract class Piece {

    String color;

    Piece(String color){
        this.color = color;
    }

    abstract boolean isMoveValid(Cell startCell, Cell endCell);

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
