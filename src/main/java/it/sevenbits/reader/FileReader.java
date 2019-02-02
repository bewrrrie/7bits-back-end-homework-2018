package it.sevenbits.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * IReader interface implementation created
 * for reading from files.
 */
public class FileReader implements IReader {
    private BufferedReader reader;

    /**
     * Private default constructor.
     * Prevents creating object with no parameters specified.
     */
    private FileReader() {}

    /**
     * Custom constructor.
     *
     * @param file - specified input file path.
     * @param charset - specified charset used for decoding chars.
     * @throws FileNotFoundException when specified file is missing.
     */
    public FileReader(final String file, final Charset charset) throws FileNotFoundException {
        reader = new BufferedReader(
           new InputStreamReader(new FileInputStream(file), charset)
        );
    }

    /**
     * @return True - if stream has character to read,
     * False - otherwise.
     * @throws IOException when called method from closed stream
     *                     or got other IO error while calling this method.
     */
    @Override
    public boolean hasNext() throws IOException {
        return reader.ready();
    }

    /**
     * Read character and then switch to next one.
     *
     * @return received character code or -1 if
     * left no characters to read in stream.
     * @throws IOException when left no character to read
     *                     or got other IO error while reading next symbol.
     */
    @Override
    public int read() throws IOException {
        return reader.read();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
