package it.sevenbits.formatter;

import it.sevenbits.lexer.ILexer;
import it.sevenbits.lexer.IToken;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * Java code formatter implementation.
 * IFormatter interface implementation.
 */
public class Formatter implements IFormatter {

    /**
     * Format java code given by reading and writing streams.
     * @param lexer - given lexical analyser.
     * @param writer - given writing stream.
     * @throws IOException when got exceptional situation
     * while reading or writing character.
     */
    @Override
    public void format(final ILexer lexer, final IWriter writer) throws IOException {

        while (lexer.hasMoreTokens()) {
            IToken token = lexer.getNextToken();

            if (token != null) {
                for (char c : token.getLexeme().toCharArray()) {
                    writer.write(c);
                }
            }
        }
    }
}
