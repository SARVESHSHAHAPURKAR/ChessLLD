package org.example;

public class Pawn extends Piece{

    Pawn(String color) {
        super(color);
    }

    @Override
    boolean isMoveValid(Cell startCell, Cell endCell) {
        // add validation
        return false;
    }
}
