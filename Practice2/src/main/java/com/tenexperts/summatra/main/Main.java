package com.tenexperts.summatra.main;

import com.tenexperts.summatra.array.SimpleSummater;

/**
 * This class provides main entry-point method.
 */
final class Main {

    /**
     * Private constructor.
     * Forbids instance creation.
     */
    private Main() { }

    /**
     * Entry-point method.
     * @param args - command line arguments array.
     * @throws NumberFormatException - throws when arguments contains strings
     * which have bad format and can not be interpreted as integer.
     */
    public static void main(final String[] args) throws NumberFormatException {
        SimpleSummater summater = new SimpleSummater();
        int[] values = new int[args.length];

        try {
            for (int i = 0; i < args.length; i++) {
                values[i] = Integer.parseInt(args[i]);
            }

            System.out.println(summater.sum(values));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
