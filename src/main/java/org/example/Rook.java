package org.example;

public class Rook extends Piece{


    Rook(String color) {
        super(color);
    }

    @Override
    boolean isMoveValid(Cell startCell, Cell endCell) {

        // add validation
        return false;
    }
}
