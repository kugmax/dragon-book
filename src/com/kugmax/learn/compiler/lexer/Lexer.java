package com.kugmax.learn.compiler.lexer;
import java.io.*;
import java.util.*;

public class Lexer {
    private int line = 1;
    private char peek = ' ';
    private Map<String, Word> words = new HashMap<>();

    public Lexer() {
        reserve(new Word(Tag.TRUE, "true"));
        reserve(new Word(Tag.FALSE, "false"));
    }

    public Token scan() throws IOException {
        for (;; peek = (char)System.in.read()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }

        if (Character.isDigit(peek)) {
            int value = 0;
            do {
                value = 10 * value + Character.digit(peek, 10);
                peek = (char)System.in.read();
            } while (Character.isDigit(peek));
            return new Num(value);
        }

        if (Character.isLetter(peek)) {
            StringBuffer buffer = new StringBuffer();

            do {
                buffer.append(peek);
                peek = (char)System.in.read();
            } while (Character.isLetterOrDigit(peek));

            String s = buffer.toString();
            Word word = words.get(buffer.toString());
            if (word != null) {
                return word;
            }

            word = new Word(Tag.ID, s);
            words.put(s, word);
            return word;
        }

        Token token = new Token(peek);
        peek = ' ';
        return token;
    }

    public void reserve(Word word) {
        words.put(word.getLexeme(), word);
    }

    public int getLine() {
        return line;
    }

    public static void main(String[] args) throws Exception {
        Lexer lexer = new Lexer();
        Token token = lexer.scan();
        System.out.println( token );
    }
}
