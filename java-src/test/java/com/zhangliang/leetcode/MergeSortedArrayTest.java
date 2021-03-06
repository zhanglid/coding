package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortedArrayTest {

    @Test
    public void testCase() {
        MergeSortedArray s = new MergeSortedArray();

        int[] input = new int[] { 1, 2, 3, 0, 0, 0 };
        s.merge(input, 3, new int[] { 2, 5, 6 }, 3);
        assertArrayEquals(new int[] { 1, 2, 2, 3, 5, 6 }, input);
    }

    @Test
    public void testCase2() {
        MergeSortedArray s = new MergeSortedArray();

        int[] input = new int[] { 1, 2, 4, 5, 6, 0 };
        s.merge(input, 5, new int[] { 3 }, 1);
        assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, input);
    }
}
