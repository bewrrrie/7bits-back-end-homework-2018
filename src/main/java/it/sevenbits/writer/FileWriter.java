package it.sevenbits.writer;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * IWriter interface implementation
 * created for writing to files.
 */
public class FileWriter implements IWriter {
    private BufferedWriter writer;

    /**
     * Private default constructor.
     * Prevents creating object with no parameter specified.
     */
    private FileWriter() {}

    /**
     * Custom constructor.
     *
     * @param file - specified path of file for writing.
     * @throws IOException when specified file is missing.
     */
    public FileWriter(final String file) throws IOException {
        this.writer = new BufferedWriter(
            new OutputStreamWriter(new FileOutputStream(file))
        );
    }


    /**
     * Write character with given code in stream.
     *
     * @param charCode - given char code.
     * @throws IOException when error while writing
     *                     if writing stream is already closed or
     *                     initial output size is exceeded.
     */
    @Override
    public void write(final int charCode) throws IOException {
        writer.write(charCode);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
