package org.example;

public class King extends Piece{

    King(String color) {
        super(color);
    }

    @Override
    boolean isMoveValid(Cell startCell, Cell endCell) {
        // add validation
        // also check if bew position is under check by anyone
        return false;
    }


}
