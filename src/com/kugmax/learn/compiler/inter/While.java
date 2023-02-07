package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class While extends Stmt {
    Expr expr;
    Stmt stmt;
    public While() {
        this.expr = null;
        this.stmt = null;
    }

    public void init(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;

        if (expr.type != Type.Bool) {
            expr.error("boolean required in while");
        }
    }

    public void gen(int b, int a) {
        after = a;
        expr.jumping(0, a);
        int label = newLabel();
        emitLabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
