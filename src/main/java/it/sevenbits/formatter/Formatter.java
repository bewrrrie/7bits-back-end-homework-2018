package it.sevenbits.formatter;

import it.sevenbits.reader.IReader;
import it.sevenbits.writer.IWriter;

import java.io.IOException;

import static it.sevenbits.formatter.Constants.STANDARD_TAB_SIZE;

/**
 * Java code formatter implementation.
 * IFormatter interface implementation.
 */
public class Formatter implements IFormatter {
    private static final int BYTE_SIZE = 8;
    private int tabSize;

    /**
     * Default constructor.
     */
    public Formatter() {
        this.tabSize = STANDARD_TAB_SIZE;
    }

    /**
     * Custom constructor.
     * @param tabSize - specified tab length.
     * @throws IllegalArgumentException when git
     */
    public Formatter(final int tabSize) throws IllegalArgumentException {
        if (tabSize < 0) {
            throw new IllegalArgumentException("Tab size must be non-negative integer!");
        } else if (tabSize > Integer.MAX_VALUE / BYTE_SIZE) {
            throw new IllegalArgumentException("Tab size too big!");
        }

        this.tabSize = tabSize;
    }

    private void tab(final IWriter writer, final int tabLevel) throws IOException {
        int spacesCount = tabSize * tabLevel;

        for (int i = 0; i < spacesCount; i++) {
            writer.write(' ');
        }
    }

    /**
     * @param reader - given reading stream.
     * @return next non-empty character.
     * @throws IOException when got exceptional situation
     * while reading next character.
     */
    private int nextNonEmptyChar(final IReader reader) throws IOException {
        int current = reader.read();

        while (isEmptyChar(current)) {
            current = reader.read();
        }

        return current;
    }

    /**
     * @param c - given character.
     * @return True if given character is empty character
     * or False - otherwise.
     */
    private boolean isEmptyChar(final int c) {
        return c == ' ' || c == '\n' || c == '\t';
    }

    /**
     * Format java code given by reading and writing streams.
     * @param reader - given reading stream.
     * @param writer - given writing stream.
     * @throws IOException when got exceptional situation
     * while reading or writing character.
     */
    @Override
    public void format(final IReader reader, final IWriter writer) throws IOException {
        int current = -1;
        int tabLevel = 0;

        while (reader.hasNext()) {
            int previous = current;
            current = reader.read();

            switch (current) {
                case '{':
                    tabLevel++;

                    if (previous != ' ' && previous != -1) {
                        writer.write(' ');
                    }

                    writer.write(current);
                    writer.write('\n');
                    tab(writer, tabLevel);
                    current = ' ';

                    break;

                case '}':
                    tabLevel--;

                    if (previous != '\n') {
                        writer.write('\n');
                    }

                    tab(writer, tabLevel);
                    writer.write(current);
                    break;

                case ';':
                    writer.write(current);
                    current = '\n';
                    writer.write(current);
                    break;

                case ' ':
                    if (!isEmptyChar(previous) && previous != '}') {
                        writer.write(current);
                    } else if (previous == '\n') {
                        current = previous;
                    }

                    break;

                case '\n':
                    current = previous;
                    break;

                default:
                    if (previous == '\n') {
                        tab(writer, tabLevel);

                        while (isEmptyChar(current)) {
                            current = nextNonEmptyChar(reader);
                        }
                    }

                    writer.write(current);
                    break;
            }
        }
    }
}
