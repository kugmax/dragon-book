package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.sybmols.Array;
import com.kugmax.learn.compiler.sybmols.Type;

public class SetElem extends Stmt {
    public Expr index;
    public Expr expr;
    public Id array;

    public SetElem(Access x, Expr y) {
        array = x.array;
        index = x.index;
        expr = y;
        if (check(x.type, expr.type) == null) {
            error("type error");
        }
    }

    public Type check(Type t1, Type t2) {
         if (t1 instanceof Array || t2 instanceof Array) {
            return null;
         } else if (t1 == t2) {
            return t2;
         } else {
           return null;
         }
    }

    public void gen(int b, int a) {
        String s1 = index.reduce().toString();
        String s2 = expr.reduce().toString();

        emit(array.toString() + " [" + s1 + " ] = " + s2);
    }
}
