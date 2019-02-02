package it.sevenbits.lexer;

import java.io.IOException;

/**
 * Interface that provides set of basic lexical analyzer methods.
 */
public interface ILexer {
    /**
     * @return next token if available
     * or null if there are no tokens left.
     * @throws IOException when got an error while reading lexeme.
     */
    IToken getNextToken() throws IOException;

    /**
     * @return true - if there is available at least one token to read;
     * false - otherwise.
     * @throws IOException when got an error while reading lexeme.
     */
    boolean hasMoreTokens() throws IOException;
}
