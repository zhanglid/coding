package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class RemoveElementTest {

    @Test
    public void testCase() {

        RemoveElement s = new RemoveElement();
        int[] input = new int[] { 3, 2, 2, 3 };

        int ans = s.removeElement(input, 3);
        assertArrayEquals(new int[] { 2, 2 }, Arrays.copyOfRange(input, 0, ans));
    }

    @Test
    public void testCase2() {

        RemoveElement s = new RemoveElement();
        int[] input = new int[] { 0, 1, 2, 2, 3, 0, 4, 2 };

        int ans = s.removeElement(input, 2);
        assertArrayEquals(new int[] { 0, 1, 3, 0, 4 }, Arrays.copyOfRange(input, 0, ans));
    }
}
