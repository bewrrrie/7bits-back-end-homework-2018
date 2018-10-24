package com.tenexperts.summatra.array;

/**
 * IArraySummater implementation that provides
 * method for array elements summation.
 */
public class SimpleSummater implements IArraySummater {

    /**
     * @param arr - input integers array.
     * @return sum of all input array elements;
     */
    public int sum(final int[] arr) {
        int sum = 0;

        for (int anArr : arr) {
            sum += anArr;
        }

        return sum;
    }
}
