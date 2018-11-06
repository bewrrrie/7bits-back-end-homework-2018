package it.sevenbits.writer;

import java.io.Closeable;
import java.io.IOException;

/**
 * IWriter interface. Provides implementation pattern
 * for symbolic writing streams.
 */
public interface IWriter extends Closeable {
    /**
     * Write character with given code in stream.
     * @param charCode - given char code.
     * @throws IOException when error while writing
     * if writing stream is already closed or
     * initial output size is exceeded.
     */
    void write(int charCode) throws IOException;
}
