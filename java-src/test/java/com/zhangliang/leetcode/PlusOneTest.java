package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class PlusOneTest {

    @Test
    public void testCase() {
        PlusOne s = new PlusOne();
        int[] ans = s.plusOne(new int[] { 1, 2, 3 });
        assertArrayEquals(new int[] { 1, 2, 4 }, ans);
    }

    @Test
    public void testCase2() {
        PlusOne s = new PlusOne();
        int[] ans = s.plusOne(new int[] { 4, 3, 2, 1 });
        assertArrayEquals(new int[] { 4, 3, 2, 2 }, ans);
    }
}
