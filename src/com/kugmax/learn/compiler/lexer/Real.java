package com.kugmax.learn.compiler.lexer;

public class Real extends Token {
    public final double value;

    public Real(double value) {
        super(Tag.REAL);
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
