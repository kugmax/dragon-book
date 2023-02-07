package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Lexer;

public class Node {
    public static int labels = 0;
    int lexline = 0;
    public Node() {
        lexline = Lexer.line;
    }

    void error(String s) {
        throw new Error("near line " + lexline + ": " + s);
    }

    public int newLabel() {
        return ++labels;
    }

    public void emitLabel(int i) {
        System.out.println("L" + i + ":");
    }

    public void emit(String s) {
        System.out.println("\t" + s + ":");
    }
}
