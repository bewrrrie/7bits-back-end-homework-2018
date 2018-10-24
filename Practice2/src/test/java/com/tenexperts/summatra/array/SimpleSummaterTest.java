package com.tenexperts.summatra.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleSummaterTest {
    private static SimpleSummater summater = new SimpleSummater();

    @Test
    public void testSumSimple() {
        int[] testArr = new int[] {1, -8, 15, -14, 56};
        assertEquals(summater.sum(testArr), 50);
    }

    @Test
    public void testSumEmptyArrayCase() {
        int[] testArr = new int[] {};
        assertEquals(summater.sum(testArr), 0);
    }
}