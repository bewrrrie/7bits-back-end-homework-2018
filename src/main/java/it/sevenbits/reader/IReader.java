package it.sevenbits.reader;

import java.io.Closeable;
import java.io.IOException;

/**
 * IReader interface. Provides implementation pattern
 * for symbolic reading streams.
 */
public interface IReader extends Closeable {
    /**
     * @return True - if stream has character to read,
     * False - otherwise.
     * @throws IOException when called method from closed stream
     * or got other IO error while calling this method.
     */
    boolean hasNext() throws IOException;

    /**
     * Read character and then switch to next one.
     * @return received character code or -1 if
     * left no characters to read in stream.
     * @throws IOException when left no character to read
     * or got other IO error while reading next symbol.
     */
    int read() throws IOException;
}
