package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class Stmt extends Node {
    public static Stmt Null = Stmt();
    public static Stmt Enclosing = Stmt.Null;

    int after = 0;

    public Stmt() {
    }
    
    pub void gen(int b, int a) {

    }
}
