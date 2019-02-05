package it.sevenbits.lexer;

/**
 * IToken implementation that stores
 * name and lexeme as a strings.
 */
public class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     * Private default constructor.
     * Prevents creating object with no parameters specified.
     */
    private Token() {}

    /**
     * Custom constructor.
     *
     * @param name - tokens name.
     * @param lexeme - lexeme that contains in token.
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }


    /**
     * @return token name.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return lexeme containment.
     */
    @Override
    public String getLexeme() {
        return lexeme;
    }

    @Override
    public String toString() {
        return "Token{" +
        "name='" + name + '\'' +
        ", lexeme='" + lexeme + '\'' +
        '}';
    }
}
