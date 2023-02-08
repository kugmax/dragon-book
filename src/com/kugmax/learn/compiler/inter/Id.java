package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Word;
import com.kugmax.learn.compiler.sybmols.Type;

public class Id extends Expr {
    public int offset;
    
    public Id(Word id, Type p, int b) {
         super(id, p);
         offset = b;
    }
}
