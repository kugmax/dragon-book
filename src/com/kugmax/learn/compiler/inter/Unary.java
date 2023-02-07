package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.sybmols.*;

public class Unary extends Op {
    Expr expr;
    public Unary(Token token, Expr expr) {
        super(token, null);
        type = Type.max(Type.Int, expr.type);
        if (type == null) {
          error("type error");
        }

    }
}
