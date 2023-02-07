package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class Break extends Stmt {
    Stmt stmt;
    public Break() {
        if (Stmt.Enclosing == null) {
            error("unclosed break");
        }
        stmt = Stmt.Enclosing;
    }

    public void gen(int b, int a) {
      emit("goto L" + stmt.after);
    }
}
