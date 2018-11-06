package it.sevenbits.main;

import com.google.common.base.Charsets;
import it.sevenbits.formatter.Formatter;
import it.sevenbits.reader.StringReader;
import it.sevenbits.writer.StringWriter;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Main class. Provides main entry-point method.
 */
public final class Main {
    private Main() { }

    private static final Charset STANDARD_CHARSET = Charsets.UTF_8;
    private static final int BYTE_SIZE = 8;

    /**
     * Main entry-point method.
     * @param args - array of command line arguments.
     * @throws IOException if got exceptional situation
     * in one of implementations during reading or writing.
     */
    public static void main(final String[] args) throws IOException {
        StringReader reader = new StringReader(args[0], STANDARD_CHARSET);
        StringWriter writer = new StringWriter(Integer.MAX_VALUE / BYTE_SIZE);
        Formatter formatter = new Formatter();
        formatter.format(reader, writer);
        reader.close();
        writer.close();


        System.out.println(writer.toString(STANDARD_CHARSET.toString()));
    }
}
