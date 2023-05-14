package org.example;

public class Bishop extends Piece{


    Bishop(String color) {
        super(color);
    }

    @Override
    boolean isMoveValid(Cell startCell, Cell endCell) {
        // add validation
        return false;
    }
}
