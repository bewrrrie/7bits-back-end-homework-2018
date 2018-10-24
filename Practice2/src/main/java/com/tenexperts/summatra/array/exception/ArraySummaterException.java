package com.tenexperts.summatra.array.exception;

/**
 * Exception class for exceptional cases in IArraySummater behavior.
 */
public class ArraySummaterException extends Exception {

    /**
     * Exception constructor.
     * @param e - exception to pass throw.
     */
    public ArraySummaterException(final Exception e) {
        super(e);
    }

    /**
     * Exception constructor.
     * @param message - exceptional case description message.
     */
    public ArraySummaterException(final String message) {
        super(message);
    }

    /**
     * Exception constructor.
     * @param message - exceptional case description message.
     * @param e - exception to pass throw.
     */
    public ArraySummaterException(final String message, final Exception e) {
        super(message, e);
    }
}
