package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class Else extends Stmt {
    Expr expr;
    Stmt stmt1;
    Stmt stmt2;

    public Else(Expr expr, Stmt stmt1, Stmt stmt2) {
      this.expr = expr;
      this.stmt1 = stmt1;
      this.stmt2 = stmt2;

      if (expr.type != Type.Bool) {
         expr.error("boolean required in if")
      }
    }

    public void gen(int b, int a) {
        int lablel1 = newLabel();
        int lablel2 = newLabel();
        expr.jumping(0, label2);

        emitLabel(label1);
        stmt1.gen(label1, a);
        emit("goto L" + a);

        emitLabel(label2);
        stmt2.gen(label2, a);
    }
}
