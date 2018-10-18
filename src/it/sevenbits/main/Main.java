package it.sevenbits.main;

import it.sevenbits.formatter.Formatter;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws Exception {
        String example1 = "aaa { bbbb; ccc;}";
        String example2 = "{{{{}}}}";
        String example3 = "while (inputStream.hasNext()) {" +
        "char symbol = inputStream.read(); if (symbol =" +
        "= ' '){       whiteSpaceCount++;}    }";

        byte[] bytes = example3.getBytes(StandardCharsets.UTF_8);

        InputStreamReader reader = new InputStreamReader(new ByteArrayInputStream(bytes));
        OutputStreamWriter writer = new OutputStreamWriter(System.out);

        Formatter formatter = new Formatter();
        formatter.format(reader, writer);

        reader.close();
        writer.close();
    }
}
