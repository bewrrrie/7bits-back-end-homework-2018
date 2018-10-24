package com.tenexperts.summatra.array;

import com.tenexperts.summatra.array.exception.ArraySummaterException;

/**
 * Array summater interface.
 * Provides method to sum integer array elements
 * in specific way.
 */
public interface IArraySummater {

    /**
     * @param arr - input array.
     * @return integer computed using input array elements values.
     * @throws ArraySummaterException - throws when
     * got an exceptional case in summation method behavior.
     */
    int sum(int[] arr) throws ArraySummaterException;
}
