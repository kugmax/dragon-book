package com.kugmax.learn.compiler.lexer;

public class Num extends Token {
    public final int value;

    public Num(int value) {
        super(Tag.NUM);
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
