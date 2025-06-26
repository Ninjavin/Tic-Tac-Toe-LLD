package strategy;

import enums.Symbol;
import models.Board;

public class DefaultMoveStrategy implements MoveStrategy {
    @Override
    public boolean isValidMove(Board board, int r, int c) {
        return board.getCell(r, c) == Symbol.EMPTY;
    }
}
