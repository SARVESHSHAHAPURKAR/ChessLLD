package org.example;

import java.util.List;

public class Board {

    Cell[][] cells;

    Cell whiteKing;
    Cell blackKing;

    boolean isWhiteUnderCheck;
    Cell checkToWhiteGivenBy;

    boolean isBlackUnderCheck;
    Cell checkToBlackGivenBy;

    List<Cell> whitePieces;
    List<Cell> blackPieces;

    List<Cell> nextWhitePieces;
    List<Cell> nextBlackPieces;

    boolean isWhiteTurn;

    public void setWhiteTurn(boolean whiteTurn) {
        isWhiteTurn = whiteTurn;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getWhiteKing() {
        return whiteKing;
    }

    public void setWhiteKing(Cell whiteKing) {
        this.whiteKing = whiteKing;
    }

    public Cell getBlackKing() {
        return blackKing;
    }

    public void setBlackKing(Cell blackKing) {
        this.blackKing = blackKing;
    }

    public boolean isWhiteUnderCheck() {
        return isWhiteUnderCheck;
    }

    public void setWhiteUnderCheck(boolean whiteUnderCheck) {
        isWhiteUnderCheck = whiteUnderCheck;
    }

    public Cell getCheckToWhiteGivenBy() {
        return checkToWhiteGivenBy;
    }

    public void setCheckToWhiteGivenBy(Cell checkToWhiteGivenBy) {
        this.checkToWhiteGivenBy = checkToWhiteGivenBy;
    }

    public boolean isBlackUnderCheck() {
        return isBlackUnderCheck;
    }

    public void setBlackUnderCheck(boolean blackUnderCheck) {
        isBlackUnderCheck = blackUnderCheck;
    }

    public Cell getCheckToBlackGivenBy() {
        return checkToBlackGivenBy;
    }

    public void setCheckToBlackGivenBy(Cell checkToBlackGivenBy) {
        this.checkToBlackGivenBy = checkToBlackGivenBy;
    }

    public List<Cell> getWhitePieces() {
        return whitePieces;
    }

    public void setWhitePieces(List<Cell> whitePieces) {
        this.whitePieces = whitePieces;
    }

    public List<Cell> getBlackPieces() {
        return blackPieces;
    }

    public void setBlackPieces(List<Cell> blackPieces) {
        this.blackPieces = blackPieces;
    }

    public List<Cell> getNextWhitePieces() {
        return nextWhitePieces;
    }

    public void setNextWhitePieces(List<Cell> nextWhitePieces) {
        this.nextWhitePieces = nextWhitePieces;
    }

    public List<Cell> getNextBlackPieces() {
        return nextBlackPieces;
    }

    public void setNextBlackPieces(List<Cell> nextBlackPieces) {
        this.nextBlackPieces = nextBlackPieces;
    }

    boolean isMoveValid(Cell startCell, Cell endCell){

        if(!startCell.getPiece().isMoveValid(startCell,endCell)){
            return false;
        }

        // check for checks
        if(isBlackUnderCheck && startCell.getPiece().getColor().equalsIgnoreCase("Black")){

            // attack the piece who is giving check
            if(endCell==checkToBlackGivenBy){
                return true;
            }

            // bring someone in between or make king run away
            else{
                Piece tempPiece = startCell.getPiece();
                if(tempPiece instanceof King){
                    blackKing = endCell;
                }
                startCell.setPiece(null);
                startCell.setEmpty(true);
                endCell.setPiece(tempPiece);
                endCell.setEmpty(false);

                if(checkToBlackGivenBy.getPiece().isMoveValid(checkToBlackGivenBy, blackKing)){
                    endCell.setPiece(null);
                    endCell.setEmpty(true);
                    startCell.setPiece(tempPiece);
                    startCell.setEmpty(false);
                    return false;
                }



            }
        }

        // do same for white under check

        return true;


    }

    void makeMove(Cell startCell, Cell endCell){

        if(!isMoveValid(startCell,endCell)){
            return;
        }

        // MOVES IS VALIDATED THAT MEANS CHECK IS RESOLVED. SO REMOVE IT

        if(startCell.getPiece().getColor().equalsIgnoreCase("White")){
            isWhiteUnderCheck=false;
            checkToWhiteGivenBy=null;
        }
        if(startCell.getPiece().getColor().equalsIgnoreCase("Black")){
            isBlackUnderCheck=false;
            checkToBlackGivenBy=null;
        }

        // UPDATE KING POS

        if(startCell.getPiece() instanceof King){
            if(startCell.getPiece().getColor().equalsIgnoreCase("White")){
                whiteKing = endCell;
            }
            else{
                blackKing = endCell;
            }
        }

        //UPDATE CELL POSITIONS

        startCell.setEmpty(true);
        endCell.setEmpty(false);
        endCell.setPiece(startCell.getPiece());
        startCell.setPiece(null);

        // CHECK FOR CHECKS

        if(endCell.getPiece().getColor().equalsIgnoreCase("White")){
            if(endCell.getPiece().isMoveValid(endCell,blackKing)){
                isBlackUnderCheck=true;
                checkToBlackGivenBy=endCell;
            }
        }
        else{
            if(endCell.getPiece().isMoveValid(endCell,whiteKing)){
                isWhiteUnderCheck=true;
                checkToWhiteGivenBy=endCell;
            }

        }

        // UPDATE THE FOUR WHITE AND BLACK LISTS AFTER EVRY MOVE

    }
}
