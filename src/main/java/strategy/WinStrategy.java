package strategy;

import enums.Symbol;
import models.Board;

public interface WinStrategy {
    boolean checkWin(Board board, Symbol symbol);
}
