package it.sevenbits.lexer;

/**
 * Token interface for lexical analyzers token implementation.
 */
public interface IToken {
    /**
     * @return token name.
     */
    String getName();

    /**
     * @return lexeme containment.
     */
    String getLexeme();
}
