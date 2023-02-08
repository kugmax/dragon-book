package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.sybmols.Type;

public class Op extends Expr {
    public Op(Token token, Type type) {
        super(token, type);
    }

    public Expr reduce() {
        Expr x = gen();

        Temp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
