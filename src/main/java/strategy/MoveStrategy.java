package strategy;

import models.Board;

public interface MoveStrategy {
    boolean isValidMove(Board board, int r, int c);
}
