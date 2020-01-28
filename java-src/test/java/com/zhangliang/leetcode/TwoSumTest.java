package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void testDefault() {
        TwoSum s = new TwoSum();
        int[] ans = s.twoSum(new int[] { 2, 15, 11, 7 }, 9);
        assertArrayEquals(new int[] { 0, 3 }, ans);
    }

}
