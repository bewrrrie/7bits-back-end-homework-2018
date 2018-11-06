package it.sevenbits.writer;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import static it.sevenbits.writer.Constants.STANDARD_ENCODING_NAME;


/**
 * IWriter implementation.
 * Provides symbolic writing stream for strings.
 */
public class StringWriter implements IWriter {
    private BufferedWriter writer;
    private ByteArrayOutputStream stream;

    /**
     * Private default constructor.
     * Forbids instances creation with no specified parameters.
     */
    private StringWriter() { }

    /**
     * Create StringWriter instance with specified initial
     * size of output string.
     * @param initialSize - initial size of output string.
     */
    public StringWriter(final int initialSize) {
        stream = new ByteArrayOutputStream(initialSize);
        writer = new BufferedWriter(new OutputStreamWriter(stream));
    }

    @Override
    public void write(final int charCode) throws IOException {
        writer.write(charCode);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }

    /**
     * Convert stream containment to string.
     * Use encoding with given name.
     * @param charsetName - given encoding name.
     * @return stream containment of type String.
     * @throws UnsupportedEncodingException when given of
     * not supported encoding name.
     */
    public String toString(final String charsetName) throws UnsupportedEncodingException {
        return stream.toString(charsetName);
    }

    /**
     * Convert stream containment to string.
     * Use standard encoding.
     * @return stream containment of type String.
     */
    @Override
    public String toString() {
        try {
            return stream.toString(STANDARD_ENCODING_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
