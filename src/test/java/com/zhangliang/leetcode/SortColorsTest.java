package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SortColorsTest {

    @Test
    public void testCase() {
        SortColors s = new SortColors();
        int[] input = new int[] { 2, 0, 2, 1, 1, 0 };
        s.sortColors(input);
        assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, input);
    }

    @Test
    public void testCase2() {
        SortColors s = new SortColors();
        int[] input = new int[] { 2, 0, 1 };
        s.sortColors(input);
        assertArrayEquals(new int[] { 0, 1, 2 }, input);
    }
}
