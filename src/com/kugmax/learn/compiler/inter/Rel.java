package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Array;
import com.kugmax.learn.compiler.sybmols.Type;

public class Rel extends Logical {
    public Rel(Token token, Expr left, Expr right) {
        super(token, left, right);
    }

    public Type check(Type t1, Type t2) {
        if (t1 instanceof Array || t2 instanceof Array ) {
            return null;
        } else if (t1 == t2) {
            return Type.Bool;
        } else {
            return null;
        }
    }

    public void jumping(int t, int f) {
        Expr a = expr1.reduce();
        Expr b = expr2.reduce();

        String test = a.toString() + " " + op.toString() + " " + b.toString();
        emitJumps(test, t, f);
    }
}
