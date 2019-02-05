package it.sevenbits.lexer.lexemes;

public class CondenserStateTransition {
    private CondenserStateMap stateMap;

    public CondenserStateTransition() {
        stateMap = new CondenserStateMap();
    }

    public CondenserState getDefaultState() {
        return stateMap.getDefaultState();
    }

    public CondenserState getFlushState() {
        return stateMap.getFlushState();
    }

    public CondenserState getNextState(final CondenserState state, final char c) {
        return stateMap.getNextState(state, c);
    }
}
