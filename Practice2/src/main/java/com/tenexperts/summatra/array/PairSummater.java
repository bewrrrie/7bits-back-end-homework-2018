package com.tenexperts.summatra.array;

import com.tenexperts.summatra.array.exception.ArraySummaterException;

/**
 * IArraySummater implementation.
 * Provides method for calculation of maximal
 * sum of neighboring elements
 */
public class PairSummater implements IArraySummater {

    /**
     * @param arr - input integer array.
     * @return maximal sum of pairs
     * of neighboring elements in integer input array.
     * @throws ArraySummaterException - throws when array has illegal length.
     */
    public int sum(final int[] arr) throws ArraySummaterException {
        if (arr.length % 2 != 0) {
            throw new ArraySummaterException("Array length is odd!");
        }

        if (arr.length == 0) {
            return 0;
        }

        int result = arr[0] + arr[1];

        for (int i = 1; i < arr.length / 2; i++) {
            int pairSum = arr[2 * i] + arr[2 * i + 1];

            if (pairSum > result) {
                result = pairSum;
            }
        }

        return result;
    }
}
