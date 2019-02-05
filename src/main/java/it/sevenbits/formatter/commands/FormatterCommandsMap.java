package it.sevenbits.formatter.commands;

import it.sevenbits.lexer.Pair;
import it.sevenbits.lexer.TokenTypesMap;

import java.util.HashMap;

public class FormatterCommandsMap {
    private HashMap<String, IFormatterCommand> commandMap;
    private DefaultCommand defaultCommand;

    public FormatterCommandsMap() {
        commandMap = new HashMap<>();
        defaultCommand = new DefaultCommand();

        IFormatterCommand openBlockCommand = new OpenBlockCommand();
        IFormatterCommand closeBlockCommand = new CloseBlockCommand();
        IFormatterCommand semicolonCommand = new SemicolonCommand();

        commandMap.put(TokenTypesMap.OPEN_BLOCK_TYPE, openBlockCommand);
        commandMap.put(TokenTypesMap.CLOSE_BLOCK_TYPE, closeBlockCommand);
        commandMap.put(TokenTypesMap.SEMICOLON_TYPE, semicolonCommand);
    }

    public IFormatterCommand get(final String type) {
        return commandMap.getOrDefault(type, defaultCommand);
    }
}
