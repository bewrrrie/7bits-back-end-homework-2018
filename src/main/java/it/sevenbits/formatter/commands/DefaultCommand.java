package it.sevenbits.formatter.commands;

import it.sevenbits.lexer.IToken;
import it.sevenbits.lexer.Pair;

public class DefaultCommand implements IFormatterCommand {
    @Override
    public Pair<String, Integer> execute(final IToken token, final int tabLevel) {
        StringBuilder tab = new StringBuilder();

        for (int i = 0; i < tabLevel * TAB_SIZE; i++) {
            tab.append(' ');
        }

        return new Pair<>(tab + token.getLexeme().trim(), tabLevel);
    }
}
