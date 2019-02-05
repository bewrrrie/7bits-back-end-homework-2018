package it.sevenbits.lexer.lexemes;

import java.util.Objects;

public class CondenserState {
    private String name;

    public CondenserState(final String name) {
        this.name = name;
    }

    public String getName() {
        if (name == null) {
            throw new IllegalArgumentException("Name is null!");
        }

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CondenserState that = (CondenserState) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
