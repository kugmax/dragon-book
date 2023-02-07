package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class Do extends Stmt {
    Expr expr;
    Stmt stmt;
    public Do() {
        this.expr = null;
        this.stmt = null;
    }

    public void init(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;

        if (expr.type != Type.Bool) {
            expr.error("boolean required in do");
        }
    }

    public void gen(int b, int a) {
        after = a;
        int label = newLabel();
        stmt.gen(b, label);
        emitLabel(label);
        empr.jumping(b, 0);
    }
}
