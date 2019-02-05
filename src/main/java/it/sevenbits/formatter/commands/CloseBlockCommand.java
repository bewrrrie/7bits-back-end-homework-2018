package it.sevenbits.formatter.commands;

import it.sevenbits.lexer.IToken;
import it.sevenbits.lexer.Pair;

public class CloseBlockCommand implements IFormatterCommand {

    @Override
    public Pair<String, Integer> execute(final IToken token, final int tabLevel) {
        int i = token.getLexeme().indexOf("}");
        StringBuilder tab = new StringBuilder();

        for (int j = 0; j < (tabLevel - 1) * TAB_SIZE; j++) {
            tab.append(' ');
        }

        String result = tab + token.getLexeme().substring(0, i).trim() + "\n" + tab + "}";
        return new Pair<>(result, tabLevel - 1);
    }
}
