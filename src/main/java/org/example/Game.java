package org.example;

import java.util.List;

public class Game {

    boolean isGameOn;

    Board board;
    Player player1;
    Player player2;

    List<Piece> killedPieces;

    void intializeBoard(){
        // INITIALIZE BOARD
    }

    void startGame(){

        isGameOn = true;
        board.setWhiteTurn(true);

        while(isGameOn){
            // enter your moves as cells;
            Cell startCell = new Cell(1,2,false,new Rook("white"));
            Cell endCell = new Cell(3,4,true, new Rook("White"));

            isGameOn = move(startCell, endCell);

            flipTurn();
        }
    }

    private void flipTurn() {

        if(board.isWhiteTurn==true ){
            board.setWhiteTurn(false);
        }
        else{
            board.setWhiteTurn(true);
        }
    }


    boolean move(Cell startCell, Cell endCell){
        board.makeMove(startCell, endCell);

        if(board.isWhiteUnderCheck() && board.getNextWhitePieces().isEmpty()){
            System.out.println("Black won");
            return false;
        }

        if(board.isBlackUnderCheck() && board.getNextBlackPieces().isEmpty()){
            System.out.println("White won");
            return false;
        }

        return true;

        // same for black
    }


}
