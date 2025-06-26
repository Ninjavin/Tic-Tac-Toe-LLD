package models;

import enums.Symbol;
import utils.IdGenerator;

public class Player {
    private Long id;
    private String name;
    private Symbol symbol;
    public Player(String name, Symbol symbol) {
        this.id = IdGenerator.getRandomId();
        this.name = name;
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}
