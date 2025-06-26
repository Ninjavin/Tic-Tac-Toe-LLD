package strategy;

import enums.Symbol;
import models.Board;

public class DefaultWinStrategy implements WinStrategy {

    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        int size = board.getSIZE();
        for (int i=0 ; i<size ; i++) {
            if (checkRow(board, symbol, i) || checkCol(board, symbol, i)) {
                return true;
            }
        }
        return checkDiagonal(board, symbol);
    }

    private boolean checkRow(Board board, Symbol symbol, int row) {
        for (int i=0 ; i<board.getSIZE() ; i++) {
            if (board.getCell(row, i) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(Board board, Symbol symbol, int col) {
        for (int i=0 ; i<board.getSIZE() ; i++) {
            if (board.getCell(i, col) != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(Board board, Symbol symbol) {
        int size = board.getSIZE();
        boolean mainDiagonal = true;
        boolean antiDiagonal = true;
        for (int i=0 ; i< size; i++) {
            if (board.getCell(i, i) != symbol) {
                mainDiagonal = false;
            }
        }
        for (int i=0 ; i< size; i++) {
            if (board.getCell(i, size-1-i) != symbol) {
                antiDiagonal = false;
            }
        }
        return mainDiagonal || antiDiagonal;
    }
}
