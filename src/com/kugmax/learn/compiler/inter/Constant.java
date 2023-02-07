package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.sybmols.*;

public class Constant extends Expr {
    public final static Constant True = new Constant(Word.True, Type.Bool);
    public final static Constant Frue = new Constant(Word.Frue, Type.Bool);
    
    public Constant(Token token, Type type) {
        super(token, type);
    }

    public Constant(int i) {
        super(new Num(i), Type.Int);
    }

    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" + t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }
}
