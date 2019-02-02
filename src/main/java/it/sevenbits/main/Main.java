package it.sevenbits.main;

import com.google.common.base.Charsets;
import it.sevenbits.formatter.Formatter;
import it.sevenbits.lexer.Lexer;
import it.sevenbits.reader.FileReader;
import it.sevenbits.writer.FileWriter;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Main class. Provides main entry-point method.
 */
public final class Main {
    private Main() {}

    private static final Charset STANDARD_CHARSET = Charsets.UTF_8;

    /**
     * Main entry-point method.
     * @param args - array of command line arguments.
     * @throws IOException if got exceptional situation
     * in one of implementations during reading or writing.
     */
    public static void main(final String[] args) throws IOException {
        String inputPath = args[0];
        String outputPath = args[1];

        try (
            FileReader reader = new FileReader(inputPath, STANDARD_CHARSET);
            FileWriter writer = new FileWriter(outputPath)
        ) {
            Lexer lexer = new Lexer(reader);
            Formatter formatter = new Formatter();
            formatter.format(lexer, writer);
        }
    }
}
