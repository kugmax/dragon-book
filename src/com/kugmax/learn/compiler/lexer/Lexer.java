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
        while (true) {
            peek = (char)System.in.read();
            if (peek == '/') {
                peek = (char)System.in.read();
                if (peek == '/') {
                    skipLine();
                    continue;
                } else if (peek == '*') {
                    skipWhile("*/");
                    continue;
                }
            }

            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }

        if (peek == '<') {
            peek = (char)System.in.read();
            if (peek == '=') {
                return new Operator(Tag.LESS_EQUAL, "<=");
            } else {
                return new Operator(Tag.LESS, "<");
            }
        }

        if (peek == '>') {
            peek = (char)System.in.read();
            if (peek == '=') {
                return new Operator(Tag.GREATER_EQUAL, ">=");
            } else {
                return new Operator(Tag.GREATER, ">");
            }
        }

        if (peek == '=') {
            peek = (char)System.in.read();
            if (peek == '=') {
                return new Operator(Tag.EQUAL, "==");
            } //TODO: what else??, word??
        }

        if (peek == '!') {
            peek = (char)System.in.read();
            if (peek == '=') {
                return new Operator(Tag.NOT_EQUAL, "!=");
            } //TODO: what else??, word??
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
            StringBuilder buffer = new StringBuilder();

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

    private void skipLine() throws IOException {
        for (;; peek = (char)System.in.read()) {
            if (peek == '\n' ) {
                return;
            }
        }
    }

    private void skipWhile(String end) throws IOException {
        StringBuilder builder = new StringBuilder();
        int matchIndex = 0;

        for (;; peek = (char)System.in.read()) {
            if (builder.toString().equals(end)) {
                return;
            }

            if (peek == end.charAt(matchIndex)) {
                builder.append(peek);
                matchIndex++;
                continue;
            }

            if (!builder.isEmpty()) {
                matchIndex = 0;
                builder = new StringBuilder();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Lexer lexer = new Lexer();

        while (true) {
            Token token = lexer.scan();
            System.out.println(lexer.line + ", " + token);
        }
    }
}
