package it.sevenbits.formatter.commands;

import it.sevenbits.lexer.IToken;
import it.sevenbits.lexer.Pair;

public interface IFormatterCommand {
    int TAB_SIZE = 4;

    Pair<String, Integer> execute(IToken token, int tabLevel);
}
