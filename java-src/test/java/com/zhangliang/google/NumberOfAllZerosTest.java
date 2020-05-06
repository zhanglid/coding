package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfAllZerosTest {

    @Test
    public void testCase() {
        NumberOfAllZeros s = new NumberOfAllZeros();
        int ans = s.countZero("10011000");
        assertEquals(9, ans);
    }

    @Test
    public void testCase2() {
        NumberOfAllZeros s = new NumberOfAllZeros();
        int ans = s.countSubmatrixZero(new int[][] {
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {1, 1, 1, 0, 1},
        });
        assertEquals(18, ans);
    }
}
