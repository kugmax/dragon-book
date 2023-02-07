package com.kugmax.learn.compiler;

import java.io.*;
import com.kugmax.learn.compiler.lexer.*;
import com.kugmax.learn.compiler.parser.r*;

public class Main {
  public static void main(String... args) throws IOException {
      Lexer lex = new Lexer();
      Parser parser = new Parser(lex)
      parse.program();

      System.out.write('\n');
  }
}
