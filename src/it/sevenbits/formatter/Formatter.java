package it.sevenbits.formatter;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Formatter {
    private int tabSize;

    private Formatter() {}

    public Formatter(int tabSize) throws IllegalArgumentException {
        if (tabSize < 0) {
            throw new IllegalArgumentException("Tab size must be non-negative integer!");
        }

        this.tabSize = tabSize;
    }

    private void tab(OutputStreamWriter writer, int tabLevel) throws IOException {
        int spacesCount = tabSize * tabLevel;

        for (int i = 0; i < spacesCount; i++) {
            writer.write(' ');
        }
    }

    private boolean isEmptyChar(char c) {
        return c == ' ' || c == '\n' || c == '\t';
    }

    public void format(InputStreamReader reader, OutputStreamWriter writer) throws IOException {
        int tabLevel = 0;
        int code = reader.read();
        char current = ' ';

        while (code != -1) {
            char previous = current;
            current = (char) code;

            switch (current) {
                case '{':
                    writer.write(current);
                    writer.write('\n');
                    current = '\n';
                    tabLevel++;
                    break;

                case '}':
                    writer.write(current);
                    tabLevel--;
                    break;

                case ' ':
                    current = ' ';
                    break;

                case ';':
                    writer.write(current);
                    current = '\n';
                    writer.write(current);
                    break;

                default:
                    if (isEmptyChar(previous)) {
                        tab(writer, tabLevel);
                    }

                    writer.write(current);
            }

            code = reader.read();
        }
    }
}
