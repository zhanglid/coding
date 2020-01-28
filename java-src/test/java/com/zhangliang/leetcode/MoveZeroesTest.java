package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MoveZeroesTest {

    @Test
    public void testCase() {
        MoveZeroes s = new MoveZeroes();
        int[] nums = new int[] { 0, 1, 0, 3, 12 };
        s.moveZeroes(nums);
        assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums);
    }
}
