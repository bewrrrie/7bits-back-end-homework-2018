package it.sevenbits.formatter;

import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

/**
 * This interface provide pattern for
 * implementation symbolic java code formatter.
 */
public interface IFormatter {
    /**
     * Format java code given by reading and writing streams.
     * @param reader - given reading stream.
     * @param writer - given writing stream.
     * @throws IOException when got exceptional situation
     * while reading or writing character.
     */
    void format(IReader reader, IWriter writer) throws IOException;
}
