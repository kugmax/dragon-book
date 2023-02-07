package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.symbols.*;

public class Op extends Expr {
    public Op(Token token, Type type) {
        super(token, type);
    }

    public Expr reduce() {
        Expr x = get();

        Tmp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
