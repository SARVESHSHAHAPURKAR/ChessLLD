package org.example;

public class Knight extends Piece{

    Knight(String color) {
        super(color);
    }

    @Override
    boolean isMoveValid(Cell startCell, Cell endCell) {
        // add validation
        return false;
    }
}
