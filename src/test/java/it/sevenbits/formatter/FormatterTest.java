package it.sevenbits.formatter;

import com.google.common.base.Charsets;
import it.sevenbits.lexer.Lexer;
import it.sevenbits.reader.StringReader;
import it.sevenbits.writer.StringWriter;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.*;

public class FormatterTest {
    private final Formatter formatter = new Formatter();
    private final Charset charset = Charsets.UTF_8;
    private final int BYTE_SIZE = 8;
    private final int INITIAL_SIZE = Integer.MAX_VALUE / BYTE_SIZE;


    @Test
    public void testFormatTrivial() throws IOException {
        String input = "{{{}}}";
        String expected = "{\n" +
                          "    {\n" +
                          "        {\n" +
                          "            \n" +
                          "        }\n" +
                          "    }\n" +
                          "}";

        StringReader reader = new StringReader(input, charset);
        StringWriter writer = new StringWriter(INITIAL_SIZE);
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        reader.close();
        writer.close();

        assertEquals(expected, writer.toString(charset.toString()));
    }

    @Test
    public void testFormatStandard() throws IOException {
        String input = "while (inputStream.hasNext()) {char symbol = inputStream.read(\n);" +
                       "if (symbol == ' '){       whiteSpaceCount++;}    }";
        String expected = "while (inputStream.hasNext()) {\n" +
                          "    char symbol = inputStream.read();\n" +
                          "    if (symbol == ' ') {\n" +
                          "        whiteSpaceCount++;\n" +
                          "    }\n" +
                          "}";

        StringReader reader = new StringReader(input, charset);
        StringWriter writer = new StringWriter(INITIAL_SIZE);
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        reader.close();
        writer.close();

        assertEquals(expected, writer.toString(charset.toString()));
    }

    @Test
    public void testFormatMethod() throws IOException {
        String input = "public static void main(final String[] args) throws IOException {\n" +
        "    StringReader reader = new     StringReader(args[0],    STANDA\n" +
        "RD_CHARSET);\n" +
        "    StringWriter\n writer =    new StringWriter(Integer.MAX_VALUE / BYTE_SIZE);\n" +
        "    reader.close();\n" +
        "              writer.close();\n" +
        "}";
        String expected = "public static void main(final String[] args) throws IOException {\n" +
                          "    StringReader reader = new StringReader(args[0], STANDARD_CHARSET);\n" +
                          "    StringWriter writer = new StringWriter(Integer.MAX_VALUE / BYTE_SIZE);\n" +
                          "    reader.close();\n" +
                          "    writer.close();\n" +
                          "}";

        StringReader reader = new StringReader(input, charset);
        StringWriter writer = new StringWriter(INITIAL_SIZE);
        Lexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        reader.close();
        writer.close();

        assertEquals(expected, writer.toString(charset.toString()));
    }
}