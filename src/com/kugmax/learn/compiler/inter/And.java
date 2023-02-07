package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class And extends Logical {
    public And(Token token, Expr left, Expr right) {
        super(token, left, right);
    }

    public void jumping(int t, int f) {
        int lablel = f != 0 ? f : newLabel();
        expr1.jumping(0, label);
        expr2.jumping(t, f);

        if (f == 0) {
            emitLablel(label);
        }
    }
}
