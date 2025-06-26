package models;

import enums.Symbol;

public class Board {
    private final int SIZE = 3;
    private Symbol[][] grid = new Symbol[SIZE][SIZE];
    public Board() {
        for (int i=0 ; i<SIZE ; i++) {
            for (int j=0 ; j<SIZE ; j++) {
                grid[i][j] = Symbol.EMPTY;
            }
        }
    }
    public void updateBoard(int r, int c, Symbol s) {
        this.grid[r][c] = s;
    }
    public Symbol getCell(int r, int c) {
        return this.grid[r][c];
    }
    public int getSIZE() {
        return SIZE;
    }

    public Symbol[][] getGrid() {
        return grid;
    }
}
