package it.sevenbits.lexer.lexemes;

import it.sevenbits.reader.IReader;

import java.io.IOException;

public class LexemeCondenser {
    private IReader reader;
    private StringBuilder condenser;
    private CondenserStateTransition transition;

    private int currentChar;
    private int nextChar;
    private CondenserState currentState;

    public LexemeCondenser(final IReader reader) throws IOException {
        this.reader = reader;
        condenser = new StringBuilder();
        transition = new CondenserStateTransition();

        currentChar = -1;
        nextChar = -1;
        currentState = transition.getDefaultState();
    }

    public boolean hasMoreLexemes() throws IOException {
        return reader.hasNext();
    }

    public String getLexeme() throws IOException {
        currentChar = reader.read();
        currentState = transition.getNextState(currentState, (char) currentChar);

        while (currentChar != -1 && !currentState.equals(transition.getFlushState())) {
            currentState = transition.getNextState(currentState, (char) currentChar);
            condenser.append((char) currentChar);

            if (currentState.equals(transition.getFlushState())) {
                break;
            }

            currentChar = reader.read();
        }

        String result = condenser.toString();
        condenser.setLength(0);
        return result;
    }
}
