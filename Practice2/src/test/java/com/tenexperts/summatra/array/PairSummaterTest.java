package com.tenexperts.summatra.array;

import com.tenexperts.summatra.array.exception.ArraySummaterException;
import org.junit.Test;

import static org.junit.Assert.*;

public class PairSummaterTest {
    private static PairSummater summater = new PairSummater();

    @Test
    public void testSumSimple() throws ArraySummaterException {
        int[] testArr = new int[] {1, -8, 15, -14};
        assertEquals(summater.sum(testArr), 1);
    }

    @Test
    public void testSumEmptyArrayCase() throws ArraySummaterException {
        int[] testArr = new int[] {};
        assertEquals(summater.sum(testArr), 0);
    }

    @Test (expected = ArraySummaterException.class)
    public void testSumOddArrayLengthCase() throws ArraySummaterException {
        int[] testArr = new int[] {1, 2, 3};
        summater.sum(testArr);
    }
}