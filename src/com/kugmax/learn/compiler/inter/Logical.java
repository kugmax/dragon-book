package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.sybmols.Type;

public class Logical extends Expr {
    public Expr expr1;
    public Expr expr2;

    public Logical(Token token, Expr e1, Expr e2) {
         super(token, null);
         expr1 = e1;
         expr2 = e2;

         type = check(expr1.type, expr2.type);
         if (type == null) {
              error("type error");
         }
    }

    public Type check(Type t1, Type t2) {
         if (t1 == Type.Bool && t2 == Type.Bool) {
             return Type.Bool;
         }
         return null;
    }

    public Expr gen() {
         int f = newLabel();
         int a = newLabel();

         Temp temp = new Temp(type);
         this.jumping(0, f);

         emit(temp.toString() + " = true");
         emit("goto L" + a);
         emitLabel(f);
         emit(temp.toString() + " = false");
         emitLabel(a);
         
         return temp;
    }

    public String toString() {
      return expr1.toString() + " " + op.toString() + " "+ expr2.toString();
    }
}
