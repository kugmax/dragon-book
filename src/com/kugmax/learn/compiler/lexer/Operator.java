package com.kugmax.learn.compiler.lexer;

public class Operator extends Token {
    protected final String symbol;

    public Operator(int tag, String symbol) {
        super(tag);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "symbol='" + symbol + '\'' +
                ", tag=" + tag +
                '}';
    }
}
