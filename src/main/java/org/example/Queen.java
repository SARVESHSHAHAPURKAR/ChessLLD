package org.example;

public class Queen extends Piece{


    Queen(String color) {
        super(color);
    }

    @Override
    boolean isMoveValid(Cell startCell, Cell endCell) {
        // add validation
        return false;
    }
}
