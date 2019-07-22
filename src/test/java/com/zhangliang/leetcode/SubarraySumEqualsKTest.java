package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SubarraySumEqualsKTest {

    @Test
    public void testCase() {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        int ans = s.subarraySum(new int[] { 1, 1, 1 }, 2);
        assertEquals(2, ans);
    }
}
