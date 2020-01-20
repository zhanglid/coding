package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ShuffleAnArrayTest {

    @Test
    public void testCase() {
        ShuffleAnArray.Solution s = new ShuffleAnArray.Solution(new int[] { 1, 2, 3 });
        s.shuffle();
        assertArrayEquals(new int[] { 1, 2, 3 }, s.reset());
    }
}
