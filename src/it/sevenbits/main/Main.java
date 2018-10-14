package it.sevenbits.main;

import it.sevenbits.formatter.Formatter;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        String example1 = "aaa { bbbb; ccc;}";
        String example2 = "while (inputStream.hasNext()) {\n" +
        "   char symbol = inputStream.read(); if (symbol == ' ')" +
        "{       whiteSpaceCount++;}    }";

        InputStreamReader reader = new InputStreamReader(
            new ByteArrayInputStream(example1.getBytes(StandardCharsets.UTF_8))
        );
        OutputStreamWriter writer = new OutputStreamWriter(System.out);

        Formatter formatter = new Formatter(4);
        formatter.format(reader, writer);

        reader.close();
        writer.close();
    }
}
