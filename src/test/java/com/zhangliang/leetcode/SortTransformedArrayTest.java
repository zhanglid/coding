package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SortTransformedArrayTest {

    @Test
    public void testCase() {
        SortTransformedArray s = new SortTransformedArray();
        int[] ans = s.sortTransformedArray(new int[] { -4, -2, 2, 4 }, 1, 3, 5);
        assertArrayEquals(new int[] { 3, 9, 15, 33 }, ans);
    }

    @Test
    public void errCase() {
        SortTransformedArray s = new SortTransformedArray();
        int[] ans = s.sortTransformedArray(new int[] { -4, -2, 2, 4 }, -1, 3, 5);
        assertArrayEquals(new int[] { -23, -5, 1, 7 }, ans);
    }

    @Test
    public void errCase2() {
        SortTransformedArray s = new SortTransformedArray();
        int[] ans = s.sortTransformedArray(new int[] { -4, -2, 2, 4 }, 0, -1, 5);
        assertArrayEquals(new int[] { 1, 3, 7, 9 }, ans);
    }
}
