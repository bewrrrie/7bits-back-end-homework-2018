package it.sevenbits.formatter;

import it.sevenbits.formatter.commands.FormatterCommandsMap;
import it.sevenbits.lexer.ILexer;
import it.sevenbits.lexer.IToken;
import it.sevenbits.lexer.Pair;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * Java code formatter implementation.
 * IFormatter interface implementation.
 */
public class Formatter implements IFormatter {
    private int tabLevel;
    private FormatterCommandsMap commandsMap;

    public Formatter() {
        tabLevel = 0;
        commandsMap = new FormatterCommandsMap();
    }

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
            Pair<String, Integer> result = commandsMap.get(token.getName()).execute(token, tabLevel);
            tabLevel = result.getRight();

            System.out.println("LEXEME: " + result.getLeft() + " ,,, TYPE: " + token.getName());

            for (char c : result.getLeft().toCharArray()) {
                writer.write(c);
            }
        }

        writer.write('\n');
    }
}
