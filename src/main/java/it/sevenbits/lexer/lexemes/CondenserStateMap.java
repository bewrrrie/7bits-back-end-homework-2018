package it.sevenbits.lexer.lexemes;

import it.sevenbits.lexer.Pair;

import java.util.HashMap;

public class CondenserStateMap {
    private HashMap<Pair<CondenserState, Integer>, CondenserState> stateMap;
    private CondenserState defaultState;
    private CondenserState flushState;

    public CondenserStateMap() {
        stateMap = new HashMap<>();
        defaultState = new CondenserState("CONDENSE");
        flushState = new CondenserState("FLUSH");

        stateMap.put(new Pair<>(defaultState, (int) '{'), flushState);
        //stateMap.put(new Pair<>(defaultState, (int) '('), flushState);
        stateMap.put(new Pair<>(defaultState, (int) '}'), flushState);
        //stateMap.put(new Pair<>(defaultState, (int) ')'), flushState);
        stateMap.put(new Pair<>(defaultState, (int) ';'), flushState);
    }

    public CondenserState getDefaultState() {
        return defaultState;
    }

    public CondenserState getFlushState() {
        return flushState;
    }

    public CondenserState getNextState(final CondenserState state, final int c) {
        return stateMap.getOrDefault(new Pair<>(state, c), defaultState);
    }
}
