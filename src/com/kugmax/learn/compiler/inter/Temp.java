package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.sybmols.*;

public class Temp extends Expr {
    static int count = 0;
    int number = 0;

    public Temp(Type type) {
        super(Word.temp, type);
        number = ++count;
    }

    public String toString() {
        return "t" + number;
    }
}
