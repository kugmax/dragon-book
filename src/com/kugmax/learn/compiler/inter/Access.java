package com.kugmax.learn.compiler.inter;

import com.kugmax.learn.compiler.lexer.Tag;
import com.kugmax.learn.compiler.lexer.Token;
import com.kugmax.learn.compiler.lexer.Word;
import com.kugmax.learn.compiler.sybmols.Type;

public class Access extends Op{
    public Id array;
    public Expr index;
    
    public Access(Id array, Expr index, Type type) {
        super(new Word("[]", Tag.INDEX), type);
        this.array = array;
        this.index = index;
    }

    public Expr gen() {
        return new Access(array, index.reduce(), type);
    }

    public void jumping(int t, int f) {
         emitJumps(reduce().toString(), t, f);
    }

    public String toString() {
        return array.toString() + " [ " + index.toString() + " ]";
    }
}
