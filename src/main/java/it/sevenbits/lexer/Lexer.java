package it.sevenbits.lexer;

import it.sevenbits.reader.IReader;

import java.io.IOException;

import static it.sevenbits.lexer.Constants.BYTE_SIZE;
import static it.sevenbits.lexer.Constants.STANDARD_TAB_SIZE;

/**
 * ILexer implementation that created for lexical analysis
 * of base java code.
 */
public class Lexer implements ILexer {
    private int tabSize;
    private IReader reader;
    private int current;
    private int previous;
    private int tabLevel;
    private StringBuilder sb = new StringBuilder();

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
    public Lexer(final IReader reader) {
        this.reader = reader;
        this.tabSize = STANDARD_TAB_SIZE;
        this.current = -1;
        this.previous = -1;
        this.tabLevel = 0;
    }

    /**
     * Custom constructor.
     *
     * @param reader - IReader interface implementation
     *                 used for reading lexemes.
     * @param tabSize - quantity of spaces in one tab.
     */
    public Lexer(final IReader reader, final int tabSize) {
        if (tabSize < 0) {
            throw new IllegalArgumentException("Tab size must be non-negative integer!");
        } else if (tabSize > Integer.MAX_VALUE / BYTE_SIZE) {
            throw new IllegalArgumentException("Tab size is too big!");
        }

        this.reader = reader;
        this.tabSize = tabSize;
        this.current = -1;
        this.previous = -1;
        this.tabLevel = 0;
    }

    private String tab() {
        int spacesCount = tabSize * tabLevel;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spacesCount; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    /**
     * @return next non-empty character.
     * @throws IOException when got exceptional situation
     * while reading next character.
     */
    private int nextNonEmptyChar() throws IOException {
        int current = reader.read();

        while (isEmptyChar(current)) {
            current = reader.read();
        }

        return current;
    }

    /**
     * @param c - given character.
     * @return True if given character is empty character
     * or False - otherwise.
     */
    private boolean isEmptyChar(final int c) {
        return c == ' ' || c == '\n' || c == '\t';
    }

    /**
     * @return next token if available
     * or null if there are no tokens left.
     */
    @Override
    public IToken getNextToken() throws IOException {

        if (reader.hasNext()) {
            previous = current;
            current = reader.read();

            switch (current) {
                case '{':
                    tabLevel++;
                    sb.setLength(0);

                    if (previous != ' ' && previous != -1) {
                        sb.append(' ');
                    }

                    sb.append((char) current);
                    sb.append('\n');
                    sb.append(tab());
                    current = ' ';

                    return new Token("OPEN_BLOCK", sb.toString());

                case '}':
                    tabLevel--;

                    sb.setLength(0);
                    if (previous != '\n') {
                        sb.append('\n');
                    }
                    sb.append(tab());
                    sb.append((char) current);

                    return new Token("CLOSE_BLOCK", sb.toString());

                case ';':
                    sb.setLength(0);
                    sb.append((char) current);
                    current = '\n';
                    sb.append((char) current);

                    return new Token("SEMICOLON", sb.toString());

                case ' ':
                    if (!isEmptyChar(previous) && previous != '}') {
                        return new Token("SPACE", Character.toString((char) current));
                    } else if (previous == '\n') {
                        current = previous;
                    }

                    break;

                case '\n':
                    current = previous;
                    break;

                default:
                    sb.setLength(0);
                    if (previous == '\n') {
                        sb.append(tab());

                        while (isEmptyChar(current)) {
                            current = nextNonEmptyChar();
                        }
                    }
                    sb.append((char) current);

                    return new Token("LITERAL", sb.toString());
            }
        }

        return null;
    }

    /**
     * @return true - if there is available at least one token to read;
     * false - otherwise.
     */
    @Override
    public boolean hasMoreTokens() throws IOException {
        return reader.hasNext();
    }
}
