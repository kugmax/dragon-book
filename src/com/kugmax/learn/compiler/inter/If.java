package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class If  extends Stmt {
    Expr expr;
    Stmt stmt;
    public If(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;

        if (expr.type != Type.Bool) {
            expr.error("boolean required in if");
        }
    }

    public void gen(int a, int b) {
        int label = newLabel();
        expr.jumping(0, a);
        emitLabel(label);
        stmt.gen(label, a);
    }
}
