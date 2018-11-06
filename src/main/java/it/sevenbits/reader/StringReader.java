package it.sevenbits.reader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * IReader implementation.
 * Provides symbolic reading stream for strings.
 */
public class StringReader implements IReader {
    private BufferedReader reader;

    /**
     * Private default constructor.
     * Forbids instances creation with no specified parameters.
     */
    private StringReader() { }

    /**
     * Create StringReader instance with specified string
     * and character encoding.
     * @param s - input string.
     * @param charset - used charset or character encoding title.
     */
    public StringReader(final String s, final Charset charset) {
        reader = new BufferedReader(
            new InputStreamReader(new ByteArrayInputStream(s.getBytes()), charset)
        );
    }

    @Override
    public boolean hasNext() throws IOException {
        return reader.ready();
    }

    @Override
    public int read() throws IOException {
        return reader.read();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
