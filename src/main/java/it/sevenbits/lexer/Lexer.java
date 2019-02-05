package it.sevenbits.lexer;

import it.sevenbits.lexer.lexemes.LexemeCondenser;
import it.sevenbits.reader.IReader;

import java.io.IOException;

import static it.sevenbits.lexer.Constants.STANDARD_TAB_SIZE;

/**
 * ILexer implementation that created for lexical analysis
 * of base java code.
 */
public class Lexer implements ILexer {
    private LexemeCondenser condenser;
    private TokenTypesMap tokenTypesMap;

    /**
     * Private default constructor.
     * Prevents creating object with no parameters specified.
     */
    private Lexer() {}

    /**
     * Custom constructor.
     *
     * @param reader - IReader interface implementation
     *                 used for reading lexemes.
     */
    public Lexer(final IReader reader) throws IOException {
        condenser = new LexemeCondenser(reader);
        tokenTypesMap = new TokenTypesMap();
    }

    /**
     * @return next token if available
     * or null if there are no tokens left.
     */
    @Override
    public IToken getNextToken() throws IOException {
        String lexeme = condenser.getLexeme().trim();
        return new Token(tokenTypesMap.getType(lexeme), lexeme);
    }

    /**
     * @return true - if there is available at least one token to read;
     * false - otherwise.
     */
    @Override
    public boolean hasMoreTokens() throws IOException {
        return condenser.hasMoreLexemes();
    }
}
