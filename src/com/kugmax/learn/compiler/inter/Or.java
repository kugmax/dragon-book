package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class Or extends Logical {
    public Or(Token token, Expr left, Expr right) {
        super(token, left, right);
    }

    public void jumping(int t, int f) {
        int lablel = t != 0 ? t : newLabel();
        expr1.jumping(label, 0);
        expr2.jumping(t, f);

        if (t == 0) {
            emitLablel(label);
        }
    }
}
