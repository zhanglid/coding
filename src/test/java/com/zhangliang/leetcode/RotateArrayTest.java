package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class RotateArrayTest {

    @Test
    public void testCase() {
        RotateArray s = new RotateArray();
        int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        s.rotate(input, 3);
        int[] expected = { 5, 6, 7, 1, 2, 3, 4 };
        assertArrayEquals(expected, input);
    }

    @Test
    public void testCase2() {
        RotateArray s = new RotateArray();
        int[] input = new int[] { -1, -100, 3, 99 };
        s.rotate(input, 2);
        int[] expected = { 3, 99, -1, -100 };
        assertArrayEquals(expected, input);
    }
}
