package com.kugmax.learn.compiler.lexer;

public class DoubleNumber extends Token {
    private final double value;

    public DoubleNumber(int tag, double value) {
        super(tag);
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleNumber{" +
                "value=" + value +
                ", tag=" + tag +
                '}';
    }
}
