package it.sevenbits.lexer;

import java.util.HashMap;

public class TokenTypesMap {
    private HashMap<String, String> tokenTypesMap;

    public static final String DEFAULT_TYPE = "DEFAULT";
    public static final String OPEN_BLOCK_TYPE = "OPEN_BLOCK";
    public static final String CLOSE_BLOCK_TYPE = "CLOSE_BLOCK";
    public static final String OPEN_BRACKET_TYPE = "OPEN_BRACKET";
    public static final String CLOSE_BRACKET_TYPE = "CLOSE_BRACKET";
    public static final String SEMICOLON_TYPE = "SEMICOLON";
    public static final String ONE_LINE_COMMENT = "//";
    public static final String OPEN_MULTI_LINE_COMMENT = "/*";
    public static final String CLOSE_MULTI_LINE_COMMENT = "*/";

    public TokenTypesMap() {
        tokenTypesMap = new HashMap<>();

        tokenTypesMap.put("{", OPEN_BLOCK_TYPE);
        tokenTypesMap.put("}", CLOSE_BLOCK_TYPE);
        //tokenTypesMap.put("(", OPEN_BRACKET_TYPE);
        //tokenTypesMap.put(")", CLOSE_BRACKET_TYPE);
        tokenTypesMap.put(";", SEMICOLON_TYPE);
        tokenTypesMap.put("//", ONE_LINE_COMMENT);
        tokenTypesMap.put("/*", OPEN_MULTI_LINE_COMMENT);
        tokenTypesMap.put("*/", CLOSE_MULTI_LINE_COMMENT);
    }

    public String getType(final String lexeme) {

        for (String key : tokenTypesMap.keySet()) {
            if (lexeme.contains(key)) {
                return tokenTypesMap.get(key);
            }
        }

        return DEFAULT_TYPE;
    }
}
