package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.sybmols.*;

public class Arith extends Op {
     public Expr expr1;
     public Expr expr2;

     public Arith(Token token, Expr e1, Expr e2){
         super(token, null);
         this.expr1 = e1;
         this.expr2 = e2;

         type = Type.max(expr1.type, expr2.type);
         if (type == null) {
             error("type error");
         }
     }

     public Expr gen() {
       return new Arith(op, expr1.reduce(), expr2.reduce());
     }

     public String toString() {
       return expr1.toString() + " " + op.toString() + " " + expr2.toString();
     }

}
