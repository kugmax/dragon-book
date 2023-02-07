package com.kugmax.learn.compiler.sybmols;

import com.kugmax.learn.compiler.lexer.Tag;
import com.kugmax.learn.compiler.lexer.Word;

public class Type extends Word {
    public static final Type Int = new Type("int", Tag.BASIC, 4);
    public static final Type Float = new Type("float", Tag.BASIC, 8);
    public static final Type Char = new Type("char", Tag.BASIC, 1);
    public static final Type Bool = new Type("bool", Tag.BASIC, 1);

    public int width = 0;

    public Type(String lexeme, int tag, int width) {
        super(lexeme, tag);
        this.width = width;
    }

    public static boolean numeric(Type type){
        return type == Type.Char || type == Type.Int || type == Type.Float;
    }

    public static Type max(Type type1, Type type2){
        if (!numeric(type1) && !numeric(type2)) {
            return null;
        }

        if (type1 == Type.Float || type2 == Type.Float) {
            return Type.Float;
        }

        if (type1 == Type.Int || type2 == Type.Int) {
            return Type.Int;
        }

        return Type.Char;
    }
}
